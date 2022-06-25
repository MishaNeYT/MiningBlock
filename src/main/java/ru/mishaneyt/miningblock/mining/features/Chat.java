package ru.mishaneyt.miningblock.mining.features;

import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;

public class Chat {

    public static void send(Player p, int money) {
        if (ConfigManager.getConfig().getBoolean("MessageChat.Enabled"))
            for (String msg : ConfigManager.getMessages().getStringList("Messages.Chat.Message")) {
                msg = msg.replace("%money%", String.valueOf(money)).replace("&", "§");
                Papi.connect(p, msg);

                p.sendMessage(msg);
            }
    }
}