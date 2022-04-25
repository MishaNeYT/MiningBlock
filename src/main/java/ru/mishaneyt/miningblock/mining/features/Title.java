package ru.mishaneyt.miningblock.mining.features;

import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;

public class Title {

    public static void sendTitle(Player p, int money) {
        if (ConfigManager.TITLE_ENABLE) {
            String titleText = ConfigManager.TITLE.replace("%money%", String.valueOf(money));
            String subtitleText = ConfigManager.SUBTITLE.replace("%money%", String.valueOf(money));

            Papi.connect(p, titleText);
            Papi.connect(p, subtitleText);

            p.sendTitle(titleText, subtitleText, ConfigManager.FADEIN, ConfigManager.STAY, ConfigManager.FADEOUT);
        }
    }
}