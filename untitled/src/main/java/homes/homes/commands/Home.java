package homes.homes.commands;

import homes.homes.Class.PlayerHome;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Home implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Location loc = PlayerHome.getPlayerHome(commandSender.getName());

        Player p = (Player) commandSender;

        if(loc != null){
            p.teleport(loc);
        }

        return true;
    }
}