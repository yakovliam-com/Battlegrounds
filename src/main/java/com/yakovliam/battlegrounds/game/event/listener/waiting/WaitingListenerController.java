package com.yakovliam.battlegrounds.game.event.listener.waiting;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import com.yakovliam.battlegrounds.game.event.listener.ListenerController;

public class WaitingListenerController extends ListenerController {

    /**
     * Game listener
     * <p>
     * Constructs and registers
     *
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     */
    public WaitingListenerController(BattlegroundsGameServiceProvider battlegroundsGameServiceProvider) {
        super(battlegroundsGameServiceProvider,
                new WaitingBuildListener(battlegroundsGameServiceProvider),
                new WaitingConnectionListener(battlegroundsGameServiceProvider),
                new WaitingDropListener(battlegroundsGameServiceProvider));
    }
}
