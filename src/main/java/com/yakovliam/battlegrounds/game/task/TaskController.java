package com.yakovliam.battlegrounds.game.task;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import com.yakovliam.battlegrounds.game.GameFeatureController;
import com.yakovliam.battlegrounds.game.task.waiting.WaitingBroadcastRepeatingTask;
import com.yakovliam.battlegrounds.state.GameState;
import com.yakovliam.battlegrounds.state.GameStateMovementEvent;

public class TaskController implements GameFeatureController {

    /**
     * Waiting for players broadcast repeating task
     */
    private final WaitingBroadcastRepeatingTask waitingBroadcastRepeatingTask;


    /**
     * Battlegrounds game service provider
     */
    private final BattlegroundsGameServiceProvider battlegroundsGameServiceProvider;

    /**
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     */
    public TaskController(BattlegroundsGameServiceProvider battlegroundsGameServiceProvider) {
        this.battlegroundsGameServiceProvider = battlegroundsGameServiceProvider;
        this.waitingBroadcastRepeatingTask = new WaitingBroadcastRepeatingTask(battlegroundsGameServiceProvider.getPlugin());
    }

    /**
     * Switches the game state and registers the corresponding tasks
     *
     * @param event event
     */
    @Override
    public void switchGameState(GameStateMovementEvent event) {
        if (event.isTo(GameState.WAITING_FOR_PLAYERS)) {
            waitingBroadcastRepeatingTask.start();
        }

        if (event.isFrom(GameState.WAITING_FOR_PLAYERS)) {
            waitingBroadcastRepeatingTask.stop();
        }
    }

}
