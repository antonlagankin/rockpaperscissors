package test.game.rockpaperscissors.strategies.result;

import test.game.rockpaperscissors.domain.Entity;
import test.game.rockpaperscissors.domain.RoundResult;

public interface IResultDefiningStrategy {

    RoundResult getResult(Entity first, Entity second);

}
