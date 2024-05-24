package xd.ericsson.amirkaevents.event.events.playertick;

import org.bukkit.entity.Player;
import xd.ericsson.amirkaevents.event.Event;

public class PlayerTickEvent extends Event {
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
}
