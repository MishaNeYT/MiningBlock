package ru.mishaneyt.miningblock.mining.features;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;

public class Title {

    public static void sendTitle(Player p, String money) {
        if (ConfigManager.TITLE_ENABLE) {
            String titleText = ConfigManager.TITLE;
            String subtitleText = ConfigManager.SUBTITLE;

            titleText = titleText.replace("%money%", money);
            subtitleText = subtitleText.replace("%money%", money);

            titleText = PlaceholderAPI.setPlaceholders(p, titleText);
            subtitleText = PlaceholderAPI.setPlaceholders(p, subtitleText);

            p.sendTitle(titleText, subtitleText, ConfigManager.FADEIN, ConfigManager.STAY, ConfigManager.FADEOUT);
        }
    }
}