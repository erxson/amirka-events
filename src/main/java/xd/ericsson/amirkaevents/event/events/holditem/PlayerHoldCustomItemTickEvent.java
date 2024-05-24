package xd.ericsson.amirkaevents.event.events.holditem;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MainHand;
import xd.ericsson.amirkaevents.event.Event;

public class PlayerHoldCustomItemTickEvent extends Event {
    private final Player player;
    private final ItemStack itemStack;
    private final MainHand hand;

    public PlayerHoldCustomItemTickEvent(Player player, ItemStack itemStack, MainHand hand) {
        this.player = player;
        this.itemStack = itemStack;
        this.hand = hand;
    }

    public Player getPlayer() {
        return this.player;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public MainHand getHand() {
        return this.hand;
    }
}
