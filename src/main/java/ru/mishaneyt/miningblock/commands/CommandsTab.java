package ru.mishaneyt.miningblock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CommandsTab implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        List<String> line = new ArrayList<>();

        if (args.length == 1) {
            line.add("help");
            line.add("editore");
            line.add("reload");

            return line;
        }
        return null;
    }
}