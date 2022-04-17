package ru.mishaneyt.miningblock.mining.features;

import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.config.ConfigManager;

public class Chat {

    public static void sendMessage(Player p, String money) {
        if (ConfigManager.CHAT_ENABLE) {
            for (String msg : Main.getInstance().getConfig().getStringList("MessageToChat.Message")) {
                msg = msg.replace("%money%", money).replace("&", "§");
                Papi.connect(p, msg);

                p.sendMessage(msg);
            }
        }
    }
}