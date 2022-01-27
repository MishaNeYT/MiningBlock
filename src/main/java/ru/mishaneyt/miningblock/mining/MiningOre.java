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
import org.bukkit.inventory.ItemStack;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.Utils;

import java.util.Objects;

public class MiningOre implements Listener {

    @EventHandler
    private void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        final Block block = e.getBlock();
        Material ore = block.getType();
        String location = player.getLocation().getWorld().getName();

        String enableSound = Utils.getString("Sound.SoundPickup");
        String moneyCoal = String.valueOf(Utils.getInt(Integer.valueOf("Mining.COAL.MoneyDrop")));
        String moneyIron = String.valueOf(Utils.getInt(Integer.valueOf("Mining.IRON.MoneyDrop")));
        String moneyGold = String.valueOf(Utils.getInt(Integer.valueOf("Mining.GOLD.MoneyDrop")));
        String moneyDiamond = String.valueOf(Utils.getInt(Integer.valueOf("Mining.DIAMOND.MoneyDrop")));
        String moneyEmerald = String.valueOf(Utils.getInt(Integer.valueOf("Mining.EMERALD.MoneyDrop")));

        if (Utils.getBoolean(Boolean.valueOf("Settings.EnableEditOre")) && player.hasPermission(Utils.getString("Settings.Permission"))) {
            if (Main.getInstance().getConfig().getStringList("Settings.EnableWorld").contains(location)) {
                if (ore == Material.COAL_ORE || ore == Material.IRON_ORE || ore == Material.GOLD_ORE || ore == Material.DIAMOND_ORE || ore == Material.EMERALD_ORE) {
                    e.setExpToDrop(0);
                    block.setType(Material.AIR);
                    return;
                }
            }
        }

        if (Main.getInstance().getConfig().getStringList("Settings.EnableWorld").contains(location)) {
            if (Utils.getBoolean(Boolean.valueOf("Mining.COAL.Enable"))) {
                if (ore == Material.COAL_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Utils.getInt(Integer.valueOf("Mining.COAL.ExpDrop")));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Utils.getBoolean(Boolean.valueOf("Settings.EnableVault"))) {
                        Main.economy.depositPlayer(player, Utils.getInt(Integer.valueOf("Mining.COAL.MoneyDrop")));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.COAL.CommandBreak.enable"))) {
                        for (String cmd : Main.getInstance().getConfig().getStringList("Mining.COAL.CommandBreak.command")) {
                            cmd = cmd.replaceAll("%player%", player.getName());
                            cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                        }
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Actionbar.EnableActionbar"))) {
                        String money = Utils.color(Utils.getString("Actionbar.Message")).replaceAll("%money%", moneyCoal);
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("MessageToChat.EnableMessageToChat"))) {
                        for (String message : Main.getInstance().getConfig().getStringList("MessageToChat.Message")) {
                            message = message.replaceAll("%money%", moneyCoal);
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            player.sendMessage(Utils.color(message));
                        }
                    }

