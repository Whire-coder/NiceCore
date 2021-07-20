package fr.rome.nicecore.listeners;

import fr.rome.nicecore.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerManagement implements Listener {

    private Main main;

    public PlayerManagement(Main main) {
        this.main = main;
    };

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String joinMessage = main.getConfig().getString("joinMessage").replace("&", "§").replace("{player}", player.getDisplayName());

        Bukkit.broadcastMessage(joinMessage);
    };

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        String leaveMessage = main.getConfig().getString("leaveMessage").replace("&", "§").replace("{player}", player.getDisplayName());

        Bukkit.broadcastMessage(leaveMessage);
    };
};
