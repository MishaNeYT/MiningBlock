package ru.mishaneyt.miningblock.mining.features;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;

public class Chat {

    public static void sendMessage(Player p, String money) {
        if (ConfigManager.CHAT_ENABLE) {
            String msg = ConfigManager.CHAT;

            msg = msg.replace("%money%", money);
            PlaceholderAPI.setPlaceholders(p, msg);

            p.sendMessage(msg);
        }
    }
}