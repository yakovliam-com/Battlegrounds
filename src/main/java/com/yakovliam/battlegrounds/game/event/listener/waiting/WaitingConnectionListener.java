package com.yakovliam.battlegrounds.game.event.listener.waiting;

import com.yakovliam.battlegrounds.BattlegroundsPlugin;
import com.yakovliam.battlegrounds.calculator.WaitingJoinMessageCalculator;
import com.yakovliam.battlegrounds.config.BattlegroundsConfigKeys;
import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import com.yakovliam.battlegrounds.game.event.listener.ConnectionListener;
import com.yakovliam.battlegrounds.util.Pair;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class WaitingConnectionListener extends ConnectionListener {

    /**
     * Battlegrounds plugin
     */
    private final BattlegroundsPlugin plugin;

    /**
     * Game listener
     * <p>
     * Constructs and registers
     *
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     */
    public WaitingConnectionListener(BattlegroundsGameServiceProvider battlegroundsGameServiceProvider) {
        super(battlegroundsGameServiceProvider);
        plugin = battlegroundsGameServiceProvider.getPlugin();
    }

    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        battlegroundsGameServiceProvider.getDisconnectedPlayers().remove(event.getPlayer().getUniqueId());
        battlegroundsGameServiceProvider.getActivePlayers().add(event.getPlayer().getUniqueId());

        // teleport
        Location spawnLocation = BattlegroundsConfigKeys.RANDOM_LOBBY_SPAWN_LOCATION.get(plugin.getBattlegroudsConfig().getAdapter());
        event.getPlayer().teleport(spawnLocation);

        event.joinMessage(new WaitingJoinMessageCalculator().calculate(new Pair<>(event.getPlayer(), battlegroundsGameServiceProvider)));

        int requiredPlayers = BattlegroundsConfigKeys.REQUIRED_PLAYERS_TO_START.get(plugin.getBattlegroudsConfig().getAdapter());

        // if we've reached the required players to play, then start!
        if (battlegroundsGameServiceProvider.getActivePlayers().size() >= requiredPlayers) {
            battlegroundsGameServiceProvider.startGame();
        }
    }

    @Override
    public void onPlayerQuit(PlayerQuitEvent event) {
        battlegroundsGameServiceProvider.getDisconnectedPlayers().add(event.getPlayer().getUniqueId());
        battlegroundsGameServiceProvider.getActivePlayers().remove(event.getPlayer().getUniqueId());
    }
}
