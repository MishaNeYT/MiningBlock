package ru.mishaneyt.miningblock.mining;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.utils.mining.AutoPickupItems;
import ru.mishaneyt.miningblock.utils.mining.DropsItems;
import ru.mishaneyt.miningblock.utils.FileUtil;
import ru.mishaneyt.miningblock.utils.Utils;

public class MiningDiamond implements Listener {
    static final Main plugin = Main.getPlugin(Main.class);

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        final Block block = e.getBlock();

        String moneyDiamond = String.valueOf(FileUtil.getMiningConfig().getInt("DIAMOND.MoneyDrop"));

        if (!plugin.getConfig().getStringList("Settings.EnableWorld").contains(player.getLocation().getWorld().getName()))
            return;

        if (FileUtil.getMiningConfig().getBoolean("DIAMOND.Enable")) {
            if (!(block.getType() == Material.DIAMOND_ORE)) return;

            if (plugin.getConfig().getBoolean("Settings.EnableEditOre")) {
                e.setExpToDrop(0);
                e.getBlock().setType(Material.AIR);
            } else {
                e.setCancelled(true);
                e.setExpToDrop(FileUtil.getMiningConfig().getInt("DIAMOND.ExpDrop"));
                e.getPlayer().giveExp(e.getExpToDrop());

                if (plugin.getConfig().getBoolean("Settings.EnableVault")) {
                    Main.economy.depositPlayer(player, FileUtil.getMiningConfig().getInt("DIAMOND.MoneyDrop"));
                }

                if (FileUtil.getMiningConfig().getBoolean("DIAMOND.CommandBreak.enable")) {
                    for (String cmd : FileUtil.getMiningConfig().getStringList("DIAMOND.CommandBreak.command")) {
                        cmd = cmd.replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }
                }

                if (plugin.getConfig().getBoolean("Actionbar.EnableActionbar")) {
                    String money = Utils.color(((Utils.getString("Actionbar.Message"))).replaceAll("%money%", moneyDiamond));
                    money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                }

                if (plugin.getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                    for (String message : plugin.getConfig().getStringList("MessageToChat.Message")) {
                        message = message.replaceAll("%money%", moneyDiamond);
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                        player.sendMessage(Utils.color(message));
                    }
                }

                if (plugin.getConfig().getBoolean("TitleOnPickup.EnableTitles")) {
                    String titleText = Utils.color(plugin.getConfig().getString("TitleOnPickup.Title")).replaceAll("%money%", moneyDiamond);
                    String subtitleText = Utils.color(plugin.getConfig().getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyDiamond);

                    titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                    subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                    player.sendTitle(titleText, subtitleText, plugin.getConfig()
                            .getInt("TitleOnPickup.FadeIn"), plugin.getConfig()
                            .getInt("TitleOnPickup.Stay"), plugin.getConfig()
                            .getInt("TitleOnPickup.FadeOut"));
                }

                if (FileUtil.getMiningConfig().getBoolean("DIAMOND.Drop.Enable")) {
                    DropsItems.getDropDiamond(block);
                }
                if (FileUtil.getMiningConfig().getBoolean("DIAMOND.AutoPickup.Enable")) {
                    AutoPickupItems.getAutoPickupDiamond(player);
                }

                if (plugin.getConfig().getBoolean("Sound.EnableSoundPickup")) {
                    Utils.getSound(player);
                }

                if (FileUtil.getMiningConfig().getBoolean("DIAMOND.ParticleBreak.enable")) {
                    Location blockLocation = e.getBlock().getLocation();
                    Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ());
                    blockLocation.getWorld().spawnParticle(Particle.valueOf(FileUtil.getMiningConfig().getString("DIAMOND.ParticleBreak.particle")),
                            particleLocation, FileUtil.getMiningConfig().getInt("DIAMOND.ParticleBreak.Locations.amount"),
                            FileUtil.getMiningConfig().getInt("DIAMOND.ParticleBreak.Locations.locationX"),
                            FileUtil.getMiningConfig().getInt("DIAMOND.ParticleBreak.Locations.locationY"),
                            FileUtil.getMiningConfig().getInt("DIAMOND.ParticleBreak.Locations.locationZ"));
                }

                block.setType(Material.valueOf(FileUtil.getMiningConfig().getString("DIAMOND.ReplaceBlock")));
                Bukkit.getServer().getScheduler().runTaskLater(plugin, () -> block.setType(Material.DIAMOND_ORE), FileUtil.getMiningConfig().getInt("DIAMOND.Delay") * 20L);
            }
        }
    }
}