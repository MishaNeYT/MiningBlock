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
        String location = player.getLocation().getWorld().getName();

        String enableSound = Main.getInstance().getConfig().getString("Settings.SoundPickup");
        String moneyCoal = String.valueOf(Main.getInstance().getConfig().getInt("Mining.COAL.MoneyDrop"));
        String moneyIron = String.valueOf(Main.getInstance().getConfig().getInt("Mining.IRON.MoneyDrop"));
        String moneyGold = String.valueOf(Main.getInstance().getConfig().getInt("Mining.GOLD.MoneyDrop"));
        String moneyDiamond = String.valueOf(Main.getInstance().getConfig().getInt("Mining.DIAMOND.MoneyDrop"));
        String moneyEmerald = String.valueOf(Main.getInstance().getConfig().getInt("Mining.EMERALD.MoneyDrop"));

        if (Main.getInstance().getConfig().getStringList("Settings.EnableWorld").contains(location)) {
            if (Main.getInstance().getConfig().getBoolean("Mining.COAL.Enable")) {
                if (ore == Material.COAL_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Main.getInstance().getConfig().getInt("Mining.COAL.ExpDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableVault")) {
                        Main.economy.depositPlayer(player, Main.getInstance().getConfig().getInt("Mining.COAL.MoneyDrop"));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.COAL.CommandBreak.enable")) {
                        String cmd = Main.getInstance().getConfig().getString("Mining.COAL.CommandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }


                    if (Main.getInstance().getConfig().getBoolean("Mining.COAL.Drop.Enable")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(Main.getInstance().getConfig().getString("Mining.COAL.Drop.DropBlock"))));
                    }
                    if (Main.getInstance().getConfig().getBoolean("Mining.COAL.AutoPickup.Enable")) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(Main.getInstance().getConfig().getString("Mining.COAL.AutoPickup.PickupBlock"))));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Actionbar.EnableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Actionbar.Message")).replaceAll("%money%", moneyCoal);
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                        String message = (ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageToChat.Message")).replaceAll("%money%", moneyCoal));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.EnableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.Title")).replaceAll("%money%", moneyCoal);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyCoal);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.FadeIn"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.Stay"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.FadeOut"));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.COAL.ParticleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Main.getInstance().getConfig().getString("Mining.COAL.ParticleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(Main.getInstance().getConfig().getString("Mining.COAL.ReplaceBlock")));
                    Main.getInstance().getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.COAL_ORE), Main.getInstance().getConfig().getInt("Mining.COAL.Delay") * 20L);
                }
            }



            if (Main.getInstance().getConfig().getBoolean("Mining.IRON.Enable")) {
                if (ore == Material.IRON_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Main.getInstance().getConfig().getInt("Mining.IRON.ExpDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableVault")) {
                        Main.economy.depositPlayer(player, Main.getInstance().getConfig().getInt("Mining.IRON.MoneyDrop"));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.IRON.CommandBreak.enable")) {
                        String cmd = Main.getInstance().getConfig().getString("Mining.IRON.CommandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }


                    if (Main.getInstance().getConfig().getBoolean("Mining.IRON.Drop.Enable")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(Main.getInstance().getConfig().getString("Mining.IRON.Drop.DropBlock"))));
                    }
                    if (Main.getInstance().getConfig().getBoolean("Mining.IRON.AutoPickup.Enable")) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(Main.getInstance().getConfig().getString("Mining.IRON.AutoPickup.PickupBlock"))));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Actionbar.EnableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(((Main.getInstance().getConfig().getString("Actionbar.Message")))).replaceAll("%money%", moneyIron));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                        String message = (ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageToChat.Message")).replaceAll("%money%", moneyIron));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.EnableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.Title")).replaceAll("%money%", moneyIron);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyIron);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.FadeIn"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.Stay"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.FadeOut"));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.IRON.ParticleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Main.getInstance().getConfig().getString("Mining.IRON.ParticleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(Main.getInstance().getConfig().getString("Mining.IRON.ReplaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.IRON_ORE), Main.getInstance().getConfig().getInt("Mining.IRON.Delay") * 20L);
                }
            }



            if (Main.getInstance().getConfig().getBoolean("Mining.GOLD.Enable")) {
                if (ore == Material.GOLD_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Main.getInstance().getConfig().getInt("Mining.GOLD.ExpDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableVault")) {
                        Main.economy.depositPlayer(player, Main.getInstance().getConfig().getInt("Mining.GOLD.MoneyDrop"));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.GOLD.CommandBreak.enable")) {
                        String cmd = Main.getInstance().getConfig().getString("Mining.GOLD.CommandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }


                    if (Main.getInstance().getConfig().getBoolean("Mining.GOLD.Drop.Enable")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(Main.getInstance().getConfig().getString("Mining.GOLD.Drop.DropBlock"))));
                    }
                    if (Main.getInstance().getConfig().getBoolean("Mining.GOLD.AutoPickup.Enable")) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(Main.getInstance().getConfig().getString("Mining.GOLD.AutoPickup.PickupBlock"))));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Actionbar.EnableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', ((Main.getInstance().getConfig().getString("Actionbar.Message"))).replaceAll("%money%", moneyGold));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                        String message =(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageToChat.Message")).replaceAll("%money%", moneyGold));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.EnableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.Title")).replaceAll("%money%", moneyGold);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyGold);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.FadeIn"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.Stay"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.FadeOut"));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.GOLD.ParticleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Main.getInstance().getConfig().getString("Mining.GOLD.ParticleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(Main.getInstance().getConfig().getString("Mining.GOLD.ReplaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.GOLD_ORE), Main.getInstance().getConfig().getInt("Mining.GOLD.Delay") * 20L);
                }
            }



            if (Main.getInstance().getConfig().getBoolean("Mining.DIAMOND.Enable")) {
                if (ore == Material.DIAMOND_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Main.getInstance().getConfig().getInt("Mining.DIAMOND.ExpDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableVault")) {
                        Main.economy.depositPlayer(player, Main.getInstance().getConfig().getInt("Mining.DIAMOND.MoneyDrop"));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.DIAMOND.CommandBreak.enable")) {
                        String cmd = Main.getInstance().getConfig().getString("Mining.DIAMOND.CommandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }


                    if (Main.getInstance().getConfig().getBoolean("Mining.DIAMOND.Drop.Enable")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(Main.getInstance().getConfig().getString("Mining.DIAMOND.Drop.DropBlock"))));
                    }
                    if (Main.getInstance().getConfig().getBoolean("Mining.DIAMOND.AutoPickup.Enable")) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(Main.getInstance().getConfig().getString("Mining.DIAMOND.AutoPickup.PickupBlock"))));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Actionbar.EnableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', ((Main.getInstance().getConfig().getString("Actionbar.Message"))).replaceAll("%money%", moneyDiamond));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                        String message =(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageToChat.Message")).replaceAll("%money%", moneyDiamond));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.EnableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.Title")).replaceAll("%money%", moneyDiamond);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyDiamond);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.FadeIn"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.Stay"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.FadeOut"));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.DIAMOND.ParticleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Main.getInstance().getConfig().getString("Mining.DIAMOND.ParticleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(Main.getInstance().getConfig().getString("Mining.DIAMOND.ReplaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.DIAMOND_ORE), Main.getInstance().getConfig().getInt("Mining.DIAMOND.Delay") * 20L);
                }
            }



            if (Main.getInstance().getConfig().getBoolean("Mining.EMERALD.Enable")) {
                if (ore == Material.EMERALD_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(Main.getInstance().getConfig().getInt("Mining.EMERALD.ExpDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableVault")) {
                        Main.economy.depositPlayer(player, Main.getInstance().getConfig().getInt("Mining.EMERALD.MoneyDrop"));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.EMERALD.CommandBreak.enable")) {
                        String cmd = Main.getInstance().getConfig().getString("Mining.EMERALD.CommandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }


                    if (Main.getInstance().getConfig().getBoolean("Mining.EMERALD.Drop.Enable")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(Main.getInstance().getConfig().getString("Mining.EMERALD.Drop.DropBlock"))));
                    }
                    if (Main.getInstance().getConfig().getBoolean("Mining.EMERALD.AutoPickup.Enable")) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(Main.getInstance().getConfig().getString("Mining.EMERALD.AutoPickup.PickupBlock"))));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Actionbar.EnableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', ((Main.getInstance().getConfig().getString("Actionbar.Message"))).replaceAll("%money%", moneyEmerald));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                        String message = (ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageToChat.Message")).replaceAll("%money%", moneyEmerald));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.EnableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.Title")).replaceAll("%money%", moneyEmerald);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig()
                                .getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyEmerald);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.FadeIn"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.Stay"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.FadeOut"));
                    }


                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (Main.getInstance().getConfig().getBoolean("Mining.EMERALD.ParticleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(Main.getInstance().getConfig().getString("Mining.EMERALD.ParticleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(Main.getInstance().getConfig().getString("Mining.EMERALD.ReplaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.EMERALD_ORE), Main.getInstance().getConfig().getInt("Mining.EMERALD.Delay") * 20L);
                }
            }
        }
    }
}