package ru.mishaneyt.miningblock.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ru.mishaneyt.miningblock.Main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
    static final Main plugin = Main.getPlugin(Main.class);
    private static final File miningFile = new File(plugin.getDataFolder(), "mining.yml");
    private static FileConfiguration miningConfig = YamlConfiguration.loadConfiguration(miningFile);

    public static FileConfiguration getMiningConfig() {
        return miningConfig;
    }

    public static File getMiningFile() {
        return miningFile;
    }

    public static void saveMining() {
        try {
            FileUtil.getMiningConfig().save(FileUtil.getMiningFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reloadConfigs() {
        miningConfig = YamlConfiguration.loadConfiguration(miningFile);

        InputStream defConfigStream = plugin.getResource("mining.yml");
        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(miningFile);
            miningConfig.setDefaults(defConfig);
        }

        try {
            FileUtil.getMiningConfig().save(FileUtil.getMiningFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        plugin.reloadConfig();
        plugin.saveConfig();
    }
}