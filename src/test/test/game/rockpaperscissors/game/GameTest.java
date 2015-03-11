package test.game.rockpaperscissors.game;

import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockObjectFactory;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.IObjectFactory;
import org.testng.annotations.*;
import test.game.rockpaperscissors.domain.RoundResult;
import test.game.rockpaperscissors.strategies.result.IResultDefiningStrategy;

import java.util.Random;

import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.same;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.testng.Assert.assertEquals;

@PrepareForTest({Round.class, Random.class})
public class GameTest extends PowerMockTestCase {

    private static final String EXPECTED_REPORT = "Player A wins 3 of 7 games\nPlayer B wins 2 of 7 games\nTie: 2 of 7 games";

    @Mock
    private Player firstPlayer;

    @Mock
    private Player secondPlayer;

    @Mock
    private IResultDefiningStrategy resultDefiningStrategy;

    private Game game;

    @ObjectFactory
    public IObjectFactory getObjectFactory() {
        return new PowerMockObjectFactory();
    }

    @BeforeClass
    public void setup() {
        initMocks(this);
        mockStatic(Round.class);

        setupPlayers();
        setupRound();

        game = new Game(firstPlayer, secondPlayer, resultDefiningStrategy, 7);
    }

    @Test
    public void shouldTheGamePlayAndReturnExpectedReport() {
        String report = game.playGameAndGetReport();

        assertEquals(report, EXPECTED_REPORT);
    }

    private void setupPlayers() {
        when(firstPlayer.getName()).thenReturn("A");
        when(secondPlayer.getName()).thenReturn("B");
    }

    private void setupRound() {
        when(Round.playRound(eq(firstPlayer), eq(secondPlayer), same(resultDefiningStrategy))).thenReturn(
                RoundResult.FIRST_IS_WINNER,
                RoundResult.SECOND_IS_WINNER,
                RoundResult.TIE,
                RoundResult.FIRST_IS_WINNER,
                RoundResult.FIRST_IS_WINNER,
                RoundResult.TIE,
                RoundResult.SECOND_IS_WINNER);
    }
}
