package com.yakovliam.battlegrounds.game;

import com.yakovliam.battlegrounds.BattlegroundsPlugin;
import com.yakovliam.battlegrounds.bootstrap.GameBootstrapper;
import com.yakovliam.battlegrounds.state.GameState;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class BattlegroundsGameServiceProvider implements GameServiceProvider {

    /**
     * Battlegrounds plugin context
     */
    private final BattlegroundsPlugin plugin;

    /**
     * The set of currently active players
     */
    private final Set<UUID> activePlayers;

    /**
     * The set of players who were once active, but now disconnected
     */
    private final Set<UUID> disconnectedPlayers;

    /**
     * The current state of the game
     */
    private GameState state;

    /**
     * Battlegrounds game provider
     *
     * @param plugin plugin
     */
    public BattlegroundsGameServiceProvider(BattlegroundsPlugin plugin) {
        this.plugin = plugin;
        this.disconnectedPlayers = new HashSet<>();
        this.activePlayers = new HashSet<>();

        // initialize the game by setting the state to it's default
        state = GameState.getDefault();
    }

    @Override
    public void begin() {
        // create a bootstrapper
        GameBootstrapper gameBootstrapper = new GameBootstrapper(this);
        // initialize / start the bootstrapper
        gameBootstrapper.init();
    }

    @Override
    public void end() {
        this.state = GameState.ENDED;
    }

    /**
     * Returns the current game state
     *
     * @return game state
     */
    public GameState getState() {
        return state;
    }

    public Set<UUID> getActivePlayers() {
        return activePlayers;
    }

    public Set<UUID> getDisconnectedPlayers() {
        return disconnectedPlayers;
    }

    public BattlegroundsPlugin getPlugin() {
        return plugin;
    }
}
