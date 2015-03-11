package test.game.rockpaperscissors.game;

import org.mockito.Mock;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.game.rockpaperscissors.domain.Entity;
import test.game.rockpaperscissors.domain.RoundResult;
import test.game.rockpaperscissors.strategies.result.IResultDefiningStrategy;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;

public class RoundTest {

    @Mock
    private IResultDefiningStrategy mockedResultDefinitionStrategy;

    @Mock
    private Player firstPlayer;
    @Mock
    private Player secondPlayer;

    @BeforeTest
    public void setup() {
        initMocks(this);

        prepareStrategy();
        preparePlayers();
    }

    @DataProvider(name = "round_dataset")
    public Object[][] createRoundDataSet() {
        return new Object[][] {
                {RoundResult.FIRST_IS_WINNER},
                {RoundResult.FIRST_IS_WINNER},
                {RoundResult.FIRST_IS_WINNER},
                {RoundResult.SECOND_IS_WINNER},
                {RoundResult.SECOND_IS_WINNER},
                {RoundResult.SECOND_IS_WINNER},
                {RoundResult.TIE},
                {RoundResult.TIE},
                {RoundResult.TIE}
        };
    }

    @Test(dataProvider = "round_dataset")
    public void shouldRoundReturnResultBasedOnStrategyResult(RoundResult expectedResult){
        assertEquals(Round.playRound(firstPlayer, secondPlayer, mockedResultDefinitionStrategy), expectedResult);
    }

    private void prepareStrategy() {
        when(mockedResultDefinitionStrategy.getResult(Entity.PAPER, Entity.ROCK)).thenReturn(RoundResult.FIRST_IS_WINNER);
        when(mockedResultDefinitionStrategy.getResult(Entity.SCISSORS, Entity.PAPER)).thenReturn(RoundResult.FIRST_IS_WINNER);
        when(mockedResultDefinitionStrategy.getResult(Entity.ROCK, Entity.SCISSORS)).thenReturn(RoundResult.FIRST_IS_WINNER);
        when(mockedResultDefinitionStrategy.getResult(Entity.PAPER, Entity.SCISSORS)).thenReturn(RoundResult.SECOND_IS_WINNER);
        when(mockedResultDefinitionStrategy.getResult(Entity.SCISSORS, Entity.ROCK)).thenReturn(RoundResult.SECOND_IS_WINNER);
        when(mockedResultDefinitionStrategy.getResult(Entity.ROCK, Entity.PAPER)).thenReturn(RoundResult.SECOND_IS_WINNER);
        when(mockedResultDefinitionStrategy.getResult(Entity.PAPER, Entity.PAPER)).thenReturn(RoundResult.TIE);
        when(mockedResultDefinitionStrategy.getResult(Entity.ROCK, Entity.ROCK)).thenReturn(RoundResult.TIE);
        when(mockedResultDefinitionStrategy.getResult(Entity.SCISSORS, Entity.SCISSORS)).thenReturn(RoundResult.TIE);
    }

    private void preparePlayers() {
        when(firstPlayer.bet()).thenReturn(Entity.PAPER, Entity.SCISSORS, Entity.ROCK, Entity.PAPER, Entity.SCISSORS, Entity.ROCK, Entity.PAPER, Entity.ROCK, Entity.SCISSORS);
        when(secondPlayer.bet()).thenReturn(Entity.ROCK, Entity.PAPER, Entity.SCISSORS, Entity.SCISSORS, Entity.ROCK, Entity.PAPER, Entity.PAPER, Entity.ROCK, Entity.SCISSORS);
    }
}
