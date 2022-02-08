package ru.mishaneyt.miningblock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.gui.Menu;
import ru.mishaneyt.miningblock.utils.FileUtil;
import ru.mishaneyt.miningblock.utils.Utils;

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

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("miningblock")) {
            if (args.length == 0) {
                for (String message : Main.getInstance().getConfig().getStringList("Messages.UseCommand")) {
                    sender.sendMessage(Utils.color(message)
                            .replace("%version%", Main.getInstance().getDescription().getVersion()));
                }

            } else if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
                for (String message : Main.getInstance().getConfig().getStringList("Messages.UseCommand")) {
                    sender.sendMessage(Utils.color(message)
                            .replace("%version%", Main.getInstance().getDescription().getVersion()));
                }
            } else if (args.length == 1 && args[0].equalsIgnoreCase("menu")) {
                Menu.openGUI(player);
                return false;
            } else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                Main.getInstance().reloadConfig();
                Main.getInstance().saveConfig();
                FileUtil.reloadMining();
                FileUtil.saveMining();
                sender.sendMessage(Utils.color(Utils.getString("Messages.Reload")));
                return true;
            } else {
                sender.sendMessage(Utils.color(Utils.getString("Messages.Error")));
                return true;
            }
        }
        return false;
    }
}