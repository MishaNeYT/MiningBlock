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
import ru.mishaneyt.miningblock.utils.FileUtil;
import ru.mishaneyt.miningblock.utils.Utils;

import java.util.Objects;

public class MiningOre implements Listener {

    @EventHandler
    private void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        final Block block = e.getBlock();
        Material ore = block.getType();
        String location = player.getLocation().getWorld().getName();

        String enableSound = Utils.getString("Sound.SoundPickup");
        String moneyCoal = String.valueOf(FileUtil.getMiningConfig().getInt("COAL.MoneyDrop"));
        String moneyIron = String.valueOf(FileUtil.getMiningConfig().getInt("IRON.MoneyDrop"));
        String moneyGold = String.valueOf(FileUtil.getMiningConfig().getInt("GOLD.MoneyDrop"));
        String moneyDiamond = String.valueOf(FileUtil.getMiningConfig().getInt("DIAMOND.MoneyDrop"));
        String moneyEmerald = String.valueOf(FileUtil.getMiningConfig().getInt("EMERALD.MoneyDrop"));

        if (Main.getInstance().getConfig().getBoolean("Settings.EnableEditOre") && player.hasPermission(Utils.getString("Settings.Permission"))) {
            if (Main.getInstance().getConfig().getStringList("Settings.EnableWorld").contains(location)) {
                if (ore == Material.COAL_ORE || ore == Material.IRON_ORE || ore == Material.GOLD_ORE || ore == Material.DIAMOND_ORE || ore == Material.EMERALD_ORE) {
                    e.setExpToDrop(0);
                    block.setType(Material.AIR);
                    return;
                }
            }
        }

