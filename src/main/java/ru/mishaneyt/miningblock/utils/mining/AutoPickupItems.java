package ru.mishaneyt.miningblock.utils.mining;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.mishaneyt.miningblock.utils.FileUtil;

public class AutoPickupItems {

    public static void getAutoPickupCoal(Player player) {
        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("COAL.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("COAL.AutoPickup.Amount")));
    }

    public static void getAutoPickupIron(Player player) {
        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("IRON.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("IRON.AutoPickup.Amount")));
    }

    public static void getAutoPickupGold(Player player) {
        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("GOLD.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("GOLD.AutoPickup.Amount")));
    }

    public static void getAutoPickupDiamond(Player player) {
        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("DIAMOND.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("DIAMOND.AutoPickup.Amount")));
    }

    public static void getAutoPickupEmerald(Player player) {
        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("EMERALD.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("EMERALD.AutoPickup.Amount")));
    }

    public static void getAutoPickupLapis(Player player) {
        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("LAPIS.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("LAPIS.AutoPickup.Amount")));
    }

    public static void getAutoPickupRedstone(Player player) {
        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("REDSTONE.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("REDSTONE.AutoPickup.Amount")));
    }

    public static void getAutoPickupQuartz(Player player) {
        player.getInventory().addItem(new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("QUARTZ.AutoPickup.PickupBlock")), FileUtil.getMiningConfig().getInt("QUARTZ.AutoPickup.Amount")));
    }
}