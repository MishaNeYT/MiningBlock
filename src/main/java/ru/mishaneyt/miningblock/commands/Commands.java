package ru.mishaneyt.miningblock.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.Utils;
import ru.mishaneyt.miningblock.gui.Menu;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.color(Utils.getString("Messages.CommandOnlyServer")));
            return false;
        }

        if (!(sender.hasPermission(Utils.getString("Settings.Permission")))) {
            sender.sendMessage(Utils.color(Utils.getString("Messages.NoPerm")));
            return false;
        }

        if (cmd.getName().equalsIgnoreCase("miningblock")) {
            if (args.length == 0) {
                for (String message : Main.getInstance().getConfig().getStringList("Messages.UseCommand")) {
                    sender.sendMessage(Utils.color(message)
                            .replace("%version%", Main.getInstance().getDescription().getVersion()));
                }
            }

            Player player = (Player) sender;
            if (args.length == 1 && args[0].equalsIgnoreCase("menu")) {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                Menu.openGUI(player);
                return false;
            } else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                Main.getInstance().reloadConfig();
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                player.sendMessage(Utils.color(Utils.getString("Messages.Reload")));
                return false;
            }
        }
        return false;
    }
}