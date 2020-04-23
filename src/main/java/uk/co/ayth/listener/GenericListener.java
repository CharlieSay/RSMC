package uk.co.ayth.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static uk.co.ayth.avengers.AvengersMap.*;
import static uk.co.ayth.utility.BossbarUtils.resetBossBar;

public class GenericListener implements Listener {
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent playerQuitEvent){
        if (playerIsAnAvenger(playerQuitEvent.getPlayer())){
            removeAvenger(getAvengerByPlayer(playerQuitEvent.getPlayer()));
            resetBossBar();
        }
    }
}