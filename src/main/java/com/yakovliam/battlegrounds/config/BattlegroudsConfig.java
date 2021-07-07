package com.yakovliam.battlegrounds.config;

import com.yakovliam.battlegrounds.BattlegroundsPlugin;
import com.yakovliam.battlegrounds.config.generic.KeyedConfiguration;
import com.yakovliam.battlegrounds.config.generic.adapter.ConfigurationAdapter;

public final class BattlegroudsConfig extends KeyedConfiguration {

    private final BattlegroundsPlugin plugin;

    private final ConfigurationAdapter adapter;

    public BattlegroudsConfig(BattlegroundsPlugin plugin, ConfigurationAdapter adapter) {
        super(adapter, BattlegroundsConfigKeys.getKeys());
        this.plugin = plugin;
        this.adapter = adapter;

        init();
    }

    @Override
    protected void load(boolean initial) {
        super.load(initial);
    }

    @Override
    public void reload() {
        super.reload();
    }

    public BattlegroundsPlugin getPlugin() {
        return this.plugin;
    }

    public ConfigurationAdapter getAdapter() {
        return adapter;
    }
}
