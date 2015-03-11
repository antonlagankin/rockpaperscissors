package test.game.rockpaperscissors.strategies.result;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.game.rockpaperscissors.domain.Entity;
import test.game.rockpaperscissors.domain.RoundResult;

import static org.testng.Assert.assertEquals;

public class RockPaperScissorResultDefinitionStrategyTest {

    private IResultDefiningStrategy resultDefinitionStrategy;

    @BeforeMethod
    public void setupRockPaperScissorsResultDefinitionStrategy() {
        resultDefinitionStrategy = new RockPaperScissorResultDefinitionStrategy();
    }

    @DataProvider(name = "lose_variation")
    public Object[][] createLoseVariations() {
        return new Object[][] {
                {Entity.PAPER, Entity.SCISSORS},
                {Entity.ROCK, Entity.PAPER},
                {Entity.SCISSORS, Entity.ROCK}
        };
    }

    @DataProvider(name = "win_variation")
    public Object[][] createWinVariations() {
        return new Object[][] {
                {Entity.PAPER, Entity.ROCK},
                {Entity.ROCK, Entity.SCISSORS},
                {Entity.SCISSORS, Entity.PAPER}
        };
    }

    @DataProvider(name = "same_domain_objects")
    public Object[][] createSameObjects() {
        return new Object[][] {
                {Entity.PAPER, Entity.PAPER},
                {Entity.ROCK, Entity.ROCK},
                {Entity.SCISSORS, Entity.SCISSORS}
        };
    }

    @Test(dataProvider = "win_variation")
    public void shouldReturnFirstIsWinner(Entity first, Entity second) {
        assertEquals(resultDefinitionStrategy.getResult(first, second), RoundResult.FIRST_IS_WINNER);
    }

    @Test(dataProvider = "lose_variation")
    public void shouldReturnSecondIsWinner(Entity first, Entity second) {
        assertEquals(resultDefinitionStrategy.getResult(first, second), RoundResult.SECOND_IS_WINNER);
    }

    @Test(dataProvider = "same_domain_objects")
    public void shouldReturnTie(Entity first, Entity second) {
        assertEquals(resultDefinitionStrategy.getResult(first, second), RoundResult.TIE);
    }

}
