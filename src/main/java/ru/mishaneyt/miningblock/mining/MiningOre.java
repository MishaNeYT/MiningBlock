package ru.mishaneyt.miningblock.mining;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import ru.mishaneyt.miningblock.Main;

import java.util.Objects;

public class MiningOre implements Listener {
    private final Main plugin;

    public MiningOre(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        final Block block = e.getBlock();
        Material ore = block.getType();
        ItemStack enchant = player.getInventory().getItemInMainHand();
        String location = Objects.requireNonNull(player.getLocation().getWorld()).getName();

        String enableSound = this.plugin.getConfig().getString("Settings.soundPickup");
        String moneyCoal = String.valueOf(this.plugin.getConfig().getInt("Mining.coal.moneyDrop"));
        String moneyIron = String.valueOf(this.plugin.getConfig().getInt("Mining.iron.moneyDrop"));
        String moneyGold = String.valueOf(this.plugin.getConfig().getInt("Mining.gold.moneyDrop"));
        String moneyDiamond = String.valueOf(this.plugin.getConfig().getInt("Mining.diamond.moneyDrop"));
        String moneyEmerald = String.valueOf(this.plugin.getConfig().getInt("Mining.emerald.moneyDrop"));

        if (plugin.getConfig().getStringList("Settings.enableWorld").contains(location)) {
            if (this.plugin.getConfig().getBoolean("Mining.coal.enable")) {
                if (ore == Material.COAL_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(plugin.getConfig().getInt("Mining.coal.expDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (this.plugin.getConfig().getBoolean("Settings.enableVault")) {
                        Main.economy.depositPlayer(player, plugin.getConfig().getInt("Mining.coal.moneyDrop"));
                    }

                    if (this.plugin.getConfig().getBoolean("Mining.coal.commandBreak.enable")) {
                        String cmd = this.plugin.getConfig().getString("Mining.coal.commandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }


                    if (this.plugin.getConfig().getBoolean("Settings.enableSilkTouch")) {
                        if (enchant.getEnchantments().containsKey(Enchantment.SILK_TOUCH) && (this.plugin.getConfig().getBoolean("Mining.coal.enableDropBlock"))) {
                            block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COAL_ORE));

                        } else if (this.plugin.getConfig().getBoolean("Mining.coal.enableDropBlock")) {
                            block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COAL));
                        }
                    }


                    if (this.plugin.getConfig().getBoolean("Actionbar.enableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Actionbar.message")).replaceAll("%money%", moneyCoal);
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (this.plugin.getConfig().getBoolean("MessageToChat.enableMessageToChat")) {
                        String message = (ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("MessageToChat.message")).replaceAll("%money%", String.valueOf(this.plugin.getConfig().getInt("Mining.coal.moneyDrop"))));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (this.plugin.getConfig().getBoolean("TitleOnPickup.enableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig()
                                .getString("TitleOnPickup.title")).replaceAll("%money%", moneyCoal);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig()
                                .getString("TitleOnPickup.subtitle")).replaceAll("%money%", moneyCoal);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, this.plugin.getConfig()
                                .getInt("TitleOnPickup.fadeIn"), this.plugin.getConfig()
                                .getInt("TitleOnPickup.stay"), this.plugin.getConfig()
                                .getInt("TitleOnPickup.fadeOut"));
                    }


                    if (this.plugin.getConfig().getBoolean("Settings.enableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (this.plugin.getConfig().getBoolean("Mining.coal.particleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(this.plugin.getConfig().getString("Mining.coal.particleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(this.plugin.getConfig().getString("Mining.coal.replaceBlock")));
                    this.plugin.getServer().getScheduler().runTaskLater(this.plugin, () -> block.setType(Material.COAL_ORE), this.plugin.getConfig().getInt("Mining.coal.delay") * 20L);
                }
            }



            if (this.plugin.getConfig().getBoolean("Mining.iron.enable")) {
                if (ore == Material.IRON_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(plugin.getConfig().getInt("Mining.iron.expDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (this.plugin.getConfig().getBoolean("Settings.enableVault")) {
                        Main.economy.depositPlayer(player, plugin.getConfig().getInt("Mining.iron.moneyDrop"));
                    }

                    if (this.plugin.getConfig().getBoolean("Mining.iron.commandBreak.enable")) {
                        String cmd = this.plugin.getConfig().getString("Mining.iron.commandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }

                    if (this.plugin.getConfig().getBoolean("Mining.iron.enableDropBlock")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.IRON_ORE));
                    }

                    if (this.plugin.getConfig().getBoolean("Actionbar.enableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(((this.plugin.getConfig().getString("Actionbar.message")))).replaceAll("%money%", moneyIron));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (this.plugin.getConfig().getBoolean("MessageToChat.enableMessageToChat")) {
                        String message = (ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("MessageToChat.message")).replaceAll("%money%", moneyIron));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (this.plugin.getConfig().getBoolean("TitleOnPickup.enableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig()
                                .getString("TitleOnPickup.title")).replaceAll("%money%", moneyIron);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig()
                                .getString("TitleOnPickup.subtitle")).replaceAll("%money%", moneyIron);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, this.plugin.getConfig()
                                .getInt("TitleOnPickup.fadeIn"), this.plugin.getConfig()
                                .getInt("TitleOnPickup.stay"), this.plugin.getConfig()
                                .getInt("TitleOnPickup.fadeOut"));
                    }


                    if (this.plugin.getConfig().getBoolean("Settings.enableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (this.plugin.getConfig().getBoolean("Mining.iron.particleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(this.plugin.getConfig().getString("Mining.iron.particleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(this.plugin.getConfig().getString("Mining.iron.replaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(this.plugin, () -> block.setType(Material.IRON_ORE), this.plugin.getConfig().getInt("Mining.iron.delay") * 20L);
                }
            }



            if (this.plugin.getConfig().getBoolean("Mining.gold.enable")) {
                if (ore == Material.GOLD_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(plugin.getConfig().getInt("Mining.gold.expDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (this.plugin.getConfig().getBoolean("Settings.enableVault")) {
                        Main.economy.depositPlayer(player, plugin.getConfig().getInt("Mining.gold.moneyDrop"));
                    }

                    if (this.plugin.getConfig().getBoolean("Mining.gold.commandBreak.enable")) {
                        String cmd = this.plugin.getConfig().getString("Mining.gold.commandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }

                    if (this.plugin.getConfig().getBoolean("Mining.gold.enableDropBlock")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GOLD_ORE));
                    }

                    if (this.plugin.getConfig().getBoolean("Actionbar.enableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', ((this.plugin.getConfig().getString("Actionbar.message"))).replaceAll("%money%", moneyGold));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (this.plugin.getConfig().getBoolean("MessageToChat.enableMessageToChat")) {
                        String message =(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("MessageToChat.message")).replaceAll("%money%", moneyGold));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (this.plugin.getConfig().getBoolean("TitleOnPickup.enableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig()
                                .getString("TitleOnPickup.title")).replaceAll("%money%", moneyGold);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig()
                                .getString("TitleOnPickup.subtitle")).replaceAll("%money%", moneyGold);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, this.plugin.getConfig()
                                .getInt("TitleOnPickup.fadeIn"), this.plugin.getConfig()
                                .getInt("TitleOnPickup.stay"), this.plugin.getConfig()
                                .getInt("TitleOnPickup.fadeOut"));
                    }


                    if (this.plugin.getConfig().getBoolean("Settings.enableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (this.plugin.getConfig().getBoolean("Mining.gold.particleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(this.plugin.getConfig().getString("Mining.gold.particleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(this.plugin.getConfig().getString("Mining.gold.replaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(this.plugin, () -> block.setType(Material.GOLD_ORE), this.plugin.getConfig().getInt("Mining.gold.delay") * 20L);
                }
            }



            if (this.plugin.getConfig().getBoolean("Mining.diamond.enable")) {
                if (ore == Material.DIAMOND_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(plugin.getConfig().getInt("Mining.diamond.expDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (this.plugin.getConfig().getBoolean("Settings.enableVault")) {
                        Main.economy.depositPlayer(player, plugin.getConfig().getInt("Mining.diamond.moneyDrop"));
                    }

                    if (this.plugin.getConfig().getBoolean("Mining.diamond.commandBreak.enable")) {
                        String cmd = this.plugin.getConfig().getString("Mining.diamond.commandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }


                    if (this.plugin.getConfig().getBoolean("Settings.enableSilkTouch")) {
                        if (enchant.getEnchantments().containsKey(Enchantment.SILK_TOUCH) && (this.plugin.getConfig().getBoolean("Mining.diamond.enableDropBlock"))) {
                            block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.DIAMOND_ORE));

                        } else if (this.plugin.getConfig().getBoolean("Mining.diamond.enableDropBlock")) {
                            block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.DIAMOND));
                        }
                    }


                    if (this.plugin.getConfig().getBoolean("Actionbar.enableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', ((this.plugin.getConfig().getString("Actionbar.message"))).replaceAll("%money%", moneyDiamond));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (this.plugin.getConfig().getBoolean("MessageToChat.enableMessageToChat")) {
                        String message =(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("MessageToChat.message")).replaceAll("%money%", moneyDiamond));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (this.plugin.getConfig().getBoolean("TitleOnPickup.enableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig()
                                .getString("TitleOnPickup.title")).replaceAll("%money%", moneyDiamond);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig()
                                .getString("TitleOnPickup.subtitle")).replaceAll("%money%", moneyDiamond);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, this.plugin.getConfig()
                                .getInt("TitleOnPickup.fadeIn"), this.plugin.getConfig()
                                .getInt("TitleOnPickup.stay"), this.plugin.getConfig()
                                .getInt("TitleOnPickup.fadeOut"));
                    }


                    if (this.plugin.getConfig().getBoolean("Settings.enableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (this.plugin.getConfig().getBoolean("Mining.diamond.particleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(this.plugin.getConfig().getString("Mining.diamond.particleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(this.plugin.getConfig().getString("Mining.diamond.replaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(this.plugin, () -> block.setType(Material.DIAMOND_ORE), this.plugin.getConfig().getInt("Mining.diamond.delay") * 20L);
                }
            }



            if (this.plugin.getConfig().getBoolean("Mining.emerald.enable")) {
                if (ore == Material.EMERALD_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(plugin.getConfig().getInt("Mining.emerald.expDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (this.plugin.getConfig().getBoolean("Settings.enableVault")) {
                        Main.economy.depositPlayer(player, plugin.getConfig().getInt("Mining.emerald.moneyDrop"));
                    }

                    if (this.plugin.getConfig().getBoolean("Mining.emerald.commandBreak.enable")) {
                        String cmd = this.plugin.getConfig().getString("Mining.emerald.commandBreak.command").replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }


                    if (this.plugin.getConfig().getBoolean("Settings.enableSilkTouch")) {
                        if (enchant.getEnchantments().containsKey(Enchantment.SILK_TOUCH) && (this.plugin.getConfig().getBoolean("Mining.emerald.enableDropBlock"))) {
                            block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.EMERALD_ORE));

                        } else if (this.plugin.getConfig().getBoolean("Mining.emerald.enableDropBlock")) {
                            block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.EMERALD));
                        }
                    }


                    if (this.plugin.getConfig().getBoolean("Actionbar.enableActionbar")) {
                        String money = ChatColor.translateAlternateColorCodes('&', ((this.plugin.getConfig().getString("Actionbar.message"))).replaceAll("%money%", moneyEmerald));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);

                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }


                    if (this.plugin.getConfig().getBoolean("MessageToChat.enableMessageToChat")) {
                        String message = (ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("MessageToChat.message")).replaceAll("%money%", moneyEmerald));
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);

                        player.sendMessage(message);
                    }


                    if (this.plugin.getConfig().getBoolean("TitleOnPickup.enableTitles")) {
                        String titleText = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig()
                                .getString("TitleOnPickup.title")).replaceAll("%money%", moneyEmerald);
                        String subtitleText = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig()
                                .getString("TitleOnPickup.subtitle")).replaceAll("%money%", moneyEmerald);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, this.plugin.getConfig()
                                .getInt("TitleOnPickup.fadeIn"), this.plugin.getConfig()
                                .getInt("TitleOnPickup.stay"), this.plugin.getConfig()
                                .getInt("TitleOnPickup.fadeOut"));
                    }


                    if (this.plugin.getConfig().getBoolean("Settings.enableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (this.plugin.getConfig().getBoolean("Mining.emerald.particleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 0.5, blockLocation.getBlockY() + 0.5, blockLocation.getBlockZ() + 0.5);
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(this.plugin.getConfig().getString("Mining.emerald.particleBreak.particle")), particleLocation, 1);
                    }

                    block.setType(Material.valueOf(this.plugin.getConfig().getString("Mining.emerald.replaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(this.plugin, () -> block.setType(Material.EMERALD_ORE), this.plugin.getConfig().getInt("Mining.emerald.delay") * 20L);
                }
            }
        }
    }
}