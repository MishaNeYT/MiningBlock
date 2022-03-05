package ru.mishaneyt.miningblock;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.mishaneyt.miningblock.utils.FileUtil;

public class Main extends JavaPlugin implements Listener {
    public static Economy economy = null;

    @Override
    public void onEnable() {
        if (!getDataFolder().isFile()) {
            saveDefaultConfig();

            getLogger().info("");
            getLogger().info("§2Основной конфиг успешно создан!");
            getLogger().info("");
        }

        saveResource("mining.yml", false);

        Register.setupPlaceholder();
        Register.setupEconomy();

        Register.getCommand();
        Register.registerEvents();

        Register.MessageConsole();
    }

    @Override
    public void onDisable() {
        FileUtil.saveMining();
        saveConfig();
    }
}