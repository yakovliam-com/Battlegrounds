package com.yakovliam.battlegrounds;

import com.yakovliam.battlegrounds.config.BattlegroudsConfig;
import com.yakovliam.battlegrounds.config.adapter.BukkitConfigAdapter;
import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class BattlegroundsPlugin extends JavaPlugin {

    /**
     * Battlegrounds config
     */
    private BattlegroudsConfig battlegroudsConfig;

    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {
        // initialize config
        this.battlegroudsConfig = new BattlegroudsConfig(this, provideConfigAdapter("config.yml"));

        // initialize the game provider
        BattlegroundsGameServiceProvider battlegroundsGameProvider = new BattlegroundsGameServiceProvider(this);
        battlegroundsGameProvider.begin();
    }

    @Override
    public void onDisable() {
    }

    /**
     * Provides a configuration adapter
     *
     * @param fileName file name
     * @return config adapter
     */
    private BukkitConfigAdapter provideConfigAdapter(String fileName) {
        return new BukkitConfigAdapter(this, resolveConfig(fileName).toFile());
    }

    /**
     * Resolves a configuration
     *
     * @param fileName file name
     * @return configuration path
     */
    public Path resolveConfig(String fileName) {
        Path configFile = getDataFolder().toPath().resolve(fileName);

        // if the config doesn't exist, create it based on the template in the resources dir
        if (!Files.exists(configFile)) {
            try {
                Files.createDirectories(configFile.getParent());
            } catch (IOException e) {
                // ignore
            }

            try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
                Files.copy(is, configFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return configFile;
    }

    /**
     * Returns the configuration
     *
     * @return configuration
     */
    public BattlegroudsConfig getBattlegroudsConfig() {
        return battlegroudsConfig;
    }
}
