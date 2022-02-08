package ru.mishaneyt.miningblock.gui;

import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.utils.FileUtil;

public class MenuSettings {
    static String enableCoal, enableParticleCoal, enableCoalDrop, enableCoalAutoPickup, enableCoalCMD,
            enableIron, enableParticleIron, enableIronDrop, enableIronAutoPickup, enableIronCMD, enableGold,
            enableParticleGold, enableGoldDrop, enableGoldAutoPickup, enableGoldCMD, enableDiamond,
            enableParticleDiamond, enableDiamondDrop, enableDiamondAutoPickup, enableDiamondCMD, enableEmerald,
            enableParticleEmerald, enableEmeraldDrop, enableEmeraldAutoPickup, enableEmeraldCMD, enableVault,
            enableMusic, enableEditOre, enableTitle, enableActionbar, enableChat, enableLapis, enableParticleLapis,
            enableLapisDrop, enableLapisAutoPickup, enableLapisCMD, enableRedstone, enableParticleRedstone,
            enableRedstoneDrop, enableRedstoneAutoPickup, enableRedstoneCMD, enableQuartz, enableParticleQuartz,
            enableQuartzDrop, enableQuartzAutoPickup, enableQuartzCMD;

    public static String enableCoal() {
        if (FileUtil.getMiningConfig().getBoolean("COAL.Enable")) {
            enableCoal = "§8[§a✔§8]§7";
        } else {
            enableCoal = "§8[§c✖§8]§7";
        }
        return enableCoal;
    }

    public static String enableParticleCoal() {
        if (FileUtil.getMiningConfig().getBoolean("COAL.ParticleBreak.enable")) {
            enableParticleCoal = "§a✔";
        } else {
            enableParticleCoal = "§c✖";
        }
        return enableParticleCoal;
    }

    public static String enableCoalDrop() {
        if (FileUtil.getMiningConfig().getBoolean("COAL.Drop.Enable")) {
            enableCoalDrop = "§a✔";
        } else {
            enableCoalDrop = "§c✖";
        }
        return enableCoalDrop;
    }

    public static String enableCoalAutoPickup() {
        if (FileUtil.getMiningConfig().getBoolean("COAL.AutoPickup.Enable")) {
            enableCoalAutoPickup = "§a✔";
        } else {
            enableCoalAutoPickup = "§c✖";
        }
        return enableCoalAutoPickup;
    }

    public static String enableCoalCMD() {
        if (FileUtil.getMiningConfig().getBoolean("COAL.CommandBreak.enable")) {
            enableCoalCMD = "§a✔";
        } else {
            enableCoalCMD = "§c✖";
        }
        return enableCoalCMD;
    }

    /* =========================================================== */

    public static String enableIron() {
        if (FileUtil.getMiningConfig().getBoolean("IRON.Enable")) {
            enableIron = "§8[§a✔§8]§f";
        } else {
            enableIron = "§8[§c✖§8]§f";
        }
        return enableIron;
    }

    public static String enableParticleIron() {
        if (FileUtil.getMiningConfig().getBoolean("IRON.ParticleBreak.enable")) {
            enableParticleIron = "§a✔";
        } else {
            enableParticleIron = "§c✖";
        }
        return enableParticleIron;
    }

    public static String enableIronDrop() {
        if (FileUtil.getMiningConfig().getBoolean("IRON.Drop.Enable")) {
            enableIronDrop = "§a✔";
        } else {
            enableIronDrop = "§c✖";
        }
        return enableIronDrop;
    }

    public static String enableIronAutoPickup() {
        if (FileUtil.getMiningConfig().getBoolean("IRON.AutoPickup.Enable")) {
            enableIronAutoPickup = "§a✔";
        } else {
            enableIronAutoPickup = "§c✖";
        }
        return enableIronAutoPickup;
    }

    public static String enableIronCMD() {
        if (FileUtil.getMiningConfig().getBoolean("IRON.CommandBreak.enable")) {
            enableIronCMD = "§a✔";
        } else {
            enableIronCMD = "§c✖";
        }
        return enableIronCMD;
    }

    /* =========================================================== */

    public static String enableGold() {
        if (FileUtil.getMiningConfig().getBoolean("GOLD.Enable")) {
            enableGold = "§8[§a✔§8]§e";
        } else {
            enableGold = "§8[§c✖§8]§e";
        }
        return enableGold;
    }

    public static String enableParticleGold() {
        if (FileUtil.getMiningConfig().getBoolean("GOLD.ParticleBreak.enable")) {
            enableParticleGold = "§a✔";
        } else {
            enableParticleGold = "§c✖";
        }
        return enableParticleGold;
    }

    public static String enableGoldDrop() {
        if (FileUtil.getMiningConfig().getBoolean("GOLD.Drop.Enable")) {
            enableGoldDrop = "§a✔";
        } else {
            enableGoldDrop = "§c✖";
        }
        return enableGoldDrop;
    }

