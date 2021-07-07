package com.yakovliam.battlegrounds.game.task.waiting;

import com.yakovliam.battlegrounds.BattlegroundsPlugin;
import com.yakovliam.battlegrounds.config.BattlegroundsConfigKeys;
import com.yakovliam.battlegrounds.game.task.RepeatingTask;
import com.yakovliam.battlegrounds.message.Message;

public class WaitingBroadcastRepeatingTask extends RepeatingTask {

    /**
     * Default period
     *
     * 400 ticks = (20 seconds * 20 ticks/second)
     */
    private static final long DEFAULT_PERIOD = 400L;

    /**
     * Repeating task
     *
     * @param plugin plugin
     */
    public WaitingBroadcastRepeatingTask(BattlegroundsPlugin plugin) {
        super(plugin, DEFAULT_PERIOD, true);
    }

    @Override
    public void run() {
        // get random broadcast message
        Message message = BattlegroundsConfigKeys.RANDOM_WAITING_BROADCAST_MESSAGE.get(plugin.getBattlegroudsConfig().getAdapter());
        // broadcast
        message.broadcast();
    }
}
