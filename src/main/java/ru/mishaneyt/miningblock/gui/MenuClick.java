package ru.mishaneyt.miningblock.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import ru.mishaneyt.miningblock.utils.FileUtil;
import ru.mishaneyt.miningblock.utils.Utils;

public class MenuClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getType() == InventoryType.CHEST && event.getInventory().getTitle().equals(" ")) {
            Player player = (Player) event.getWhoClicked();

            if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().getType() == null) return;
            if (event.getCurrentItem().getItemMeta() == null) return;
            if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

            if (event.getCurrentItem().getType().equals(Material.COAL_ORE)) {
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledCoal(true);
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledCoal(false);
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.IRON_ORE)) {
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledIron(true);
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledIron(false);
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.GOLD_ORE)) {
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledGold(true);
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledGold(false);
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.DIAMOND_ORE)) {
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledDiamond(true);
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledDiamond(false);
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.EMERALD_ORE)) {
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledEmerald(true);
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledEmerald(false);
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.LAPIS_ORE)) {
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledLapis(true);
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledLapis(false);
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.REDSTONE_ORE)) {
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledRedstone(true);
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledRedstone(false);
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.QUARTZ_ORE)) {
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledQuartz(true);
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledQuartz(false);
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.ANVIL)) {
                FileUtil.reloadConfigs();
                player.closeInventory();
                player.sendMessage(Utils.color(Utils.getString("Messages.Reload")));
            } else if (event.getCurrentItem().getType().equals(Material.GOLD_INGOT)) {
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledVault(true);
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledVault(false);
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.NOTE_BLOCK)) {
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledMusic(true);
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledMusic(false);
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.TNT)) {
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledEditOre(true);
                    player.sendTitle("", "§fРедактирования руд - §aвключено", 20, 60, 40);
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledEditOre(false);
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.ITEM_FRAME)) {
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledTitle(true);
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledTitle(false);
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.PAINTING)) {
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledActionbar(true);
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledActionbar(false);
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.PAPER)) {
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledChat(true);
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledChat(false);
                    Menu.openGUI(player);
                }
            }
            event.setCancelled(true);
        }
    }
}