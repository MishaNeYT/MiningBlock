package ru.mishaneyt.miningblock.mining.features;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;
import ru.mishaneyt.miningblock.utils.Utils;

public class Actionbar {

    public static void send(Player p, int money) {
        if (ConfigManager.getConfig().getBoolean("Actionbar.Enabled")) {
            String actionbar = ConfigManager.getMessages().getString("Messages.Actionbar.Message").replace("%money%", String.valueOf(money));
            Papi.connect(p, actionbar);

            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(Utils.color(actionbar)).create());
        }
    }
}