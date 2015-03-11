package test.game.rockpaperscissors.game;

import test.game.rockpaperscissors.domain.RoundResult;
import test.game.rockpaperscissors.strategies.result.IResultDefiningStrategy;

public class Game {

    private int roundCount;

    private Player firstPlayer;
    private Player secondPlayer;
    private IResultDefiningStrategy resultDefinitionStrategy;

    public Game(Player firstPlayer, Player secondPlayer, IResultDefiningStrategy resultDefinitionStrategy, int roundCount) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;

        this.resultDefinitionStrategy = resultDefinitionStrategy;

        this.roundCount = roundCount;
    }

    public String playGameAndGetReport() {
        int firstPlayerWinCount = 0;
        int secondPlayerWinCount = 0;
        int tieCount = 0;

        for (int i = 0; i < roundCount; i++) {
            RoundResult roundResult = Round.playRound(firstPlayer, secondPlayer, resultDefinitionStrategy);

            switch (roundResult) {
                case FIRST_IS_WINNER:
                    firstPlayerWinCount++;
                    break;
                case SECOND_IS_WINNER:
                    secondPlayerWinCount++;
                    break;
                case TIE:
                    tieCount++;
                    break;
            }
        }
        return buildReport(firstPlayerWinCount, secondPlayerWinCount, tieCount);
    }

    private String buildReport( int firstPlayerWinCount, int secondPlayerWinCount, int tieCount ) {
        return String.format("Player %s wins %d of %d games\nPlayer %s wins %d of %d games\nTie: %d of %d games",
                firstPlayer.getName(), firstPlayerWinCount, roundCount,
                secondPlayer.getName(), secondPlayerWinCount, roundCount,
                tieCount, roundCount);
    }

}
