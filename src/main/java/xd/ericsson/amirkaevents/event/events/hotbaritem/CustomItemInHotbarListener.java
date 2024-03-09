package xd.ericsson.amirkaevents.event.events.hotbaritem;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import xd.ericsson.amirkaevents.event.events.playertick.PlayerTickEvent;

import java.util.Arrays;
import java.util.Objects;

public class CustomItemInHotbarListener implements Listener {

    @EventHandler
    public void onPlayerTick(PlayerTickEvent e) {
        Player p = e.getPlayer();
        PlayerInventory inv = p.getInventory();

        Arrays.stream(getHotbarContents(inv))
                .filter(Objects::nonNull)
                .filter(itemStack -> !itemStack.isEmpty())
                .filter(ItemStack::isCustom)
                .forEach(itemStack -> {
                    CustomItemInHotbarTickEvent event = new CustomItemInHotbarTickEvent(p, itemStack);
                    Bukkit.getPluginManager().callEvent(event);
                });
    }

    public ItemStack[] getHotbarContents(PlayerInventory inv) {
        ItemStack[] hotbarContents = new ItemStack[9];
        System.arraycopy(inv.getContents(), 0, hotbarContents, 0, 9);

        return hotbarContents;
    }

}
