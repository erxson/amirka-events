package xd.ericsson.amirkaevents.event.events.holditem;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.MainHand;
import org.bukkit.inventory.PlayerInventory;
import xd.ericsson.amirkaevents.event.events.playertick.PlayerTickEvent;

public class PlayerHoldCustomItemListener implements Listener {

    @EventHandler
    public void onPlayerTick(PlayerTickEvent e) {
        Player p = e.getPlayer();
        PlayerInventory inv = p.getInventory();

        if (!inv.getItemInMainHand().isEmpty() && inv.getItemInMainHand().isCustom()) {
            PlayerHoldCustomItemTickEvent event = new PlayerHoldCustomItemTickEvent(p, inv.getItemInMainHand(), MainHand.RIGHT);
            Bukkit.getPluginManager().callEvent(event);
        }

        if (!inv.getItemInOffHand().isEmpty() && inv.getItemInOffHand().isCustom()) {
            PlayerHoldCustomItemTickEvent event = new PlayerHoldCustomItemTickEvent(p, inv.getItemInOffHand(), MainHand.LEFT);
            Bukkit.getPluginManager().callEvent(event);
        }
    }

}
