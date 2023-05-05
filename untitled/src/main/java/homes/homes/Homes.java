package homes.homes;

import homes.homes.commands.GetHome;
import homes.homes.commands.Home;
import homes.homes.commands.SetHome;
import homes.homes.handlers.torchHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Homes extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Hello World");

        getCommand("sethome").setExecutor(new SetHome());
        getCommand("home").setExecutor(new Home());
        getCommand("gethome").setExecutor(new GetHome());
        //getCommand("home").setExecutor(new Home());

        //new torchHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Goodbye World");
    }
}
