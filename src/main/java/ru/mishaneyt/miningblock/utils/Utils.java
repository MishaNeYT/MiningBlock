package ru.mishaneyt.miningblock.utils;

import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.config.ConfigManager;
import ru.mishaneyt.miningblock.mining.MiningListener;

public class Utils {

    public static String color(String s) {
        if (s != null) return s.replace("&", "§");
        return null;
    }

    public static void help(Player p) {
        String version = Main.getInstance().getDescription().getVersion();

        for (String message : ConfigManager.getMessages().getStringList("Messages.Help")) {
            p.sendMessage(message.replace("%version%", version).replace("&", "§"));
        }
    }

    public static void editOre(Player p) {
        MiningListener miningListener = new MiningListener(Main.getInstance());

        if (miningListener.getToggleEdit().contains(p)) {
            miningListener.getToggleEdit().remove(p);
            p.sendMessage(Utils.color(ConfigManager.getMessages().getString("Messages.EditOre.Disable")));
        } else {
            miningListener.getToggleEdit().add(p);
            p.sendMessage(Utils.color(ConfigManager.getMessages().getString("Messages.EditOre.Enable")));
        }
    }
}