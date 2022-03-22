package ru.mishaneyt.miningblock.mining.features;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;

public class Actionbar {

    public static void sendActionbar(Player p, String money) {
        if (ConfigManager.ACTIONBAR_ENABLE) {
            String actionbar = ConfigManager.ACTIONBAR;

            actionbar = actionbar.replace("%money%", money);
            PlaceholderAPI.setPlaceholders(p, money);

            p.sendActionBar(actionbar);
        }
    }
}