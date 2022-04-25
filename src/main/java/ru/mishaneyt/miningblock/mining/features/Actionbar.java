package ru.mishaneyt.miningblock.mining.features;

import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;

public class Actionbar {

    public static void sendActionbar(Player p, int money) {
        if (ConfigManager.ACTIONBAR_ENABLE) {
            String actionbar = ConfigManager.ACTIONBAR.replace("%money%", String.valueOf(money));
            Papi.connect(p, actionbar);

            p.sendActionBar(actionbar);
        }
    }
}