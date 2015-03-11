package test.game.rockpaperscissors.game;

import test.game.rockpaperscissors.domain.Entity;
import test.game.rockpaperscissors.domain.RoundResult;
import test.game.rockpaperscissors.strategies.result.IResultDefiningStrategy;

public class Round {

    private Round() {
    }

    public static RoundResult playRound(Player firstPlayer, Player secondPlayer, IResultDefiningStrategy iResultDefiningStrategy) {
        return iResultDefiningStrategy.getResult(firstPlayer.bet(), secondPlayer.bet());
    }

}
