package xd.ericsson.amirkaevents;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import xd.ericsson.amirkaevents.event.events.playertick.PlayerTickEvent;

import java.util.HashMap;
import java.util.List;

public class PlayerRunnable extends BukkitRunnable {

    private Player player;
    private boolean online;
    private final HashMap<Integer, BukkitRunnable> tasks = new HashMap<>();

    public PlayerRunnable(Player player, boolean online) {
        this.player = player;
        this.online = online;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean getOnline() {
        return this.online;
    }

    public BukkitRunnable getTask(int taskId) {
        return tasks.get(taskId);
    }

    public int addTask(BukkitRunnable task) {
        int taskId = task.getTaskId();
        tasks.put(taskId, task);

        return taskId;
    }

    public boolean removeTask(int taskId) {
        return tasks.remove(taskId) != null;
    }

    @Override
    public void run() {
        Bukkit.getServer().getPluginManager().callEvent(new PlayerTickEvent(this.player, this.online));

        tasks.forEach((taskId, task) -> task.run());
    }
}
