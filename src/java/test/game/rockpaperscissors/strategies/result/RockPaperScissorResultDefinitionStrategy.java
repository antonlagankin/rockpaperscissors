package test.game.rockpaperscissors.strategies.result;

import test.game.rockpaperscissors.domain.Entity;
import test.game.rockpaperscissors.domain.RoundResult;

public class RockPaperScissorResultDefinitionStrategy implements IResultDefiningStrategy {

    @Override
    public RoundResult getResult(Entity first, Entity second) {
        if (first.equals(second)) {
            return RoundResult.TIE;
        }
        if (Entity.PAPER.equals(first) && Entity.ROCK.equals(second)) {
            return RoundResult.FIRST_IS_WINNER;
        }
        else if (Entity.ROCK.equals(first) && Entity.SCISSORS.equals(second)) {
            return RoundResult.FIRST_IS_WINNER;
        }
        else if (Entity.SCISSORS.equals(first) && Entity.PAPER.equals(second)) {
            return RoundResult.FIRST_IS_WINNER;
        }
        return RoundResult.SECOND_IS_WINNER;
    }
}
