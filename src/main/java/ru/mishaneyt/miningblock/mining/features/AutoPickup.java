package ru.mishaneyt.miningblock.mining.features;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AutoPickup {

    public static void pickupItem(Player p, String item, int amount) {
        p.getInventory().addItem(new ItemStack(Material.valueOf(item), amount));
    }
}