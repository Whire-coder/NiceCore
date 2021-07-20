package fr.rome.nicecore.listeners;

import fr.rome.nicecore.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class InvisivilityCloackEvents implements Listener {

    private final Main main;

    public InvisivilityCloackEvents(Main main) {
        this.main = main;
    };

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();

        if(player.getInventory().getChestplate() != null && player.getInventory().getChestplate().hasItemMeta() && player.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§6Invisibility Cloack")) {

            if(!main.getInvisiblePlayers().contains(player)) main.getInvisiblePlayers().add(player);

            for(Player pl : Bukkit.getOnlinePlayers()){
                pl.hidePlayer(player);
            };
        };
    };

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        main.getInvisiblePlayers().forEach(player::hidePlayer);
    };

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        if(main.getInvisiblePlayers().contains(player)) {
            main.getInvisiblePlayers().remove(player);

            for(Player pl : Bukkit.getOnlinePlayers()){
                pl.showPlayer(player);
            };
        };
    };
};
