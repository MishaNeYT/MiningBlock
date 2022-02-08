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

public class MiningQuartz implements Listener {

    @EventHandler
    private void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        final Block block = e.getBlock();

        String enableSound = Utils.getString("Sound.SoundPickup");
        String moneyQuartz = String.valueOf(FileUtil.getMiningConfig().getInt("QUARTZ.MoneyDrop"));

        if (Main.getInstance().getConfig().getStringList("Settings.EnableWorld").contains(player.getLocation().getWorld().getName())) {
            if (FileUtil.getMiningConfig().getBoolean("QUARTZ.Enable")) {
                if (block.getType() == Material.QUARTZ_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(FileUtil.getMiningConfig().getInt("QUARTZ.ExpDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableVault")) {
                        Main.economy.depositPlayer(player, FileUtil.getMiningConfig().getInt("QUARTZ.MoneyDrop"));
                    }

                    if (FileUtil.getMiningConfig().getBoolean("QUARTZ.CommandBreak.enable")) {
                        for (String cmd : FileUtil.getMiningConfig().getStringList("QUARTZ.CommandBreak.command")) {
                            cmd = cmd.replaceAll("%player%", player.getName());
                            cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                        }
                    }

                    if (Main.getInstance().getConfig().getBoolean("Actionbar.EnableActionbar")) {
                        String money = Utils.color(((Utils.getString("Actionbar.Message"))).replaceAll("%money%", moneyQuartz));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }

                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                        for (String message : Main.getInstance().getConfig().getStringList("MessageToChat.Message")) {
                            message = message.replaceAll("%money%", moneyQuartz);
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            player.sendMessage(Utils.color(message));
                        }
                    }

                    if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.EnableTitles")) {
                        String titleText = Utils.color(Main.getInstance().getConfig().getString("TitleOnPickup.Title")).replaceAll("%money%", moneyQuartz);
                        String subtitleText = Utils.color(Main.getInstance().getConfig().getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyQuartz);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.FadeIn"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.Stay"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.FadeOut"));
                    }

                    if (FileUtil.getMiningConfig().getBoolean("QUARTZ.Drop.Enable")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("QUARTZ.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("QUARTZ.Drop.Amount")));
                    }
                    if (FileUtil.getMiningConfig().getBoolean("QUARTZ.AutoPickup.Enable")) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("QUARTZ.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("QUARTZ.AutoPickup.Amount")));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
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
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.QUARTZ_ORE), FileUtil.getMiningConfig().getInt("QUARTZ.Delay") * 20L);
                }
            }
        }
    }
}