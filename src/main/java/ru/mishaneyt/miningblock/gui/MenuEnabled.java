package ru.mishaneyt.miningblock.gui;

import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.utils.FileUtil;

public class MenuEnabled {

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
        Main.getInstance().getConfig().set("Settings.EnableVault", status);
        Main.getInstance().saveConfig();
    }

    public static void setEnabledMusic(boolean status) {
        Menu.enabled = status;
        Main.getInstance().getConfig().set("Sound.EnableSoundPickup", status);
        Main.getInstance().saveConfig();
    }

    public static void setEnabledEditOre(boolean status) {
        Menu.enabled = status;
        Main.getInstance().getConfig().set("Settings.EnableEditOre", status);
        Main.getInstance().saveConfig();
    }

    public static void setEnabledTitle(boolean status) {
        Menu.enabled = status;
        Main.getInstance().getConfig().set("TitleOnPickup.EnableTitles", status);
        Main.getInstance().saveConfig();
    }

    public static void setEnabledActionbar(boolean status) {
        Menu.enabled = status;
        Main.getInstance().getConfig().set("Actionbar.EnableActionbar", status);
        Main.getInstance().saveConfig();
    }

    public static void setEnabledChat(boolean status) {
        Menu.enabled = status;
        Main.getInstance().getConfig().set("MessageToChat.EnableMessageToChat", status);
        Main.getInstance().saveConfig();
    }
}