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
    static final Main plugin = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.colorString("Messages.CommandOnlyServer"));
            return false;
        }

        if (!sender.hasPermission(Utils.getString("Settings.Permission"))) {
            sender.sendMessage(Utils.colorString("Messages.NoPerm"));
            return false;
        }

        Player player = (Player) sender;

        if (args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "help":
                    for (String message : plugin.getConfig().getStringList("Messages.UseCommand")) {
                        sender.sendMessage(Utils.color(message).replace("%version%", plugin.getDescription().getVersion()));
                    }
                    break;
                case "menu":
                    Menu.openGUI(player);
                    break;
                case "reload":
                    FileUtil.reloadConfigs();
                    sender.sendMessage(Utils.colorString("Messages.Reload"));
                    break;
            }
        } else {
            for (String message : plugin.getConfig().getStringList("Messages.UseCommand")) {
                sender.sendMessage(Utils.color(message).replace("%version%", plugin.getDescription().getVersion()));
            }
            return true;
        }
        return false;
    }
}