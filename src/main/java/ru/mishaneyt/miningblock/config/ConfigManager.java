package ru.mishaneyt.miningblock.config;

import org.bukkit.configuration.Configuration;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.utils.UtilsManager;

public class ConfigManager {
    public static String ONLY_PLAYER;
    public static String PERMISSION;
    public static String PERMISSION_MSG;
    public static String ERROR;
    public static String RELOAD;

    public static Boolean BC_ERROR;

    public static String ENABLE_WORLDS;
    public static Boolean VAULT_ENABLE;
    public static Boolean PLACEHOLDER_ENABLE;

    public static Boolean FULLINV_ENABLE;
    public static String FULLINV_TITLE;
    public static String FULLINV_SUBTITLE;

    public static Boolean EDITORE;

    public static String EDITORE_ENABLE;
    public static String EDITORE_DISABLE;

    public static Boolean SOUND_ENABLE;
    public static String SOUND;

    public static Boolean TITLE_ENABLE;
    public static String TITLE;
    public static String SUBTITLE;
    public static Integer FADEIN;
    public static Integer STAY;
    public static Integer FADEOUT;

    public static Boolean ACTIONBAR_ENABLE;
    public static String ACTIONBAR;

    public static Boolean CHAT_ENABLE;
    public static String CHAT;

    public static void onLoad() {
        Configuration config = Main.getInstance().getConfig();

        ONLY_PLAYER = UtilsManager.getStringColor("Messages.OnlyPlayer");
        PERMISSION = UtilsManager.getString("Settings.Permission");
        PERMISSION_MSG = UtilsManager.getStringColor("Messages.NoPerms");
        ERROR = UtilsManager.getStringColor("Messages.ErrorCmd");
        RELOAD = UtilsManager.getStringColor("Messages.Reload");

        BC_ERROR = config.getBoolean("Settings.InfoErrorChat");

        ENABLE_WORLDS = String.valueOf(config.getStringList("Settings.EnableWorlds"));
        VAULT_ENABLE = config.getBoolean("Settings.EnableVault");
        PLACEHOLDER_ENABLE = config.getBoolean("Settings.EnablePlaceholder");

        FULLINV_ENABLE = config.getBoolean("Seetings.EnableFullInventory");
        FULLINV_TITLE = UtilsManager.getStringColor("Messages.FullInventory.Title");
        FULLINV_SUBTITLE = UtilsManager.getStringColor("Messages.FullInventory.Subtitle");

        EDITORE = config.getBoolean("Settings.BreakCreative");

        SOUND_ENABLE = config.getBoolean("SoundPickup.Enable");
        SOUND = UtilsManager.getString("SoundPickup.Sound");

        EDITORE_ENABLE = UtilsManager.getStringColor("Messages.EditOre.Enable");
        EDITORE_DISABLE = UtilsManager.getStringColor("Messages.EditOre.Disable");

        TITLE_ENABLE = config.getBoolean("TitleOnPickup.Enable");
        TITLE = UtilsManager.getStringColor("TitleOnPickup.Title");
        SUBTITLE = UtilsManager.getStringColor("TitleOnPickup.Subtitle");
        FADEIN = config.getInt("TitleOnPickup.FadeIn");
        STAY = config.getInt("TitleOnPickup.Stay");
        FADEOUT = config.getInt("TitleOnPickup.FadeOut");

        ACTIONBAR_ENABLE = config.getBoolean("Actionbar.Enable");
        ACTIONBAR = UtilsManager.getStringColor("Actionbar.Message");

        CHAT_ENABLE = config.getBoolean("MessageToChat.Enable");
        CHAT = String.valueOf(config.getStringList("MessageToChat.Message"));
    }
}