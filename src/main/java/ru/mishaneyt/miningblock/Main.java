package ru.mishaneyt.miningblock;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.mishaneyt.miningblock.config.ConfigManager;
import ru.mishaneyt.miningblock.config.ConfigUtils;
import ru.mishaneyt.miningblock.utils.LoaderPlugin;

public class Main extends JavaPlugin implements Listener {
    private static Main instance = null;
    public static Economy economy = null;

    @Override
    public void onEnable() {
        Main.instance = this;

        ConfigUtils.onCheckConfig(this);

        ConfigManager.onLoad(this);
        LoaderPlugin.onLoadPlugin();

        LoaderPlugin.MessageConsole();
    }

    public static Main getInstance() {
        return instance;
    }
}