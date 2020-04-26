package Musicaly.Tab;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Music  implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("music") && args.length < 2) {
            if (commandSender instanceof Player) {
                List<String> argsList = new ArrayList<>();
                argsList.add("reload");
                return argsList;

            }
        }
        return null;
    }
}