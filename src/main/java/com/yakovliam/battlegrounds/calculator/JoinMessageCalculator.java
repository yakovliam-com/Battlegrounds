package com.yakovliam.battlegrounds.calculator;

import com.yakovliam.battlegrounds.config.BattlegroundsConfigKeys;
import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import com.yakovliam.battlegrounds.state.GameState;
import com.yakovliam.battlegrounds.util.Pair;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;

public class JoinMessageCalculator implements Calculator<Pair<Player, BattlegroundsGameServiceProvider>, TextComponent> {

    @Override
    public TextComponent calculate(Pair<Player, BattlegroundsGameServiceProvider> context) {
        Player player = context.getLeft();
        GameState gameState = context.getRight().getState();
        int activePlayerCount = context.getRight().getActivePlayers().size();

        // if game state is waiting for players, return a waiting for players message
        return TextComponent.ofChildren(
                Component.text(player.getName(), TextColor.fromHexString("#9cfff5")),
                Component.space(),
                Component.text("joined", NamedTextColor.WHITE),
                Component.space(),
                Component.text(activePlayerCount, NamedTextColor.GREEN),
                Component.text("/", NamedTextColor.GRAY),
                Component.text(BattlegroundsConfigKeys.REQUIRED_PLAYERS_TO_START, NamedTextColor.GREEN)
        );
    }
}
