package xd.ericsson.amirkaevents.event.events.inventoryitem;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import xd.ericsson.amirkaevents.event.events.holditem.CustomItemInInventoryTickEvent;
import xd.ericsson.amirkaevents.event.events.playertick.PlayerTickEvent;

import java.util.Arrays;
import java.util.Objects;

public class CustomItemInInventoryListener implements Listener {

    @EventHandler
    public void onPlayerTick(PlayerTickEvent e) {
        Player p = e.getPlayer();
        PlayerInventory inv = p.getInventory();

        Arrays.stream(inv.getContents())
                .filter(Objects::nonNull)
                .filter(itemStack -> !itemStack.isEmpty())
                .filter(ItemStack::isCustom)
                .forEach(itemStack -> {
                    CustomItemInInventoryTickEvent event = new CustomItemInInventoryTickEvent(p, itemStack);
                    Bukkit.getPluginManager().callEvent(event);
                });

    }

}
