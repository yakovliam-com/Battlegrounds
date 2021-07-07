package com.yakovliam.battlegrounds.game.event;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import com.yakovliam.battlegrounds.game.event.listener.ListenerController;
import com.yakovliam.battlegrounds.game.event.listener.inprogress.IPListenerController;
import com.yakovliam.battlegrounds.game.event.listener.waiting.WaitingListenerController;
import com.yakovliam.battlegrounds.state.GameState;
import org.bukkit.event.HandlerList;

public class EventController {

    /**
     * The current controller
     * <p>
     * This is unregistered and changed every time the game state is changed
     */
    private ListenerController controller;

    /**
     * Battlegrounds game service provider
     */
    private final BattlegroundsGameServiceProvider battlegroundsGameServiceProvider;

    /**
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     */
    public EventController(BattlegroundsGameServiceProvider battlegroundsGameServiceProvider) {
        this.battlegroundsGameServiceProvider = battlegroundsGameServiceProvider;
    }

    /**
     * Switches the game state and registers the corresponding listener controller
     *
     * @param current current game state (new)
     */
    public void switchGameState(GameState current) {
        if (controller != null) {
            // un-register controller
            HandlerList.unregisterAll(controller);
        }

        // re-register
        ListenerController listenerController = determineController(current);

        // if null, don't re-register
        if (listenerController == null) {
            return;
        }

        battlegroundsGameServiceProvider.getPlugin().getServer().getPluginManager().registerEvents(listenerController, battlegroundsGameServiceProvider.getPlugin());
    }

    private ListenerController determineController(GameState gameState) {
        return switch (gameState) {
            case WAITING_FOR_PLAYERS -> new WaitingListenerController(battlegroundsGameServiceProvider);
            case IN_PROGRESS -> new IPListenerController(battlegroundsGameServiceProvider);
            default -> null;
        };
    }


}
