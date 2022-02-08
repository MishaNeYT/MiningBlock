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

public class MiningRedstone implements Listener {

    @EventHandler
    private void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        final Block block = e.getBlock();

        String enableSound = Utils.getString("Sound.SoundPickup");
        String moneyRedstone = String.valueOf(FileUtil.getMiningConfig().getInt("REDSTONE.MoneyDrop"));

        if (Main.getInstance().getConfig().getStringList("Settings.EnableWorld").contains(player.getLocation().getWorld().getName())) {
            if (FileUtil.getMiningConfig().getBoolean("REDSTONE.Enable")) {
                if (block.getType() == Material.REDSTONE_ORE) {
                    e.setCancelled(true);
                    e.setExpToDrop(FileUtil.getMiningConfig().getInt("REDSTONE.ExpDrop"));
                    e.getPlayer().giveExp(e.getExpToDrop());

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableVault")) {
                        Main.economy.depositPlayer(player, FileUtil.getMiningConfig().getInt("REDSTONE.MoneyDrop"));
                    }

                    if (FileUtil.getMiningConfig().getBoolean("REDSTONE.CommandBreak.enable")) {
                        for (String cmd : FileUtil.getMiningConfig().getStringList("REDSTONE.CommandBreak.command")) {
                            cmd = cmd.replaceAll("%player%", player.getName());
                            cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                        }
                    }

                    if (Main.getInstance().getConfig().getBoolean("Actionbar.EnableActionbar")) {
                        String money = Utils.color(((Utils.getString("Actionbar.Message"))).replaceAll("%money%", moneyRedstone));
                        money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                    }

                    if (Main.getInstance().getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                        for (String message : Main.getInstance().getConfig().getStringList("MessageToChat.Message")) {
                            message = message.replaceAll("%money%", moneyRedstone);
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            player.sendMessage(Utils.color(message));
                        }
                    }

                    if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.EnableTitles")) {
                        String titleText = Utils.color(Main.getInstance().getConfig().getString("TitleOnPickup.Title")).replaceAll("%money%", moneyRedstone);
                        String subtitleText = Utils.color(Main.getInstance().getConfig().getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyRedstone);

                        titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                        subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                        player.sendTitle(titleText, subtitleText, Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.FadeIn"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.Stay"), Main.getInstance().getConfig()
                                .getInt("TitleOnPickup.FadeOut"));
                    }

                    if (FileUtil.getMiningConfig().getBoolean("REDSTONE.Drop.Enable")) {
                        block.getLocation().add(0.5D, 1.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("REDSTONE.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("REDSTONE.Drop.Amount")));
                    }
                    if (FileUtil.getMiningConfig().getBoolean("REDSTONE.AutoPickup.Enable")) {
                        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("REDSTONE.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("REDSTONE.AutoPickup.Amount")));
                    }

                    if (Main.getInstance().getConfig().getBoolean("Settings.EnableSoundPickup")) {
                        player.playSound(player.getLocation(), Sound.valueOf(enableSound), 1.0F, 1.0F);
                    }

                    if (FileUtil.getMiningConfig().getBoolean("REDSTONE.ParticleBreak.enable")) {
                        Location blockLocation = e.getBlock().getLocation();
                        Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ());
                        blockLocation.getWorld().spawnParticle(Particle.valueOf(FileUtil.getMiningConfig().getString("REDSTONE.ParticleBreak.particle")),
                                particleLocation, FileUtil.getMiningConfig().getInt("REDSTONE.ParticleBreak.Locations.amount"),
                                FileUtil.getMiningConfig().getInt("REDSTONE.ParticleBreak.Locations.locationX"),
                                FileUtil.getMiningConfig().getInt("REDSTONE.ParticleBreak.Locations.locationY"),
                                FileUtil.getMiningConfig().getInt("REDSTONE.ParticleBreak.Locations.locationZ"));
                    }

                    block.setType(Material.valueOf(FileUtil.getMiningConfig().getString("REDSTONE.ReplaceBlock")));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), () -> block.setType(Material.REDSTONE_ORE), FileUtil.getMiningConfig().getInt("REDSTONE.Delay") * 20L);
                }
            }
        }
    }
}