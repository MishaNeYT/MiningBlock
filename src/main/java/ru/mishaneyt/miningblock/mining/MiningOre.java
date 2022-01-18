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

import java.util.Objects;

public class MiningOre implements Listener {

    @EventHandler
    private void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        final Block block = e.getBlock();
        Material ore = block.getType();
        String location = Objects.requireNonNull(player.getLocation().getWorld()).getName();

        String enableSound = Main.getInstance().getConfig().getString("Settings.soundPickup");
        String moneyCoal = String.valueOf(Main.getInstance().getConfig().getInt("Mining.coal.moneyDrop"));
        String moneyIron = String.valueOf(Main.getInstance().getConfig().getInt("Mining.iron.moneyDrop"));
        String moneyGold = String.valueOf(Main.getInstance().getConfig().getInt("Mining.gold.moneyDrop"));
        String moneyDiamond = String.valueOf(Main.getInstance().getConfig().getInt("Mining.diamond.moneyDrop"));
        String moneyEmerald = String.valueOf(Main.getInstance().getConfig().getInt("Mining.emerald.moneyDrop"));

        if (Main.getInstance().getConfig().getStringList("Settings.enableWorld").contains(location)) {
            if (Main.getInstance().getConfig().getBoolean("Mining.coal.enable")) {
                if (ore == Material.COAL_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Main.getInstance().getConfig().getInt("Mining.coal.expDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.enableVault")) {
                        Main.economy.depositPlayer(player, Main.getInstance().getConfig().getInt("Mining.coal.moneyDrop"));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.coal.commandBreak.enable")) {
                        String cmd = Main.getInstance().getConfig().getString("Mining.coal.commandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }



                    if (Main.getInstance().getConfig().getBoolean("Mining.coal.enableDropBlock")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COAL));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Actionbar.enableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Actionbar.message")).replaceAll("%money%", moneyCoal);
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.enableMessageToChat")) {
                        String message = (ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageToChat.message")).replaceAll("%money%", String.valueOf(Main.getInstance().getConfig().getInt("Mining.coal.moneyDrop"))));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.enableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.title")).replaceAll("%money%", moneyCoal);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.subtitle")).replaceAll("%money%", moneyCoal);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.fadeIn"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.stay"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.fadeOut"));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Settings.enableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.coal.particleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Main.getInstance().getConfig().getString("Mining.coal.particleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(Main.getInstance().getConfig().getString("Mining.coal.replaceBlock")));
                    Main.getInstance().getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.COAL_ORE), Main.getInstance().getConfig().getInt("Mining.coal.delay") * 20L);
                }
            }



            if (Main.getInstance().getConfig().getBoolean("Mining.iron.enable")) {
                if (ore == Material.IRON_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Main.getInstance().getConfig().getInt("Mining.iron.expDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.enableVault")) {
                        Main.economy.depositPlayer(player, Main.getInstance().getConfig().getInt("Mining.iron.moneyDrop"));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.iron.commandBreak.enable")) {
                        String cmd = Main.getInstance().getConfig().getString("Mining.iron.commandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.iron.enableDropBlock")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.IRON_ORE));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Actionbar.enableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(((Main.getInstance().getConfig().getString("Actionbar.message")))).replaceAll("%money%", moneyIron));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.enableMessageToChat")) {
                        String message = (ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageToChat.message")).replaceAll("%money%", moneyIron));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.enableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.title")).replaceAll("%money%", moneyIron);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.subtitle")).replaceAll("%money%", moneyIron);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.fadeIn"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.stay"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.fadeOut"));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Settings.enableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.iron.particleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Main.getInstance().getConfig().getString("Mining.iron.particleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(Main.getInstance().getConfig().getString("Mining.iron.replaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.IRON_ORE), Main.getInstance().getConfig().getInt("Mining.iron.delay") * 20L);
                }
            }



            if (Main.getInstance().getConfig().getBoolean("Mining.gold.enable")) {
                if (ore == Material.GOLD_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Main.getInstance().getConfig().getInt("Mining.gold.expDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.enableVault")) {
                        Main.economy.depositPlayer(player, Main.getInstance().getConfig().getInt("Mining.gold.moneyDrop"));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.gold.commandBreak.enable")) {
                        String cmd = Main.getInstance().getConfig().getString("Mining.gold.commandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.gold.enableDropBlock")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GOLD_ORE));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Actionbar.enableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', ((Main.getInstance().getConfig().getString("Actionbar.message"))).replaceAll("%money%", moneyGold));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.enableMessageToChat")) {
                        String message =(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageToChat.message")).replaceAll("%money%", moneyGold));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.enableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.title")).replaceAll("%money%", moneyGold);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.subtitle")).replaceAll("%money%", moneyGold);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.fadeIn"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.stay"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.fadeOut"));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Settings.enableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.gold.particleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Main.getInstance().getConfig().getString("Mining.gold.particleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(Main.getInstance().getConfig().getString("Mining.gold.replaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.GOLD_ORE), Main.getInstance().getConfig().getInt("Mining.gold.delay") * 20L);
                }
            }



            if (Main.getInstance().getConfig().getBoolean("Mining.diamond.enable")) {
                if (ore == Material.DIAMOND_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Main.getInstance().getConfig().getInt("Mining.diamond.expDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.enableVault")) {
                        Main.economy.depositPlayer(player, Main.getInstance().getConfig().getInt("Mining.diamond.moneyDrop"));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.diamond.commandBreak.enable")) {
                        String cmd = Main.getInstance().getConfig().getString("Mining.diamond.commandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }


                    if (Main.getInstance().getConfig().getBoolean("Mining.coal.enableDropBlock")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.DIAMOND));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Actionbar.enableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', ((Main.getInstance().getConfig().getString("Actionbar.message"))).replaceAll("%money%", moneyDiamond));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.enableMessageToChat")) {
                        String message =(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageToChat.message")).replaceAll("%money%", moneyDiamond));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.enableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.title")).replaceAll("%money%", moneyDiamond);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.subtitle")).replaceAll("%money%", moneyDiamond);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.fadeIn"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.stay"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.fadeOut"));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Settings.enableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.diamond.particleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Main.getInstance().getConfig().getString("Mining.diamond.particleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(Main.getInstance().getConfig().getString("Mining.diamond.replaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.DIAMOND_ORE), Main.getInstance().getConfig().getInt("Mining.diamond.delay") * 20L);
                }
            }



            if (Main.getInstance().getConfig().getBoolean("Mining.emerald.enable")) {
                if (ore == Material.EMERALD_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Main.getInstance().getConfig().getInt("Mining.emerald.expDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.enableVault")) {
                        Main.economy.depositPlayer(player, Main.getInstance().getConfig().getInt("Mining.emerald.moneyDrop"));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.emerald.commandBreak.enable")) {
                        String cmd = Main.getInstance().getConfig().getString("Mining.emerald.commandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }


                    if (Main.getInstance().getConfig().getBoolean("Mining.coal.enableDropBlock")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.EMERALD));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Actionbar.enableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', ((Main.getInstance().getConfig().getString("Actionbar.message"))).replaceAll("%money%", moneyEmerald));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.enableMessageToChat")) {
                        String message = (ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageToChat.message")).replaceAll("%money%", moneyEmerald));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.enableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.title")).replaceAll("%money%", moneyEmerald);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.subtitle")).replaceAll("%money%", moneyEmerald);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.fadeIn"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.stay"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.fadeOut"));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Settings.enableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.emerald.particleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Main.getInstance().getConfig().getString("Mining.emerald.particleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(Main.getInstance().getConfig().getString("Mining.emerald.replaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.EMERALD_ORE), Main.getInstance().getConfig().getInt("Mining.emerald.delay") * 20L);
                }
            }
        }
    }
}