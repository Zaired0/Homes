/*
 *
 * Author: Eliott Deriaz alias Zaired
 * Date: 06.05.2023
 * Description: /home commande file
 *
 * */
package homes.homes.commands;

import homes.homes.Class.PlayerHome;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Home implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        // controls that this is a player
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("Only players can run this command.");
            return false;
        }

        //get home location of the command Sender
        Location loc = PlayerHome.getPlayerHome(commandSender.getName());

        //controls that the location isn't null
        if(loc == null){
            commandSender.sendMessage("You don't have a home.");
            return false;
        }

        //teleport player to his home location
        Player p = (Player) commandSender;
        p.teleport(loc);

        //send confirmation
        commandSender.sendMessage("You're home.");

        return true;
    }
}