package ru.mishaneyt.miningblock.utils;

import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.config.ConfigManager;

public class Utils {
    private final Main main;
    private final Player player;

    public Utils(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    public static String color(String s) {
        if (s != null) return s.replace("&", "§");
        return null;
    }

    public void help() {
        String version = this.main.getDescription().getVersion();

        for (String message : ConfigManager.getMessages().getStringList("Messages.Help")) {
            this.player.sendMessage(message.replace("%version%", version).replace("&", "§"));
        }
    }

    public void editOre() {
        if (!this.main.getToggleEdit().contains(this.player)) {
            this.main.getToggleEdit().add(this.player);
            this.player.sendMessage(Utils.color(ConfigManager.getMessages().getString("Messages.EditOre.Enable")));
        } else {
            this.main.getToggleEdit().remove(this.player);
            this.player.sendMessage(Utils.color(ConfigManager.getMessages().getString("Messages.EditOre.Disable")));
        }
    }
}