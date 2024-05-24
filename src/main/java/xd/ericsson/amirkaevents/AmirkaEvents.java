package xd.ericsson.amirkaevents;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xd.ericsson.amirkaevents.event.Registry;

import java.util.HashMap;
import java.util.UUID;

public final class AmirkaEvents extends JavaPlugin {
    private static AmirkaEvents instance;
    private static final HashMap<UUID, PlayerRunnable> playerRunnables = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;

        Registry.getListeners().forEach(
                (listener -> Bukkit.getPluginManager().registerEvents(listener, this))
        );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static AmirkaEvents getInstance() {
        return instance;
    }

    public static HashMap<UUID, PlayerRunnable> getPlayerRunnables() {
        return playerRunnables;
    }
}
