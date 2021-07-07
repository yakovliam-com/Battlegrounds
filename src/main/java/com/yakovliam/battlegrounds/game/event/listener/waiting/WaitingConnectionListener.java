package com.yakovliam.battlegrounds.game.event.listener.waiting;

import com.yakovliam.battlegrounds.calculator.JoinMessageCalculator;
import com.yakovliam.battlegrounds.config.BattlegroundsConfigKeys;
import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import com.yakovliam.battlegrounds.game.event.listener.ConnectionListener;
import com.yakovliam.battlegrounds.util.Pair;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class WaitingConnectionListener extends ConnectionListener {

    /**
     * Game listener
     * <p>
     * Constructs and registers
     *
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     */
    public WaitingConnectionListener(BattlegroundsGameServiceProvider battlegroundsGameServiceProvider) {
        super(battlegroundsGameServiceProvider);
    }

    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        battlegroundsGameServiceProvider.getDisconnectedPlayers().remove(event.getPlayer().getUniqueId());
        battlegroundsGameServiceProvider.getActivePlayers().add(event.getPlayer().getUniqueId());

        event.joinMessage(new JoinMessageCalculator().calculate(new Pair<>(event.getPlayer(), battlegroundsGameServiceProvider)));

        // if we've reached the required players to play, then start!
        if (battlegroundsGameServiceProvider.getActivePlayers().size() >= BattlegroundsConfigKeys.REQUIRED_PLAYERS_TO_START) {
            battlegroundsGameServiceProvider.startGame();
        }
    }

    @Override
    public void onPlayerQuit(PlayerQuitEvent event) {
        battlegroundsGameServiceProvider.getDisconnectedPlayers().add(event.getPlayer().getUniqueId());
        battlegroundsGameServiceProvider.getActivePlayers().remove(event.getPlayer().getUniqueId());
    }
}
