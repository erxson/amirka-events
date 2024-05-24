package xd.ericsson.amirkaevents.event;

import org.bukkit.event.HandlerList;

public class Event extends org.bukkit.event.Event {
    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
