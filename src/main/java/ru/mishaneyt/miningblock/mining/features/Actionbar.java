package ru.mishaneyt.miningblock.mining.features;

import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;

public class Actionbar {

    public static void sendActionbar(Player p, String money) {
        if (ConfigManager.ACTIONBAR_ENABLE) {
            String actionbar = ConfigManager.ACTIONBAR.replace("%money%", money);
            Papi.connect(p, actionbar);

            p.sendActionBar(actionbar);
        }
    }
}