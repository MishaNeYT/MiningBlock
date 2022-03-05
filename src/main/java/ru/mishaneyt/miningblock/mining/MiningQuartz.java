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

public class MiningQuartz implements Listener {
    static final Main plugin = Main.getPlugin(Main.class);

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        final Block block = e.getBlock();

        String moneyQuartz = String.valueOf(FileUtil.getMiningConfig().getInt("QUARTZ.MoneyDrop"));

        if (!plugin.getConfig().getStringList("Settings.EnableWorld").contains(player.getLocation().getWorld().getName()))
            return;

        if (FileUtil.getMiningConfig().getBoolean("QUARTZ.Enable")) {
            if (!(block.getType() == Material.QUARTZ_ORE)) return;

            if (plugin.getConfig().getBoolean("Settings.EnableEditOre")) {
                e.setExpToDrop(0);
                e.getBlock().setType(Material.AIR);
            } else {
                e.setCancelled(true);
                e.setExpToDrop(FileUtil.getMiningConfig().getInt("QUARTZ.ExpDrop"));
                e.getPlayer().giveExp(e.getExpToDrop());

                if (plugin.getConfig().getBoolean("Settings.EnableVault")) {
                    Main.economy.depositPlayer(player, FileUtil.getMiningConfig().getInt("QUARTZ.MoneyDrop"));
                }

                if (FileUtil.getMiningConfig().getBoolean("QUARTZ.CommandBreak.enable")) {
                    for (String cmd : FileUtil.getMiningConfig().getStringList("QUARTZ.CommandBreak.command")) {
                        cmd = cmd.replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }
                }

                if (plugin.getConfig().getBoolean("Actionbar.EnableActionbar")) {
                    String money = Utils.color(((Utils.getString("Actionbar.Message"))).replaceAll("%money%", moneyQuartz));
                    money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                }

                if (plugin.getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                    for (String message : plugin.getConfig().getStringList("MessageToChat.Message")) {
                        message = message.replaceAll("%money%", moneyQuartz);
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                        player.sendMessage(Utils.color(message));
                    }
                }

                if (plugin.getConfig().getBoolean("TitleOnPickup.EnableTitles")) {
                    String titleText = Utils.color(plugin.getConfig().getString("TitleOnPickup.Title")).replaceAll("%money%", moneyQuartz);
                    String subtitleText = Utils.color(plugin.getConfig().getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyQuartz);

                    titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                    subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                    player.sendTitle(titleText, subtitleText, plugin.getConfig()
                            .getInt("TitleOnPickup.FadeIn"), plugin.getConfig()
                            .getInt("TitleOnPickup.Stay"), plugin.getConfig()
                            .getInt("TitleOnPickup.FadeOut"));
                }

                if (FileUtil.getMiningConfig().getBoolean("QUARTZ.Drop.Enable")) {
                    DropsItems.getDropQuartz(block);
                }
                if (FileUtil.getMiningConfig().getBoolean("QUARTZ.AutoPickup.Enable")) {
                    AutoPickupItems.getAutoPickupQuartz(player);
                }

                if (plugin.getConfig().getBoolean("Sound.EnableSoundPickup")) {
                    Utils.getSound(player);
                }

                if (FileUtil.getMiningConfig().getBoolean("QUARTZ.ParticleBreak.enable")) {
                    Location blockLocation = e.getBlock().getLocation();
                    Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ());
                    blockLocation.getWorld().spawnParticle(Particle.valueOf(FileUtil.getMiningConfig().getString("QUARTZ.ParticleBreak.particle")),
                            particleLocation, FileUtil.getMiningConfig().getInt("QUARTZ.ParticleBreak.Locations.amount"),
                            FileUtil.getMiningConfig().getInt("QUARTZ.ParticleBreak.Locations.locationX"),
                            FileUtil.getMiningConfig().getInt("QUARTZ.ParticleBreak.Locations.locationY"),
                            FileUtil.getMiningConfig().getInt("QUARTZ.ParticleBreak.Locations.locationZ"));
                }

                block.setType(Material.valueOf(FileUtil.getMiningConfig().getString("QUARTZ.ReplaceBlock")));
                Bukkit.getServer().getScheduler().runTaskLater(plugin, () -> block.setType(Material.QUARTZ_ORE), FileUtil.getMiningConfig().getInt("QUARTZ.Delay") * 20L);
            }
        }
    }
}