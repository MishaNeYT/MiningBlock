package ru.mishaneyt.miningblock.mining.features;

import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;
import ru.mishaneyt.miningblock.utils.Utils;

public class Title {

    public static void send(Player p, int money) {
        if (ConfigManager.getConfig().getBoolean("TitlePickup.Enabled")) {
            String title = ConfigManager.getMessages().getString("Messages.Title.First").replace("%money%", String.valueOf(money));
            String subtitle = ConfigManager.getMessages().getString("Messages.Title.Subtitle").replace("%money%", String.valueOf(money));

            Papi.connect(p, title);
            Papi.connect(p, subtitle);

            int fadeIn = ConfigManager.getConfig().getInt("TitlePickup.FadeIn");
            int stay = ConfigManager.getConfig().getInt("TitlePickup.Stay");
            int fadeOut = ConfigManager.getConfig().getInt("TitlePickup.FadeOut");

            p.sendTitle(Utils.color(title), Utils.color(subtitle), fadeIn, stay, fadeOut);
        }
    }
}