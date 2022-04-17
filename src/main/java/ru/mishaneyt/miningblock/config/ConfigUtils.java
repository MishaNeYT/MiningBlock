package ru.mishaneyt.miningblock.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.mining.features.PlaySound;
import ru.mishaneyt.miningblock.utils.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ConfigUtils {
    static File config = new File(Main.getInstance().getDataFolder(), "config.yml");
    static File mining = new File(Main.getInstance().getDataFolder(), "mining.yml");

    private static final File miningFile = new File(Main.getInstance().getDataFolder(), "mining.yml");
    private static FileConfiguration miningConfig = YamlConfiguration.loadConfiguration(miningFile);

    public static FileConfiguration getMiningConfig() {
        return miningConfig;
    }

    public static File getMiningFile() {
        return miningFile;
    }

    public static void saveMining() {
        try {
            getMiningConfig().save(getMiningFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reloadConfigs(Player p) {
        PluginManager pm = Bukkit.getPluginManager();
        miningConfig = YamlConfiguration.loadConfiguration(miningFile);

        InputStream defConfigStream = Main.getInstance().getResource("mining.yml");
        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(miningFile);
            miningConfig.setDefaults(defConfig);
        }

        saveMining();

        pm.disablePlugin(Main.getInstance());
        pm.getPlugin("MiningBlock").reloadConfig();
        pm.enablePlugin(Main.getInstance());

        try {
            PlaySound.playSound(p);
        } catch (Exception e) {
            Logger.warn("Пожалуйста, проверьте звук в config.yml. Ваша версия ядра, может его не поддерживать.");
        }

        p.sendMessage(ConfigManager.RELOAD);
    }

    public static void onCheckConfig(Main main) {
        if (!config.exists()) {
            main.saveDefaultConfig();
            Logger.empty("Конфиг config.yml - успешно создан.");
        }

        if (!mining.exists()) {
            main.saveResource("mining.yml", false);
            Logger.empty("Конфиг mining.yml - успешно создан.");
        }
    }
}