    public static String enableGoldAutoPickup() {
        if (FileUtil.getMiningConfig().getBoolean("GOLD.AutoPickup.Enable")) {
            enableGoldAutoPickup = "§a✔";
        } else {
            enableGoldAutoPickup = "§c✖";
        }
        return enableGoldAutoPickup;
    }

    public static String enableGoldCMD() {
        if (FileUtil.getMiningConfig().getBoolean("GOLD.CommandBreak.enable")) {
            enableGoldCMD = "§a✔";
        } else {
            enableGoldCMD = "§c✖";
        }
        return enableGoldCMD;
    }

    /* =========================================================== */

    public static String enableDiamond() {
        if (FileUtil.getMiningConfig().getBoolean("DIAMOND.Enable")) {
            enableDiamond = "§8[§a✔§8]§b";
        } else {
            enableDiamond = "§8[§c✖§8]§b";
        }
        return enableDiamond;
    }

    public static String enableParticleDiamond() {
        if (FileUtil.getMiningConfig().getBoolean("DIAMOND.ParticleBreak.enable")) {
            enableParticleDiamond = "§a✔";
        } else {
            enableParticleDiamond = "§c✖";
        }
        return enableParticleDiamond;
    }

    public static String enableDiamondDrop() {
        if (FileUtil.getMiningConfig().getBoolean("DIAMOND.Drop.Enable")) {
            enableDiamondDrop = "§a✔";
        } else {
            enableDiamondDrop = "§c✖";
        }
        return enableDiamondDrop;
    }

    public static String enableDiamondAutoPickup() {
        if (FileUtil.getMiningConfig().getBoolean("DIAMOND.AutoPickup.Enable")) {
            enableDiamondAutoPickup = "§a✔";
        } else {
            enableDiamondAutoPickup = "§c✖";
        }
        return enableDiamondAutoPickup;
    }

    public static String enableDiamondCMD() {
        if (FileUtil.getMiningConfig().getBoolean("DIAMOND.CommandBreak.enable")) {
            enableDiamondCMD = "§a✔";
        } else {
            enableDiamondCMD = "§c✖";
        }
        return enableDiamondCMD;
    }

    /* =========================================================== */

    public static String enableEmerald() {
        if (FileUtil.getMiningConfig().getBoolean("EMERALD.Enable")) {
            enableEmerald = "§8[§a✔§8]§a";
        } else {
            enableEmerald = "§8[§c✖§8]§a";
        }
        return enableEmerald;
    }

    public static String enableParticleEmerald() {
        if (FileUtil.getMiningConfig().getBoolean("EMERALD.ParticleBreak.enable")) {
            enableParticleEmerald = "§a✔";
        } else {
            enableParticleEmerald = "§c✖";
        }
        return enableParticleEmerald;
    }

    public static String enableEmeraldDrop() {
        if (FileUtil.getMiningConfig().getBoolean("EMERALD.Drop.Enable")) {
            enableEmeraldDrop = "§a✔";
        } else {
            enableEmeraldDrop = "§c✖";
        }
        return enableEmeraldDrop;
    }

    public static String enableEmeraldAutoPickup() {
        if (FileUtil.getMiningConfig().getBoolean("EMERALD.AutoPickup.Enable")) {
            enableEmeraldAutoPickup = "§a✔";
        } else {
            enableEmeraldAutoPickup = "§c✖";
        }
        return enableEmeraldAutoPickup;
    }

    public static String enableEmeraldCMD() {
        if (FileUtil.getMiningConfig().getBoolean("EMERALD.CommandBreak.enable")) {
            enableEmeraldCMD = "§a✔";
        } else {
            enableEmeraldCMD = "§c✖";
        }
        return enableEmeraldCMD;
    }

    /* =========================================================== */

    public static String enableLapis() {
        if (FileUtil.getMiningConfig().getBoolean("LAPIS.Enable")) {
            enableLapis = "§8[§a✔§8]§9";
        } else {
            enableLapis = "§8[§c✖§8]§9";
        }
        return enableLapis;
    }

    public static String enableParticleLapis() {
        if (FileUtil.getMiningConfig().getBoolean("LAPIS.ParticleBreak.enable")) {
            enableParticleLapis = "§a✔";
        } else {
            enableParticleLapis = "§c✖";
        }
        return enableParticleLapis;
    }

    public static String enableLapisDrop() {
        if (FileUtil.getMiningConfig().getBoolean("LAPIS.Drop.Enable")) {
            enableLapisDrop = "§a✔";
        } else {
            enableLapisDrop = "§c✖";
        }
        return enableLapisDrop;
    }

    public static String enableLapisAutoPickup() {
        if (FileUtil.getMiningConfig().getBoolean("LAPIS.AutoPickup.Enable")) {
            enableLapisAutoPickup = "§a✔";
        } else {
            enableLapisAutoPickup = "§c✖";
        }
        return enableLapisAutoPickup;
    }

