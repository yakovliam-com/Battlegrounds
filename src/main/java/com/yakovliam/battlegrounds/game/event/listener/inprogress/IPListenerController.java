package com.yakovliam.battlegrounds.game.event.listener.inprogress;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import com.yakovliam.battlegrounds.game.event.listener.ListenerController;

public class IPListenerController extends ListenerController {

    /**
     * Game listener
     * <p>
     * Constructs and registers
     *
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     */
    public IPListenerController(BattlegroundsGameServiceProvider battlegroundsGameServiceProvider) {
        super(battlegroundsGameServiceProvider,
                new IPBuildListener(battlegroundsGameServiceProvider),
                new IPConnectionListener(battlegroundsGameServiceProvider),
                new IPDropListener(battlegroundsGameServiceProvider));
    }
}
