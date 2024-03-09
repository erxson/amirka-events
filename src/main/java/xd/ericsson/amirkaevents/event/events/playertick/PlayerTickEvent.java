package xd.ericsson.amirkaevents.event.events.playertick;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerTickEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final boolean online;

    public PlayerTickEvent(Player player, boolean online) {
        this.player = player;
        this.online = online;
    }

    public Player getPlayer() {
        return this.player;
    }

    public boolean isOnline() {
        return this.online;
    }


    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
