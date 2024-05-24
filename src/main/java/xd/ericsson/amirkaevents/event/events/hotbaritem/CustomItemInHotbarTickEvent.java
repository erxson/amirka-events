package xd.ericsson.amirkaevents.event.events.hotbaritem;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xd.ericsson.amirkaevents.event.Event;

public class CustomItemInHotbarTickEvent extends Event {
    private final Player player;
    private final ItemStack itemStack;

    public CustomItemInHotbarTickEvent(Player player, ItemStack itemStack) {
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
