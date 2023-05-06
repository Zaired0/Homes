/*
*
* Author: Eliott Deriaz alias Zaired
* Date: 06.05.2023
* Description: Plugin startup file
*
* */
package homes.homes;

import homes.homes.commands.GetHome;
import homes.homes.commands.Home;
import homes.homes.commands.SetHome;
import java.io.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Homes extends JavaPlugin {
    public static String HOMESPATH = "plugins/Homes/playerHomes/";              //players home folder path
    @Override
    public void onEnable() {
        // Plugin startup logic

        File homeFile = new File(HOMESPATH);                    //home folder

        //create data folder
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
            Bukkit.getLogger().info("datafolder successfully created");
        }

        //create players home folder
        if (!homeFile.exists()) {
            homeFile.mkdir();
            Bukkit.getLogger().info("player home folder successfully created");
        }

        //get commands
        getCommand("sethome").setExecutor(new SetHome());
        getCommand("home").setExecutor(new Home());
        getCommand("gethome").setExecutor(new GetHome());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
