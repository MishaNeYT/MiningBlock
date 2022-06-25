package ru.mishaneyt.miningblock.mining;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.config.ConfigManager;
import ru.mishaneyt.miningblock.mining.features.*;
import ru.mishaneyt.miningblock.mining.features.Sound;
import ru.mishaneyt.miningblock.utils.Logger;

import java.util.ArrayList;

public class MiningListener implements Listener {
    public final Main main;
    private final ArrayList<Player> toggleEdit = new ArrayList<>();
    
    public MiningListener(Main main) {
        this.main = main;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMining(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();

        Material material = b.getType();
        if (material == null) return;

        if (!ConfigManager.getConfig().getStringList("Settings.Worlds").contains(p.getLocation().getWorld().getName())) return;
        if (getToggleEdit().contains(p)) return;

        if (ConfigManager.getMining().getConfigurationSection("MiningBlocks").getKeys(false).contains(material.toString())) {
            ConfigurationSection section = ConfigManager.getMining().getConfigurationSection("MiningBlocks." + material);
            if (section == null) return;

            // Delay check
            int delay = section.getInt("Delay");
            if (!section.isInt("Delay")) {
                Logger.warn("Укажите задержку для блока, без него блок не будет работать.");
                return;
            }

            int money = section.getInt("MoneyDrop");
            int exp = section.getInt("ExpDrop");

            // Replace block check
            String replace = section.getString("ReplaceBlock");
            if (replace == null) {
                Logger.warn("Укажите материал блока, который будет появлятся после добычи блока, без него блок не будет работать.");
                return;
            }

            String drop_item = section.getString("Drop.Item");
            int drop_item_amount = section.getInt("Drop.Amount");

            String autopickup_item = section.getString("AutoPickup.Item");
            int autopickup_item_amount = section.getInt("AutoPickup.Amount");

            // Command check
            String command = section.getString("CommandBreak");


            // Cancel event
            e.setCancelled(true);

            // Check creative mode
            if (!ConfigManager.getConfig().getBoolean("Settings.MineProtection.BreakCreative")) {
                if (p.getGameMode() == GameMode.CREATIVE) {
                    p.sendMessage("Запрещено копать блок в режиме креатив!");
                    return;
                }
            }

            // Check fly mode
            if (!ConfigManager.getConfig().getBoolean("Settings.MineProtection.BreakFly")) {
                if (p.isFlying()) {
                    p.sendMessage("Запрещено копать блок в полёте!");
                    return;
                }
            }

            // Check enable vault and check int MoneyDrop
            if (ConfigManager.getConfig().getBoolean("Settings.Depends.Vault") && section.isInt("MoneyDrop"))
                this.main.getEconomy().depositPlayer(p, money);

            // Check int ExpDrop
            if (section.isInt("ExpDrop"))
                e.setExpToDrop(exp);

            // Check Drop
            if (section.isString("Drop.Item") && section.isInt("Drop.Amount"))
                b.getLocation().add(0.5D, 2.0D, 0.5D).getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.valueOf(drop_item), drop_item_amount));


            // Check AutoPickup
            if (section.isString("AutoPickup.Item") && section.isInt("AutoPickup.Amount"))
                p.getInventory().addItem(new ItemStack(Material.valueOf(autopickup_item), autopickup_item_amount));

            // Send sound on pickup
            try {
                Sound.play(p);
            } catch (Exception e1) {
                Logger.warn("Пожалуйста, проверьте звук в config.yml. Ваша версия ядра может его не поддерживать.");
            }

            // Send message type
            Title.send(p, money);
            Actionbar.send(p, money);
            Chat.send(p, money);

            // Check command
            if (section.isString("CommandBreak"))
                if (command != null) {
                    command = command.replace("%player%", p.getName()).replace("&", "§");
                    Papi.connect(p, command);

                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                }

            // Replace block
            b.setType(Material.valueOf(replace));
            this.main.getServer().getScheduler().runTaskLater(this.main, () -> b.setType(material), delay * 20L);
        }
    }

    public ArrayList<Player> getToggleEdit() {
        return this.toggleEdit;
    }
}