package com.yakovliam.battlegrounds.game;

import com.yakovliam.battlegrounds.BattlegroundsPlugin;
import com.yakovliam.battlegrounds.bootstrap.GameBootstrapper;
import com.yakovliam.battlegrounds.game.event.EventController;
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
     * Event controller
     */
    private final EventController eventController;

    /**
     * Battlegrounds game provider
     *
     * @param plugin plugin
     */
    public BattlegroundsGameServiceProvider(BattlegroundsPlugin plugin) {
        this.plugin = plugin;
        this.disconnectedPlayers = new HashSet<>();
        this.activePlayers = new HashSet<>();

        this.eventController = new EventController(this);

        // initialize the game by setting the state to it's default
        // TODO maybe use the method we made to fire the event controller? not sure
        this.state = GameState.getDefault();
    }

    @Override
    public void begin() {
        // create a bootstrapper
        GameBootstrapper gameBootstrapper = new GameBootstrapper(this);
        // initialize / start the bootstrapper
        gameBootstrapper.init();
        // since bootstrapper is done, set waiting for players
        this.switchGameState(GameState.WAITING_FOR_PLAYERS);
    }

    @Override
    public void startGame() {
        // switch game state
        this.switchGameState(GameState.STARTING);
        // TODO initialize game by doing countdown, then teleporting players, etc
        // TODO new game object, etc
        // TODO do stuff
        this.switchGameState(GameState.IN_PROGRESS);
    }

    @Override
    public void end() {
        this.switchGameState(GameState.ENDED);
    }

    /**
     * Switches the game state
     *
     * @param gameState game state
     */
    public void switchGameState(GameState gameState) {
        this.state = gameState;
        // fire event controller
        this.eventController.switchGameState(state);
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
