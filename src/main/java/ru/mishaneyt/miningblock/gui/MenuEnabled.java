package ru.mishaneyt.miningblock.gui;

import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.utils.FileUtil;

public class MenuEnabled {
    static final Main plugin = Main.getPlugin(Main.class);

    public static void setEnabledCoal(boolean status) {
        Menu.enabled = status;
        FileUtil.getMiningConfig().set("COAL.Enable", status);
        FileUtil.saveMining();
    }

    public static void setEnabledIron(boolean status) {
        Menu.enabled = status;
        FileUtil.getMiningConfig().set("IRON.Enable", status);
        FileUtil.saveMining();
    }

    public static void setEnabledGold(boolean status) {
        Menu.enabled = status;
        FileUtil.getMiningConfig().set("GOLD.Enable", status);
        FileUtil.saveMining();
    }

    public static void setEnabledDiamond(boolean status) {
        Menu.enabled = status;
        FileUtil.getMiningConfig().set("DIAMOND.Enable", status);
        FileUtil.saveMining();
    }

    public static void setEnabledEmerald(boolean status) {
        Menu.enabled = status;
        FileUtil.getMiningConfig().set("EMERALD.Enable", status);
        FileUtil.saveMining();
    }

    public static void setEnabledLapis(boolean status) {
        Menu.enabled = status;
        FileUtil.getMiningConfig().set("LAPIS.Enable", status);
        FileUtil.saveMining();
    }

    public static void setEnabledRedstone(boolean status) {
        Menu.enabled = status;
        FileUtil.getMiningConfig().set("REDSTONE.Enable", status);
        FileUtil.saveMining();
    }

    public static void setEnabledQuartz(boolean status) {
        Menu.enabled = status;
        FileUtil.getMiningConfig().set("QUARTZ.Enable", status);
        FileUtil.saveMining();
    }

    public static void setEnabledVault(boolean status) {
        Menu.enabled = status;
        plugin.getConfig().set("Settings.EnableVault", status);
        plugin.saveConfig();
    }

    public static void setEnabledMusic(boolean status) {
        Menu.enabled = status;
        plugin.getConfig().set("Sound.EnableSoundPickup", status);
        plugin.saveConfig();
    }

    public static void setEnabledEditOre(boolean status) {
        Menu.enabled = status;
        plugin.getConfig().set("Settings.EnableEditOre", status);
        plugin.saveConfig();
    }

    public static void setEnabledTitle(boolean status) {
        Menu.enabled = status;
        plugin.getConfig().set("TitleOnPickup.EnableTitles", status);
        plugin.saveConfig();
    }

    public static void setEnabledActionbar(boolean status) {
        Menu.enabled = status;
        plugin.getConfig().set("Actionbar.EnableActionbar", status);
        plugin.saveConfig();
    }

    public static void setEnabledChat(boolean status) {
        Menu.enabled = status;
        plugin.getConfig().set("MessageToChat.EnableMessageToChat", status);
        plugin.saveConfig();
    }
}