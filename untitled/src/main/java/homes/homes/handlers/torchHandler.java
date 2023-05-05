package homes.homes.handlers;

import homes.homes.Homes;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class torchHandler implements Listener {
    public torchHandler(Homes plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onTorchPlace(BlockPlaceEvent event){
        Block b = event.getBlock();
        Player p = event.getPlayer();

        if(b.getType() != Material.TORCH){
            return;
        }

        // Permission node
        // homes.homes.torch.diamond

        if(!p.hasPermission("homes.homes.torch.diamond")){
            return;
        }

        b.setType(Material.DIAMOND_BLOCK);
    }
}
