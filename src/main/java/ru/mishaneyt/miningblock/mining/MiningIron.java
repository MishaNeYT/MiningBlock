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

import java.util.Objects;

public class MiningIron implements Listener {
    static final Main plugin = Main.getPlugin(Main.class);

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        final Block block = e.getBlock();

        String moneyIron = String.valueOf(FileUtil.getMiningConfig().getInt("IRON.MoneyDrop"));

        if (!plugin.getConfig().getStringList("Settings.EnableWorld").contains(player.getLocation().getWorld().getName()))
            return;

        if (FileUtil.getMiningConfig().getBoolean("IRON.Enable")) {
            if (!(block.getType() == Material.IRON_ORE)) return;

            if (plugin.getConfig().getBoolean("Settings.EnableEditOre")) {
                e.setExpToDrop(0);
                e.getBlock().setType(Material.AIR);
            } else {
                e.setCancelled(true);
                e.setExpToDrop(FileUtil.getMiningConfig().getInt("IRON.ExpDrop"));
                e.getPlayer().giveExp(e.getExpToDrop());

                if (plugin.getConfig().getBoolean("Settings.EnableVault")) {
                    Main.economy.depositPlayer(player, FileUtil.getMiningConfig().getInt("IRON.MoneyDrop"));
                }

                if (FileUtil.getMiningConfig().getBoolean("IRON.CommandBreak.enable")) {
                    for (String cmd : FileUtil.getMiningConfig().getStringList("IRON.CommandBreak.command")) {
                        cmd = cmd.replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }
                }

                if (plugin.getConfig().getBoolean("Actionbar.EnableActionbar")) {
                    String money = Utils.color(Objects.requireNonNull(((Utils.getString("Actionbar.Message")))).replaceAll("%money%", moneyIron));
                    money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                }


                if (plugin.getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                    for (String message : plugin.getConfig().getStringList("MessageToChat.Message")) {
                        message = message.replaceAll("%money%", moneyIron);
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                        player.sendMessage(Utils.color(message));
                    }
                }

                if (plugin.getConfig().getBoolean("TitleOnPickup.EnableTitles")) {
                    String titleText = Utils.color(plugin.getConfig().getString("TitleOnPickup.Title")).replaceAll("%money%", moneyIron);
                    String subtitleText = Utils.color(plugin.getConfig().getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyIron);

                    titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                    subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                    player.sendTitle(titleText, subtitleText, plugin.getConfig()
                            .getInt("TitleOnPickup.FadeIn"), plugin.getConfig()
                            .getInt("TitleOnPickup.Stay"), plugin.getConfig()
                            .getInt("TitleOnPickup.FadeOut"));
                }

                if (FileUtil.getMiningConfig().getBoolean("IRON.Drop.Enable")) {
                    DropsItems.getDropIron(block);
                }
                if (FileUtil.getMiningConfig().getBoolean("IRON.AutoPickup.Enable")) {
                    AutoPickupItems.getAutoPickupIron(player);
                }

                if (plugin.getConfig().getBoolean("Sound.EnableSoundPickup")) {
                    Utils.getSound(player);
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
                Bukkit.getServer().getScheduler().runTaskLater(plugin, () -> block.setType(Material.IRON_ORE), FileUtil.getMiningConfig().getInt("IRON.Delay") * 20L);
            }
        }
    }
}