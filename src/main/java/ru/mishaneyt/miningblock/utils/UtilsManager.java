package ru.mishaneyt.miningblock.utils;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.config.ConfigManager;
import ru.mishaneyt.miningblock.mining.MiningListener;

public class UtilsManager {

    public static String getString(String m) {
        return Main.getInstance().getConfig().getString(m);
    }

    public static String getColor(String m) {
        return ChatColor.translateAlternateColorCodes('&', m);
    }

    public static String getStringColor(String m) {
        return ChatColor.translateAlternateColorCodes('&', getString(m));
    }

    public static void onHelp(Player p) {
        for (String message : Main.getInstance().getConfig().getStringList("Messages.HelpCommand")) {
            p.sendMessage(getColor(message).replace("%version%", Main.getInstance().getDescription().getVersion()));
        }
    }

    public static void onEditOre(Player p) {
        if (MiningListener.toggleEdit.contains(p)) {
            MiningListener.toggleEdit.remove(p);
            p.sendMessage(ConfigManager.EDITORE_DISABLE);
        } else {
            MiningListener.toggleEdit.add(p);
            p.sendMessage(ConfigManager.EDITORE_ENABLE);
        }
    }

    public static void sendError(Player p) {
        if (ConfigManager.BC_ERROR) {
            p.sendMessage(getColor("&cВозникла ошибка/проблема при работе с плагином, проверьте консоль. Дополнительная помощь: https://spigotmc.ru/resources/850/"));
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1.0F, 1.0F);
        }
    }
}