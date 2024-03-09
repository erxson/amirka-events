package xd.ericsson.amirkaevents.event.events.playertick;

import com.destroystokyo.paper.event.player.PlayerConnectionCloseEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import xd.ericsson.amirkaevents.AmirkaEvents;
import xd.ericsson.amirkaevents.PlayerRunnable;

import java.util.HashMap;
import java.util.UUID;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();

        HashMap<UUID, PlayerRunnable> runnables = AmirkaEvents.getPlayerRunnables();
        if (runnables.containsKey(uuid)) {
            PlayerRunnable runnable = runnables.get(uuid);

            runnable.setPlayer(player); // Обновление ссылки на Player
            runnable.setOnline(true);

            return;
        }

        PlayerRunnable runnable = new PlayerRunnable(player, true);
        runnables.put(uuid, runnable);

        runnable.runTaskTimer(AmirkaEvents.getInstance(), 20, 0);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();

        HashMap<UUID, PlayerRunnable> runnables = AmirkaEvents.getPlayerRunnables();
        if (runnables.containsKey(uuid)) {
            PlayerRunnable runnable = runnables.get(uuid);
            runnable.setOnline(false);
        }
    }

    @EventHandler
    public void onDisconnect(PlayerConnectionCloseEvent e) {
        UUID uuid = e.getPlayerUniqueId();

        HashMap<UUID, PlayerRunnable> runnables = AmirkaEvents.getPlayerRunnables();
        if (runnables.containsKey(uuid)) {
            PlayerRunnable runnable = runnables.get(uuid);
            runnable.setOnline(false);
        }
    }
}
