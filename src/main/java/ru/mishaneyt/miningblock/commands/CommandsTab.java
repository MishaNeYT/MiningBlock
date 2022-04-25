package ru.mishaneyt.miningblock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import ru.mishaneyt.miningblock.config.ConfigManager;

import java.util.ArrayList;
import java.util.List;

public class CommandsTab implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        List<String> arg = new ArrayList<>();

        if (args.length == 1) {
            if (sender.hasPermission(ConfigManager.PERMISSION)) {
                arg.add("help");
                arg.add("menu");
                arg.add("editore");
                arg.add("reload");
            }
            return arg;
        }
        return null;
    }
}