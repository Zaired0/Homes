/*
 *
 * Author: Eliott Deriaz alias Zaired
 * Date: 06.05.2023
 * Description: /sethome command file
 *
 * */
package homes.homes.commands;

import org.bukkit.command.Command;
import homes.homes.Class.PlayerHome;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class SetHome implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String [] args){
        // controls that this is a player
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("Only players can run this command.");
            return true;
        }

        Player p = (Player) commandSender;

        //controls that the player is on the ground
        if(!p.isOnGround()){
            commandSender.sendMessage("You can only place your home on ground");
            return true;
        }

        //create new player home instance
        PlayerHome ph = new PlayerHome(p.getName(), p.getLocation());

        //add player's home
        ph.setPlayerHome();

        //send home location of the sender
        commandSender.sendMessage("Your home is set on: x " + p.getLocation().getBlockX() + ", y " + p.getLocation().getBlockY() + ", z " + p.getLocation().getBlockZ());


        return true;
    }
}