    public static String enableLapisCMD() {
        if (FileUtil.getMiningConfig().getBoolean("LAPIS.CommandBreak.enable")) {
            enableLapisCMD = "§a✔";
        } else {
            enableLapisCMD = "§c✖";
        }
        return enableLapisCMD;
    }

    /* =========================================================== */

    public static String enableRedstone() {
        if (FileUtil.getMiningConfig().getBoolean("REDSTONE.Enable")) {
            enableRedstone = "§8[§a✔§8]§c";
        } else {
            enableRedstone = "§8[§c✖§8]§c";
        }
        return enableRedstone;
    }

    public static String enableParticleRedstone() {
        if (FileUtil.getMiningConfig().getBoolean("REDSTONE.ParticleBreak.enable")) {
            enableParticleRedstone = "§a✔";
        } else {
            enableParticleRedstone = "§c✖";
        }
        return enableParticleRedstone;
    }

    public static String enableRedstoneDrop() {
        if (FileUtil.getMiningConfig().getBoolean("REDSTONE.Drop.Enable")) {
            enableRedstoneDrop = "§a✔";
        } else {
            enableRedstoneDrop = "§c✖";
        }
        return enableRedstoneDrop;
    }

    public static String enableRedstoneAutoPickup() {
        if (FileUtil.getMiningConfig().getBoolean("REDSTONE.AutoPickup.Enable")) {
            enableRedstoneAutoPickup = "§a✔";
        } else {
            enableRedstoneAutoPickup = "§c✖";
        }
        return enableRedstoneAutoPickup;
    }

    public static String enableRedstoneCMD() {
        if (FileUtil.getMiningConfig().getBoolean("REDSTONE.CommandBreak.enable")) {
            enableRedstoneCMD = "§a✔";
        } else {
            enableRedstoneCMD = "§c✖";
        }
        return enableRedstoneCMD;
    }

    /* =========================================================== */

    public static String enableQuartz() {
        if (FileUtil.getMiningConfig().getBoolean("QUARTZ.Enable")) {
            enableQuartz = "§8[§a✔§8]§4";
        } else {
            enableQuartz = "§8[§c✖§8]§4";
        }
        return enableQuartz;
    }

    public static String enableParticleQuartz() {
        if (FileUtil.getMiningConfig().getBoolean("QUARTZ.ParticleBreak.enable")) {
            enableParticleQuartz = "§a✔";
        } else {
            enableParticleQuartz = "§c✖";
        }
        return enableParticleQuartz;
    }

    public static String enableQuartzDrop() {
        if (FileUtil.getMiningConfig().getBoolean("QUARTZ.Drop.Enable")) {
            enableQuartzDrop = "§a✔";
        } else {
            enableQuartzDrop = "§c✖";
        }
        return enableQuartzDrop;
    }

    public static String enableQuartzAutoPickup() {
        if (FileUtil.getMiningConfig().getBoolean("QUARTZ.AutoPickup.Enable")) {
            enableQuartzAutoPickup = "§a✔";
        } else {
            enableQuartzAutoPickup = "§c✖";
        }
        return enableQuartzAutoPickup;
    }

    public static String enableQuartzCMD() {
        if (FileUtil.getMiningConfig().getBoolean("QUARTZ.CommandBreak.enable")) {
            enableQuartzCMD = "§a✔";
        } else {
            enableQuartzCMD = "§c✖";
        }
        return enableQuartzCMD;
    }

    /* =========================================================== */

    public static String enableVault() {
        if (Main.getInstance().getConfig().getBoolean("Settings.EnableVault")) {
            enableVault = "§8[§a✔§8]§6";
        } else {
            enableVault = "§8[§c✖§8]§6";
        }
        return enableVault;
    }

    public static String enableMusic() {
        if (Main.getInstance().getConfig().getBoolean("Sound.EnableSoundPickup")) {
            enableMusic = "§8[§a✔§8]§9";
        } else {
            enableMusic = "§8[§c✖§8]§9";
        }
        return enableMusic;
    }

    public static String enableEditOre() {
        if (Main.getInstance().getConfig().getBoolean("Settings.EnableEditOre")) {
            enableEditOre = "§8[§a✔§8]§c";
        } else {
            enableEditOre = "§8[§c✖§8]§c";
        }
        return enableEditOre;
    }

    public static String enableTitle() {
        if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.EnableTitles")) {
            enableTitle = "§8[§a✔§8]§a";
        } else {
            enableTitle = "§8[§c✖§8]§a";
        }
        return enableTitle;
    }

    public static String enableActionbar() {
        if (Main.getInstance().getConfig().getBoolean("Actionbar.EnableActionbar")) {
            enableActionbar = "§8[§a✔§8]§a";
        } else {
            enableActionbar = "§8[§c✖§8]§a";
        }
        return enableActionbar;
    }

    public static String enableChat() {
        if (Main.getInstance().getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
            enableChat = "§8[§a✔§8]§a";
        } else {
            enableChat = "§8[§c✖§8]§a";
        }
        return enableChat;
    }
}