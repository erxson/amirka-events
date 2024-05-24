package xd.ericsson.amirkaevents.event.events.armortick;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xd.ericsson.amirkaevents.event.Event;

public class ArmorTickEvent extends Event {
    private final ItemStack itemStack;
    private final Player player;

    public ArmorTickEvent(ItemStack itemStack, Player player) {
        this.itemStack = itemStack;
        this.player = player;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public Player getPlayer() {
        return this.player;
    }

    public static class Helmet extends ArmorTickEvent {
        public Helmet(ItemStack itemStack, Player player) {
            super(itemStack, player);
        }
    }

    public static class Chestplate extends ArmorTickEvent {
        public Chestplate(ItemStack itemStack, Player player) {
            super(itemStack, player);
        }
    }

    public static class Leggings extends ArmorTickEvent {
        public Leggings(ItemStack itemStack, Player player) {
            super(itemStack, player);
        }
    }

    public static class Boots extends ArmorTickEvent {
        public Boots(ItemStack itemStack, Player player) {
            super(itemStack, player);
        }
    }
}
