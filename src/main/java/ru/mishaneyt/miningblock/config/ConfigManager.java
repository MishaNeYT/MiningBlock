package ru.mishaneyt.miningblock.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.utils.Logger;
import ru.mishaneyt.miningblock.utils.Utils;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    private final Main main;

    public ConfigManager(Main main) {
        this.main = main;
    }

    private static final File config_file = new File(Main.getInstance().getDataFolder(), "config.yml");
    private static final FileConfiguration config = YamlConfiguration.loadConfiguration(config_file);

    private static final File mining_file = new File(Main.getInstance().getDataFolder(), "mining.yml");
    private static final FileConfiguration mining = YamlConfiguration.loadConfiguration(mining_file);

    private static final File messages_file = new File(Main.getInstance().getDataFolder(), "messages.yml");
    private static final FileConfiguration messages = YamlConfiguration.loadConfiguration(messages_file);

    public static FileConfiguration getConfig() {
        return config;
    }

    public static FileConfiguration getMining() {
        return mining;
    }

    public static FileConfiguration getMessages() {
        return messages;
    }

    public void checkConfigurations() {
        if (!config_file.exists()) {
            this.main.saveResource("config.yml", false);
            Logger.info("§aКонфигурация config.yml - успешно создан.");
        }
        if (!mining_file.exists()) {
            this.main.saveResource("mining.yml", false);
            Logger.info("§aКонфигурация mining.yml - успешно создан.");
        }
        if (!messages_file.exists()) {
            this.main.saveResource("messages.yml", false);
            Logger.info("§aКонфигурация messages.yml - успешно создан.");
        }
    }

    public void saveConfigs() {
        try {
            getConfig().save(config_file);
            getMining().save(mining_file);
            getMessages().save(messages_file);

        } catch (IOException ex) {
            Logger.error("Не удалось сохранить конфигурации..");
        }
    }

    public void reloadEnable() {
        this.checkConfigurations();

        try {
            getConfig().load(config_file);
            getMining().load(mining_file);
            getMessages().load(messages_file);
            saveConfigs();

        } catch (IOException | InvalidConfigurationException ex) {
            Logger.error("Не удалось перезагрузить конфигурации..");
        }
    }

    public void reloadPlugin(Player p) {
        this.checkConfigurations();

        try {
            getConfig().load(config_file);
            getMining().load(mining_file);
            getMessages().load(messages_file);
            saveConfigs();

            if (getConfig().getBoolean("Settings.AdvanceReload")) {
                PluginManager pm = Bukkit.getPluginManager();

                pm.disablePlugin(this.main);
                pm.enablePlugin(this.main);
            }

            p.sendMessage(Utils.color(getMessages().getString("Messages.Command.Reload")));

        } catch (IOException | InvalidConfigurationException ex) {
            Logger.error("Не удалось перезагрузить конфигурации..");
        }
    }
}