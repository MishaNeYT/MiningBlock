package ru.mishaneyt.miningblock.mining;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.config.ConfigManager;
import ru.mishaneyt.miningblock.config.ConfigUtils;
import ru.mishaneyt.miningblock.mining.features.*;
import ru.mishaneyt.miningblock.utils.Logger;
import ru.mishaneyt.miningblock.utils.UtilsManager;

import java.util.ArrayList;

public class MiningListener implements Listener {
    public static ArrayList<Player> toggleEdit = new ArrayList<>();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMining(BlockBreakEvent e) {
        FileConfiguration configMining = ConfigUtils.getMiningConfig();

        Player p = e.getPlayer();
        Block b = e.getBlock();
        Material block = b.getType();

        Location loc = p.getLocation();
        String world = loc.getWorld().getName();

        if (!ConfigManager.ENABLE_WORLDS.contains(world)) return;
        if (!ConfigManager.EDITORE) if (p.getGameMode() == GameMode.CREATIVE) return;
        if (!configMining.getBoolean("MiningBlocks.Enable")) {
            Logger.warn("В конфиге mining.yml Раздел MiningBlocks.Enable отключён, либо возникла проблема с работой, воспользуйтесь командой /miningblock reload.");
            UtilsManager.sendError(p);
            return;
        }


        if (block == null) {
            Logger.warn("Указан не верный айди блока.");
            UtilsManager.sendError(p);
            return;
        }
        if (toggleEdit.contains(p)) return;

        if (!configMining.getConfigurationSection("MiningBlocks").getKeys(false).contains(block.toString())) return;
        ConfigurationSection section = configMining.getConfigurationSection("MiningBlocks." + block);
        if (section == null) return;


        int delay = section.getInt("Delay");
        if (!section.isInt("Delay")) {
            Logger.warn("Укажите Delay, без него блок не будет работать.");
            UtilsManager.sendError(p);
            return;
        }

        int money = section.getInt("MoneyDrop");
        int exp = section.getInt("ExpDrop");

        String replace = section.getString("ReplaceBlock");
        if (replace == null) {
            Logger.warn("Укажите ReplaceBlock, без него блок не будет работать.");
            UtilsManager.sendError(p);
            return;
        }

        String drop_item = section.getString("Drop.DropItem");
        int drop_item_amount = section.getInt("Drop.Amount");

        String autopickup_item = section.getString("AutoPickup.DropItem");
        int autopickup_item_amount = section.getInt("AutoPickup.Amount");

        String command = section.getString("CommandBreak");
        if (command != null) {
            command = command.replace("%player%", p.getName());
            Papi.connect(p, command);
        }


        e.setCancelled(true);

        if (p.getInventory().firstEmpty() == -1) FullInventory.sendTitle(p);

        if (ConfigManager.VAULT_ENABLE && section.isInt("MoneyDrop"))
            Main.getEconomy().depositPlayer(p, money);

        if (section.isInt("ExpDrop")) e.setExpToDrop(exp);

        if (section.isString("Drop.DropItem") && section.isInt("Drop.Amount"))
            DropItem.dropItem(b, drop_item, drop_item_amount);
        if (section.isString("AutoPickup.DropItem") && section.isInt("AutoPickup.Amount"))
            AutoPickup.pickupItem(p, autopickup_item, autopickup_item_amount);

        try {
            PlaySound.playSound(p);
        } catch (Exception e1) {
            Logger.warn("Пожалуйста, проверьте звук в config.yml. Ваша версия ядра, может его не поддерживать.");
        }

        Title.sendTitle(p, money);
        Actionbar.sendActionbar(p, money);
        Chat.sendMessage(p, money);

        if (section.isString("CommandBreak")) Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);

        b.setType(Material.valueOf(replace));
        Main.getInstance().getServer().getScheduler().runTaskLater(Main.getInstance(), () -> b.setType(block), delay * 20L);
    }
}