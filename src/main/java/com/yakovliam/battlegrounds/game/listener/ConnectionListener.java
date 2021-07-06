package com.yakovliam.battlegrounds.game.listener;

import com.yakovliam.battlegrounds.calculator.JoinMessageCalculator;
import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import com.yakovliam.battlegrounds.util.Pair;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener extends GameListener {

    /**
     * Game listener
     * <p>
     * Constructs and registers
     *
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     */
    public ConnectionListener(BattlegroundsGameServiceProvider battlegroundsGameServiceProvider) {
        super(battlegroundsGameServiceProvider);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        battlegroundsGameServiceProvider.getDisconnectedPlayers().remove(event.getPlayer().getUniqueId());
        battlegroundsGameServiceProvider.getActivePlayers().add(event.getPlayer().getUniqueId());

        event.joinMessage(new JoinMessageCalculator().calculate(new Pair<>(event.getPlayer(), battlegroundsGameServiceProvider)));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        battlegroundsGameServiceProvider.getDisconnectedPlayers().add(event.getPlayer().getUniqueId());
        battlegroundsGameServiceProvider.getActivePlayers().remove(event.getPlayer().getUniqueId());
    }
}