                    if (Utils.getBoolean(Boolean.valueOf("TitleOnPickup.EnableTitles"))) {
                        String titleText = Utils.color(Utils
                                .getString("TitleOnPickup.Title")).replaceAll("%money%", moneyCoal);
                        String subtitleText = Utils.color(Utils
                                .getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyCoal);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Utils
                                .getInt(Integer.valueOf("TitleOnPickup.FadeIn")), Utils
                                .getInt(Integer.valueOf("TitleOnPickup.Stay")), Utils
                                .getInt(Integer.valueOf("TitleOnPickup.FadeOut")));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.COAL.Drop.Enable"))) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(Utils.getString("Mining.COAL.Drop.DropBlock")), Utils.getInt(Integer.valueOf("Mining.COAL.Drop.Amount"))));
                    }
                    if (Utils.getBoolean(Boolean.valueOf("Mining.COAL.AutoPickup.Enable"))) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(Utils.getString("Mining.COAL.AutoPickup.PickupBlock")), Utils.getInt(Integer.valueOf("Mining.COAL.AutoPickup.Amount"))));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Settings.EnableSoundPickup"))) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.COAL.ParticleBreak.enable"))) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ());
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Utils.getString("Mining.COAL.ParticleBreak.particle")),
                                particleLocation, Utils.getInt(Integer.valueOf("Mining.COAL.ParticleBreak.Locations.amount")),
                                Utils.getInt(Integer.valueOf("Mining.COAL.ParticleBreak.Locations.locationX")),
                                Utils.getInt(Integer.valueOf("Mining.COAL.ParticleBreak.Locations.locationY")),
                                Utils.getInt(Integer.valueOf("Mining.COAL.ParticleBreak.Locations.locationZ")));
                    }

                    block.setType(Material.valueOf(Utils.getString("Mining.COAL.ReplaceBlock")));
                    Main.getInstance().getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.COAL_ORE), Utils.getInt(Integer.valueOf("Mining.COAL.Delay")) * 20L);
                }
            }


            if (Utils.getBoolean(Boolean.valueOf("Mining.IRON.Enable"))) {
                if (ore == Material.IRON_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Utils.getInt(Integer.valueOf("Mining.IRON.ExpDrop")));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Utils.getBoolean(Boolean.valueOf("Settings.EnableVault"))) {
                        Main.economy.depositPlayer(player, Utils.getInt(Integer.valueOf("Mining.IRON.MoneyDrop")));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.IRON.CommandBreak.enable"))) {
                        for (String cmd : Main.getInstance().getConfig().getStringList("Mining.IRON.CommandBreak.command")) {
                            cmd = cmd.replaceAll("%player%", player.getName());
                            cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                        }
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Actionbar.EnableActionbar"))) {
                        String money = Utils.color(Objects.requireNonNull(((Utils.getString("Actionbar.Message")))).replaceAll("%money%", moneyIron));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (Utils.getBoolean(Boolean.valueOf("MessageToChat.EnableMessageToChat"))) {
                        for (String message : Main.getInstance().getConfig().getStringList("MessageToChat.Message")) {
                            message = message.replaceAll("%money%", moneyIron);
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            player.sendMessage(Utils.color(message));
                        }
                    }

                    if (Utils.getBoolean(Boolean.valueOf("TitleOnPickup.EnableTitles"))) {
                        String titleText = Utils.color(Utils
                                .getString("TitleOnPickup.Title")).replaceAll("%money%", moneyIron);
                        String subtitleText = Utils.color(Utils
                                .getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyIron);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Utils
                                .getInt(Integer.valueOf("TitleOnPickup.FadeIn")), Utils
                                .getInt(Integer.valueOf("TitleOnPickup.Stay")), Utils
                                .getInt(Integer.valueOf("TitleOnPickup.FadeOut")));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.IRON.Drop.Enable"))) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(Utils.getString("Mining.IRON.Drop.DropBlock")), Utils.getInt(Integer.valueOf("Mining.IRON.Drop.Amount"))));
                    }
                    if (Utils.getBoolean(Boolean.valueOf("Mining.IRON.AutoPickup.Enable"))) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(Utils.getString("Mining.IRON.AutoPickup.PickupBlock")), Utils.getInt(Integer.valueOf("Mining.IRON.AutoPickup.Amount"))));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Settings.EnableSoundPickup"))) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.IRON.ParticleBreak.enable"))) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ());
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Utils.getString("Mining.IRON.ParticleBreak.particle")),
                                particleLocation, Utils.getInt(Integer.valueOf("Mining.IRON.ParticleBreak.Locations.amount")),
                                Utils.getInt(Integer.valueOf("Mining.IRON.ParticleBreak.Locations.locationX")),
                                Utils.getInt(Integer.valueOf("Mining.IRON.ParticleBreak.Locations.locationY")),
                                Utils.getInt(Integer.valueOf("Mining.IRON.ParticleBreak.Locations.locationZ")));
                    }

                    block.setType(Material.valueOf(Utils.getString("Mining.IRON.ReplaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.IRON_ORE), Utils.getInt(Integer.valueOf("Mining.IRON.Delay")) * 20L);
                }
            }


            if (Utils.getBoolean(Boolean.valueOf("Mining.GOLD.Enable"))) {
                if (ore == Material.GOLD_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Utils.getInt(Integer.valueOf("Mining.GOLD.ExpDrop")));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Utils.getBoolean(Boolean.valueOf("Settings.EnableVault"))) {
                        Main.economy.depositPlayer(player, Utils.getInt(Integer.valueOf("Mining.GOLD.MoneyDrop")));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.GOLD.CommandBreak.enable"))) {
                        for (String cmd : Main.getInstance().getConfig().getStringList("Mining.GOLD.CommandBreak.command")) {
                            cmd = cmd.replaceAll("%player%", player.getName());
                            cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                        }
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Actionbar.EnableActionbar"))) {
                        String money = Utils.color(((Utils.getString("Actionbar.Message"))).replaceAll("%money%", moneyGold));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("MessageToChat.EnableMessageToChat"))) {
                        for (String message : Main.getInstance().getConfig().getStringList("MessageToChat.Message")) {
                            message = message.replaceAll("%money%", moneyGold);
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            player.sendMessage(Utils.color(message));
                        }
                    }

                    if (Utils.getBoolean(Boolean.valueOf("TitleOnPickup.EnableTitles"))) {
                        String titleText = Utils.color(Utils
                                .getString("TitleOnPickup.Title")).replaceAll("%money%", moneyGold);
                        String subtitleText = Utils.color(Utils
                                .getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyGold);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Utils
                                .getInt(Integer.valueOf("TitleOnPickup.FadeIn")), Utils
                                .getInt(Integer.valueOf("TitleOnPickup.Stay")), Utils
                                .getInt(Integer.valueOf("TitleOnPickup.FadeOut")));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.GOLD.Drop.Enable"))) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(Utils.getString("Mining.GOLD.Drop.DropBlock")), Utils.getInt(Integer.valueOf("Mining.GOLD.Drop.Amount"))));
                    }
                    if (Utils.getBoolean(Boolean.valueOf("Mining.GOLD.AutoPickup.Enable"))) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(Utils.getString("Mining.GOLD.AutoPickup.PickupBlock")), Utils.getInt(Integer.valueOf("Mining.GOLD.AutoPickup.Amount"))));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Settings.EnableSoundPickup"))) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.GOLD.ParticleBreak.enable"))) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ());
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Utils.getString("Mining.GOLD.ParticleBreak.particle")),
                                particleLocation, Utils.getInt(Integer.valueOf("Mining.GOLD.ParticleBreak.Locations.amount")),
                                Utils.getInt(Integer.valueOf("Mining.GOLD.ParticleBreak.Locations.locationX")),
                                Utils.getInt(Integer.valueOf("Mining.GOLD.ParticleBreak.Locations.locationY")),
                                Utils.getInt(Integer.valueOf("Mining.GOLD.ParticleBreak.Locations.locationZ")));
                    }

                    block.setType(Material.valueOf(Utils.getString("Mining.GOLD.ReplaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.GOLD_ORE), Utils.getInt(Integer.valueOf("Mining.GOLD.Delay")) * 20L);
                }
            }


            if (Utils.getBoolean(Boolean.valueOf("Mining.DIAMOND.Enable"))) {
                if (ore == Material.DIAMOND_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Utils.getInt(Integer.valueOf("Mining.DIAMOND.ExpDrop")));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Utils.getBoolean(Boolean.valueOf("Settings.EnableVault"))) {
                        Main.economy.depositPlayer(player, Utils.getInt(Integer.valueOf("Mining.DIAMOND.MoneyDrop")));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.DIAMOND.CommandBreak.enable"))) {
                        for (String cmd : Main.getInstance().getConfig().getStringList("Mining.DIAMOND.CommandBreak.command")) {
                            cmd = cmd.replaceAll("%player%", player.getName());
                            cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                        }
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Actionbar.EnableActionbar"))) {
                        String money = Utils.color(((Utils.getString("Actionbar.Message"))).replaceAll("%money%", moneyDiamond));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("MessageToChat.EnableMessageToChat"))) {
                        for (String message : Main.getInstance().getConfig().getStringList("MessageToChat.Message")) {
                            message = message.replaceAll("%money%", moneyDiamond);
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            player.sendMessage(Utils.color(message));
                        }
                    }

                    if (Utils.getBoolean(Boolean.valueOf("TitleOnPickup.EnableTitles"))) {
                        String titleText = Utils.color(Utils
                                .getString("TitleOnPickup.Title")).replaceAll("%money%", moneyDiamond);
                        String subtitleText = Utils.color(Utils
                                .getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyDiamond);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Utils
                                .getInt(Integer.valueOf("TitleOnPickup.FadeIn")), Utils
                                .getInt(Integer.valueOf("TitleOnPickup.Stay")), Utils
                                .getInt(Integer.valueOf("TitleOnPickup.FadeOut")));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.DIAMOND.Drop.Enable"))) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(Utils.getString("Mining.DIAMOND.Drop.DropBlock")), Utils.getInt(Integer.valueOf("Mining.DIAMOND.Drop.Amount"))));
                    }
                    if (Utils.getBoolean(Boolean.valueOf("Mining.DIAMOND.AutoPickup.Enable"))) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(Utils.getString("Mining.DIAMOND.AutoPickup.PickupBlock")), Utils.getInt(Integer.valueOf("Mining.DIAMOND.AutoPickup.Amount"))));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Settings.EnableSoundPickup"))) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.DIAMOND.ParticleBreak.enable"))) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ());
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Utils.getString("Mining.DIAMOND.ParticleBreak.particle")),
                                particleLocation, Utils.getInt(Integer.valueOf("Mining.DIAMOND.ParticleBreak.Locations.amount")),
                                Utils.getInt(Integer.valueOf("Mining.DIAMOND.ParticleBreak.Locations.locationX")),
                                Utils.getInt(Integer.valueOf("Mining.DIAMOND.ParticleBreak.Locations.locationY")),
                                Utils.getInt(Integer.valueOf("Mining.DIAMOND.ParticleBreak.Locations.locationZ")));
                    }

                    block.setType(Material.valueOf(Utils.getString("Mining.DIAMOND.ReplaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.DIAMOND_ORE), Utils.getInt(Integer.valueOf("Mining.DIAMOND.Delay")) * 20L);
                }
            }


            if (Utils.getBoolean(Boolean.valueOf("Mining.EMERALD.Enable"))) {
                if (ore == Material.EMERALD_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Utils.getInt(Integer.valueOf("Mining.EMERALD.ExpDrop")));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Utils.getBoolean(Boolean.valueOf("Settings.EnableVault"))) {
                        Main.economy.depositPlayer(player, Utils.getInt(Integer.valueOf("Mining.EMERALD.MoneyDrop")));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.EMERALD.CommandBreak.enable"))) {
                        for (String cmd : Main.getInstance().getConfig().getStringList("Mining.EMERALD.CommandBreak.command")) {
                            cmd = cmd.replaceAll("%player%", player.getName());
                            cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                        }
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Actionbar.EnableActionbar"))) {
                        String money = Utils.color(((Utils.getString("Actionbar.Message"))).replaceAll("%money%", moneyEmerald));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("MessageToChat.EnableMessageToChat"))) {
                        for (String message : Main.getInstance().getConfig().getStringList("MessageToChat.Message")) {
                            message = message.replaceAll("%money%", moneyEmerald);
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            player.sendMessage(Utils.color(message));
                        }
                    }

                    if (Utils.getBoolean(Boolean.valueOf("TitleOnPickup.EnableTitles"))) {
                        String titleText = Utils.color(Utils
                                .getString("TitleOnPickup.Title")).replaceAll("%money%", moneyEmerald);
                        String subtitleText = Utils.color(Utils
                                .getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyEmerald);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Utils
                                .getInt(Integer.valueOf("TitleOnPickup.FadeIn")), Utils
                                .getInt(Integer.valueOf("TitleOnPickup.Stay")), Utils
                                .getInt(Integer.valueOf("TitleOnPickup.FadeOut")));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.EMERALD.Drop.Enable"))) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(Utils.getString("Mining.EMERALD.Drop.DropBlock")), Utils.getInt(Integer.valueOf("Mining.EMERALD.Drop.Amount"))));
                    }
                    if (Utils.getBoolean(Boolean.valueOf("Mining.EMERALD.AutoPickup.Enable"))) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(Utils.getString("Mining.EMERALD.AutoPickup.PickupBlock")), Utils.getInt(Integer.valueOf("Mining.EMERALD.AutoPickup.Amount"))));
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Settings.EnableSoundPickup"))) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Utils.getBoolean(Boolean.valueOf("Mining.EMERALD.ParticleBreak.enable"))) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ());
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Utils.getString("Mining.EMERALD.ParticleBreak.particle")),
                                particleLocation, Utils.getInt(Integer.valueOf("Mining.EMERALD.ParticleBreak.Locations.amount")),
                                Utils.getInt(Integer.valueOf("Mining.EMERALD.ParticleBreak.Locations.locationX")),
                                Utils.getInt(Integer.valueOf("Mining.EMERALD.ParticleBreak.Locations.locationY")),
                                Utils.getInt(Integer.valueOf("Mining.EMERALD.ParticleBreak.Locations.locationZ")));
                    }

                    block.setType(Material.valueOf(Utils.getString("Mining.EMERALD.ReplaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.EMERALD_ORE), Utils.getInt(Integer.valueOf("Mining.EMERALD.Delay")) * 20L);
                }
            }
        }
    }
}