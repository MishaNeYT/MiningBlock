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

public class MiningLapis implements Listener {
    static final Main plugin = Main.getPlugin(Main.class);

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        final Block block = e.getBlock();

        String moneyLapis = String.valueOf(FileUtil.getMiningConfig().getInt("LAPIS.MoneyDrop"));

        if (!plugin.getConfig().getStringList("Settings.EnableWorld").contains(player.getLocation().getWorld().getName()))
            return;

        if (FileUtil.getMiningConfig().getBoolean("LAPIS.Enable")) {
            if (!(block.getType() == Material.LAPIS_ORE)) return;

            if (plugin.getConfig().getBoolean("Settings.EnableEditOre")) {
                e.setExpToDrop(0);
                e.getBlock().setType(Material.AIR);
            } else {
                e.setCancelled(true);
                e.setExpToDrop(FileUtil.getMiningConfig().getInt("LAPIS.ExpDrop"));
                e.getPlayer().giveExp(e.getExpToDrop());

                if (plugin.getConfig().getBoolean("Settings.EnableVault")) {
                    Main.economy.depositPlayer(player, FileUtil.getMiningConfig().getInt("LAPIS.MoneyDrop"));
                }

                if (FileUtil.getMiningConfig().getBoolean("LAPIS.CommandBreak.enable")) {
                    for (String cmd : FileUtil.getMiningConfig().getStringList("LAPIS.CommandBreak.command")) {
                        cmd = cmd.replaceAll("%player%", player.getName());
                        cmd = PlaceholderAPI.setPlaceholders(e.getPlayer(), cmd);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    }
                }

                if (plugin.getConfig().getBoolean("Actionbar.EnableActionbar")) {
                    String money = Utils.color(((Utils.getString("Actionbar.Message"))).replaceAll("%money%", moneyLapis));
                    money = PlaceholderAPI.setPlaceholders(e.getPlayer(), money);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(money));
                }

                if (plugin.getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
                    for (String message : plugin.getConfig().getStringList("MessageToChat.Message")) {
                        message = message.replaceAll("%money%", moneyLapis);
                        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                        player.sendMessage(Utils.color(message));
                    }
                }

                if (plugin.getConfig().getBoolean("TitleOnPickup.EnableTitles")) {
                    String titleText = Utils.color(plugin.getConfig().getString("TitleOnPickup.Title")).replaceAll("%money%", moneyLapis);
                    String subtitleText = Utils.color(plugin.getConfig().getString("TitleOnPickup.Subtitle")).replaceAll("%money%", moneyLapis);

                    titleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), titleText);
                    subtitleText = PlaceholderAPI.setPlaceholders(e.getPlayer(), subtitleText);

                    player.sendTitle(titleText, subtitleText, plugin.getConfig()
                            .getInt("TitleOnPickup.FadeIn"), plugin.getConfig()
                            .getInt("TitleOnPickup.Stay"), plugin.getConfig()
                            .getInt("TitleOnPickup.FadeOut"));
                }

                if (FileUtil.getMiningConfig().getBoolean("LAPIS.Drop.Enable")) {
                    DropsItems.getDropLapis(block);
                }
                if (FileUtil.getMiningConfig().getBoolean("LAPIS.AutoPickup.Enable")) {
                    AutoPickupItems.getAutoPickupLapis(player);
                }

                if (plugin.getConfig().getBoolean("Sound.EnableSoundPickup")) {
                    Utils.getSound(player);
                }

                if (FileUtil.getMiningConfig().getBoolean("LAPIS.ParticleBreak.enable")) {
                    Location blockLocation = e.getBlock().getLocation();
                    Location particleLocation = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ());
                    blockLocation.getWorld().spawnParticle(Particle.valueOf(FileUtil.getMiningConfig().getString("LAPIS.ParticleBreak.particle")),
                            particleLocation, FileUtil.getMiningConfig().getInt("LAPIS.ParticleBreak.Locations.amount"),
                            FileUtil.getMiningConfig().getInt("LAPIS.ParticleBreak.Locations.locationX"),
                            FileUtil.getMiningConfig().getInt("LAPIS.ParticleBreak.Locations.locationY"),
                            FileUtil.getMiningConfig().getInt("LAPIS.ParticleBreak.Locations.locationZ"));
                }

                block.setType(Material.valueOf(FileUtil.getMiningConfig().getString("LAPIS.ReplaceBlock")));
                Bukkit.getServer().getScheduler().runTaskLater(plugin, () -> block.setType(Material.LAPIS_ORE), FileUtil.getMiningConfig().getInt("LAPIS.Delay") * 20L);
            }
        }
    }
}