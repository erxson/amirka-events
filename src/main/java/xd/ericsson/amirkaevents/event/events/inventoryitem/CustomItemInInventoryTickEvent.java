package xd.ericsson.amirkaevents.event.events.inventoryitem;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xd.ericsson.amirkaevents.event.Event;

public class CustomItemInInventoryTickEvent extends Event {
    private final Player player;
    private final ItemStack itemStack;

    public CustomItemInInventoryTickEvent(Player player, ItemStack itemStack) {
        this.player = player;
        this.itemStack = itemStack;
    }

    public Player getPlayer() {
        return this.player;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }
}