        if (Main.getInstance().getConfig().getStringList("Settings.EnableWorld").contains(location)) {
            if (FileUtil.getMiningConfig().getBoolean("COAL.Enable")) {
                if (ore == Material.COAL_ORE) {
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
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("COAL.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("COAL.Drop.Amount")));
                    }
                    if (FileUtil.getMiningConfig().getBoolean("COAL.AutoPickup.Enable")) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("COAL.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("COAL.AutoPickup.Amount")));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
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


            if (FileUtil.getMiningConfig().getBoolean("IRON.Enable")) {
                if (ore == Material.IRON_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(FileUtil.getMiningConfig().getInt("IRON.ExpDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableVault")) {
                        Main.economy.depositPlayer(player, FileUtil.getMiningConfig().getInt("IRON.MoneyDrop"));
                    }

                    if (FileUtil.getMiningConfig().getBoolean("IRON.CommandBreak.enable")) {
                        for (String cmd : FileUtil.getMiningConfig().getStringList("IRON.CommandBreak.command")) {
                            cmd = cmd.replaceAll("%player%", player.getName());
                            cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                        }
                    }

                    if (Main.getInstance().getConfig().getBoolean("Actionbar.EnableActionbar")) {
                        String money = Utils.color(Objects.requireNonNull(((Utils.getString("Actionbar.Message")))).replaceAll("%money%", moneyIron));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                        for (String message : Main.getInstance().getConfig().getStringList("MessageToChat.Message")) {
                            message = message.replaceAll("%money%", moneyIron);
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

                    if (FileUtil.getMiningConfig().getBoolean("IRON.Drop.Enable")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("IRON.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("IRON.Drop.Amount")));
                    }
                    if (FileUtil.getMiningConfig().getBoolean("IRON.AutoPickup.Enable")) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("IRON.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("IRON.AutoPickup.Amount")));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (FileUtil.getMiningConfig().getBoolean("IRON.ParticleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ());
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(FileUtil.getMiningConfig().getString("IRON.ParticleBreak.particle")),
                                particleLocation, FileUtil.getMiningConfig().getInt("IRON.ParticleBreak.Locations.amount"),
                                FileUtil.getMiningConfig().getInt("IRON.ParticleBreak.Locations.locationX"),
                                FileUtil.getMiningConfig().getInt("IRON.ParticleBreak.Locations.locationY"),
                                FileUtil.getMiningConfig().getInt("IRON.ParticleBreak.Locations.locationZ"));
                    }

                    block.setType(Material.valueOf(FileUtil.getMiningConfig().getString("IRON.ReplaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.IRON_ORE), FileUtil.getMiningConfig().getInt("IRON.Delay") * 20L);
                }
            }


            if (FileUtil.getMiningConfig().getBoolean("GOLD.Enable")) {
                if (ore == Material.GOLD_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(FileUtil.getMiningConfig().getInt("GOLD.ExpDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableVault")) {
                        Main.economy.depositPlayer(player, FileUtil.getMiningConfig().getInt("GOLD.MoneyDrop"));
                    }

                    if (FileUtil.getMiningConfig().getBoolean("GOLD.CommandBreak.enable")) {
                        for (String cmd : FileUtil.getMiningConfig().getStringList("GOLD.CommandBreak.command")) {
                            cmd = cmd.replaceAll("%player%", player.getName());
                            cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                        }
                    }

                    if (Main.getInstance().getConfig().getBoolean("Actionbar.EnableActionbar")) {
                        String money = Utils.color(((Utils.getString("Actionbar.Message"))).replaceAll("%money%", moneyGold));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }

                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                        for (String message : Main.getInstance().getConfig().getStringList("MessageToChat.Message")) {
                            message = message.replaceAll("%money%", moneyGold);
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

                    if (FileUtil.getMiningConfig().getBoolean("GOLD.Drop.Enable")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("GOLD.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("GOLD.Drop.Amount")));
                    }
                    if (FileUtil.getMiningConfig().getBoolean("GOLD.AutoPickup.Enable")) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("GOLD.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("GOLD.AutoPickup.Amount")));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (FileUtil.getMiningConfig().getBoolean("GOLD.ParticleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ());
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(FileUtil.getMiningConfig().getString("GOLD.ParticleBreak.particle")),
                                particleLocation, FileUtil.getMiningConfig().getInt("GOLD.ParticleBreak.Locations.amount"),
                                FileUtil.getMiningConfig().getInt("GOLD.ParticleBreak.Locations.locationX"),
                                FileUtil.getMiningConfig().getInt("GOLD.ParticleBreak.Locations.locationY"),
                                FileUtil.getMiningConfig().getInt("GOLD.ParticleBreak.Locations.locationZ"));
                    }

                    block.setType(Material.valueOf(FileUtil.getMiningConfig().getString("GOLD.ReplaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.GOLD_ORE), FileUtil.getMiningConfig().getInt("GOLD.Delay") * 20L);
                }
            }


            if (FileUtil.getMiningConfig().getBoolean("DIAMOND.Enable")) {
                if (ore == Material.DIAMOND_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(FileUtil.getMiningConfig().getInt("DIAMOND.ExpDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableVault")) {
                        Main.economy.depositPlayer(player, FileUtil.getMiningConfig().getInt("DIAMOND.MoneyDrop"));
                    }

                    if (FileUtil.getMiningConfig().getBoolean("DIAMOND.CommandBreak.enable")) {
                        for (String cmd : FileUtil.getMiningConfig().getStringList("DIAMOND.CommandBreak.command")) {
                            cmd = cmd.replaceAll("%player%", player.getName());
                            cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                        }
                    }

                    if (Main.getInstance().getConfig().getBoolean("Actionbar.EnableActionbar")) {
                        String money = Utils.color(((Utils.getString("Actionbar.Message"))).replaceAll("%money%", moneyDiamond));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }

                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                        for (String message : Main.getInstance().getConfig().getStringList("MessageToChat.Message")) {
                            message = message.replaceAll("%money%", moneyDiamond);
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

                    if (FileUtil.getMiningConfig().getBoolean("DIAMOND.Drop.Enable")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("DIAMOND.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("DIAMOND.Drop.Amount")));
                    }
                    if (FileUtil.getMiningConfig().getBoolean("DIAMOND.AutoPickup.Enable")) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("DIAMOND.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("DIAMOND.AutoPickup.Amount")));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
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
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.DIAMOND_ORE), FileUtil.getMiningConfig().getInt("DIAMOND.Delay") * 20L);
                }
            }


            if (FileUtil.getMiningConfig().getBoolean("EMERALD.Enable")) {
                if (ore == Material.EMERALD_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(FileUtil.getMiningConfig().getInt("EMERALD.ExpDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableVault")) {
                        Main.economy.depositPlayer(player, FileUtil.getMiningConfig().getInt("EMERALD.MoneyDrop"));
                    }

                    if (FileUtil.getMiningConfig().getBoolean("EMERALD.CommandBreak.enable")) {
                        for (String cmd : FileUtil.getMiningConfig().getStringList("EMERALD.CommandBreak.command")) {
                            cmd = cmd.replaceAll("%player%", player.getName());
                            cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                        }
                    }

                    if (Main.getInstance().getConfig().getBoolean("Actionbar.EnableActionbar")) {
                        String money = Utils.color(((Utils.getString("Actionbar.Message"))).replaceAll("%money%", moneyEmerald));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }

                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                        for (String message : Main.getInstance().getConfig().getStringList("MessageToChat.Message")) {
                            message = message.replaceAll("%money%", moneyEmerald);
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

                    if (FileUtil.getMiningConfig().getBoolean("EMERALD.Drop.Enable")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("EMERALD.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("EMERALD.Drop.Amount")));
                    }
                    if (FileUtil.getMiningConfig().getBoolean("EMERALD.AutoPickup.Enable")) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("EMERALD.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("EMERALD.AutoPickup.Amount")));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (FileUtil.getMiningConfig().getBoolean("EMERALD.ParticleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ());
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(FileUtil.getMiningConfig().getString("EMERALD.ParticleBreak.particle")),
                                particleLocation, FileUtil.getMiningConfig().getInt("EMERALD.ParticleBreak.Locations.amount"),
                                FileUtil.getMiningConfig().getInt("EMERALD.ParticleBreak.Locations.locationX"),
                                FileUtil.getMiningConfig().getInt("EMERALD.ParticleBreak.Locations.locationY"),
                                FileUtil.getMiningConfig().getInt("EMERALD.ParticleBreak.Locations.locationZ"));
                    }

                    block.setType(Material.valueOf(FileUtil.getMiningConfig().getString("EMERALD.ReplaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.EMERALD_ORE), FileUtil.getMiningConfig().getInt("EMERALD.Delay") * 20L);
                }
            }
        }
    }
}