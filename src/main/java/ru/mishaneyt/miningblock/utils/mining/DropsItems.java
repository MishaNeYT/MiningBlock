package ru.mishaneyt.miningblock.utils.mining;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import ru.mishaneyt.miningblock.utils.FileUtil;

public class DropsItems {

    public static void getDropCoal(Block block) {
        block.getLocation().add(0.5D, 0.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("COAL.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("COAL.Drop.Amount")));
    }

    public static void getDropIron(Block block) {
        block.getLocation().add(0.5D, 0.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("IRON.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("IRON.Drop.Amount")));
    }

    public static void getDropGold(Block block) {
        block.getLocation().add(0.5D, 0.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("GOLD.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("GOLD.Drop.Amount")));
    }

    public static void getDropDiamond(Block block) {
        block.getLocation().add(0.5D, 0.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("DIAMOND.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("DIAMOND.Drop.Amount")));
    }

    public static void getDropEmerald(Block block) {
        block.getLocation().add(0.5D, 0.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("EMERALD.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("EMERALD.Drop.Amount")));
    }

    public static void getDropLapis(Block block) {
        block.getLocation().add(0.5D, 0.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("LAPIS.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("LAPIS.Drop.Amount")));
    }

    public static void getDropRedstone(Block block) {
        block.getLocation().add(0.5D, 0.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("REDSTONE.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("REDSTONE.Drop.Amount")));
    }

    public static void getDropQuartz(Block block) {
        block.getLocation().add(0.5D, 0.5D, 0.5D).getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.valueOf(FileUtil.getMiningConfig().getString("QUARTZ.Drop.DropBlock")), FileUtil.getMiningConfig().getInt("QUARTZ.Drop.Amount")));
    }
}