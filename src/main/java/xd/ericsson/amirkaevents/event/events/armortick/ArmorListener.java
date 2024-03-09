package xd.ericsson.amirkaevents.event.events.armortick;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.PlayerInventory;
import xd.ericsson.amirkaevents.event.events.playertick.PlayerTickEvent;

public class ArmorListener implements Listener {

    @EventHandler
    public void onPlayerTick(PlayerTickEvent e) {
        Player p = e.getPlayer();
        PlayerInventory inv = p.getInventory();

        if (inv.getHelmet() != null) {
            ArmorTickEvent.Helmet event = new ArmorTickEvent.Helmet(inv.getHelmet(), p);
            Bukkit.getPluginManager().callEvent(event);
        }

        if (inv.getChestplate() != null) {
            ArmorTickEvent.Chestplate event = new ArmorTickEvent.Chestplate(inv.getChestplate(), p);
            Bukkit.getPluginManager().callEvent(event);
        }

        if (inv.getLeggings() != null) {
            ArmorTickEvent.Leggings event = new ArmorTickEvent.Leggings(inv.getLeggings(), p);
            Bukkit.getPluginManager().callEvent(event);
        }

        if (inv.getBoots() != null) {
            ArmorTickEvent.Boots event = new ArmorTickEvent.Boots(inv.getBoots(), p);
            Bukkit.getPluginManager().callEvent(event);
        }
    }
}
