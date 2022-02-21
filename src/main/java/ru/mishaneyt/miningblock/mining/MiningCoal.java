package ru.mishaneyt.miningblock.mining;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.utils.mining.AutoPickupItems;
import ru.mishaneyt.miningblock.utils.mining.DropsItems;
import ru.mishaneyt.miningblock.utils.FileUtil;
import ru.mishaneyt.miningblock.utils.Utils;

public class MiningCoal implements Listener {

    @EventHandler
    private void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        final Block block = e.getBlock();

        String moneyCoal = String.valueOf(FileUtil.getMiningConfig().getInt("COAL.MoneyDrop"));

        if (Main.getInstance().getConfig().getStringList("Settings.EnableWorld").contains(player.getLocation().getWorld().getName())) {
            if (FileUtil.getMiningConfig().getBoolean("COAL.Enable")) {
                if (block.getType() == Material.COAL_ORE) {
                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableEditOre")) {
                        e.setExpToDrop(0);
                        e.getBlock().setType(Material.AIR);
                    } else {
                        e.setCancelled(true);
                        e.setExpToDrop(FileUtil.getMiningConfig().getInt("COAL.ExpDrop"));
                        e.getPlayer().giveExp(e.getExpToDrop());

                        if (Main.getInstance().getConfig().getBoolean("Settings.EnableVault")) {
                            Main.economy.depositPlayer(player, FileUtil.getMiningConfig().getInt("COAL.MoneyDrop"));
                        }

                        if (FileUtil.getMiningConfig().getBoolean("COAL.CommandBreak.enable")) {
                            for (String cmd : FileUtil.getMiningConfig().getStringList("COAL.CommandBreak.command")) {
                                cmd = cmd.replaceAll("%player%", player.getName());
                                cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                            }
                        }

                        if (Main.getInstance().getConfig().getBoolean("Actionbar.EnableActionbar")) {
                            String money = Utils.color(Utils.getString("Actionbar.Message")).replaceAll("%money%", moneyCoal);
                            money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                        }

                        if (Main.getInstance().getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                            for (String message : Main.getInstance().getConfig().getStringList("MessageToChat.Message")) {
                                message = message.replaceAll("%money%", moneyCoal);
                                message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                player.sendMessage(Utils.color(message));
                            }
                        }

                        if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.EnableTitles")) {
                            String titleText = Utils.color(Main.getInstance().getConfig().getString("TitleOnPickup.Title")).replaceAll("%money%", moneyCoal);
                            String subtitleText = Utils.color(Main.getInstance().getConfig().getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyCoal);

                            titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                            subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                            player.sendTitle(titleText, subtitleText, Main.getInstance().getConfig()
                                    .getInt("TitleOnPickup.FadeIn"), Main.getInstance().getConfig()
                                    .getInt("TitleOnPickup.Stay"), Main.getInstance().getConfig()
                                    .getInt("TitleOnPickup.FadeOut"));
                        }

                        if (FileUtil.getMiningConfig().getBoolean("COAL.Drop.Enable")) {
                            DropsItems.getDropCoal(block);
                        }
                        if (FileUtil.getMiningConfig().getBoolean("COAL.AutoPickup.Enable")) {
                            AutoPickupItems.getAutoPickupCoal(player);
                        }

                        if (Main.getInstance().getConfig().getBoolean("Sound.EnableSoundPickup")) {
                            Utils.getSound(player);
                        }

                        if (FileUtil.getMiningConfig().getBoolean("COAL.ParticleBreak.enable")) {
                            Location blockLocation = e.getBlock().getLocation();
                            Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ());
                            blockLocation.getWorld().spawnParticle(Particle.valueOf(FileUtil.getMiningConfig().getString("COAL.ParticleBreak.particle")),
                                    particleLocation, FileUtil.getMiningConfig().getInt("COAL.ParticleBreak.Locations.amount"),
                                    FileUtil.getMiningConfig().getInt("COAL.ParticleBreak.Locations.locationX"),
                                    FileUtil.getMiningConfig().getInt("COAL.ParticleBreak.Locations.locationY"),
                                    FileUtil.getMiningConfig().getInt("COAL.ParticleBreak.Locations.locationZ"));
                        }

                        block.setType(Material.valueOf(FileUtil.getMiningConfig().getString("COAL.ReplaceBlock")));
                        Main.getInstance().getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.COAL_ORE), FileUtil.getMiningConfig().getInt("COAL.Delay") * 20L);
                    }
                }
            }
        }
    }
}