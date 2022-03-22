package ru.mishaneyt.miningblock.mining.features;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class DropItem {

    public static void dropItem(Block block, String item, int amount) {
        block.getLocation().add(0.5D, 2.0D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(item), amount));
    }
}