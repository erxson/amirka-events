package xd.ericsson.amirkaevents.event;

import org.bukkit.event.Listener;
import xd.ericsson.amirkaevents.event.events.hotbaritem.CustomItemInHotbarListener;
import xd.ericsson.amirkaevents.event.events.playertick.PlayerListener;
import xd.ericsson.amirkaevents.event.events.armortick.ArmorListener;
import xd.ericsson.amirkaevents.event.events.holditem.PlayerHoldCustomItemListener;
import xd.ericsson.amirkaevents.event.events.inventoryitem.CustomItemInInventoryListener;

import java.util.Arrays;
import java.util.List;

public class Registry {
    private static final List<Listener> listenerList = Arrays.asList(
            new ArmorListener(),
            new PlayerHoldCustomItemListener(),
            new CustomItemInHotbarListener(),
            new CustomItemInInventoryListener(),
            new PlayerListener()
    );

    public static List<Listener> getListeners() {
        return listenerList;
    }
}
