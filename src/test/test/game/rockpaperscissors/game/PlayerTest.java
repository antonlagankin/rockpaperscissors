package test.game.rockpaperscissors.game;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

import org.mockito.Mock;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.game.rockpaperscissors.domain.Entity;
import test.game.rockpaperscissors.strategies.choose.IChooserStrategy;

public class PlayerTest {

    private static final String FIRST_PLAYER_NAME = "A";
    private static final String SECOND_PLAYER_NAME = "B";

    @Mock
    private IChooserStrategy chooserStrategy;

    @DataProvider(name = "equalsDataSet")
    public Object[][] createEqualsDataSet() {
        return new Object[][] {
                {
                    makeStubPlayer(FIRST_PLAYER_NAME), makeStubPlayer(FIRST_PLAYER_NAME), true
                },
                {
                    makeStubPlayer(FIRST_PLAYER_NAME), makeStubPlayer(SECOND_PLAYER_NAME), false
                }
        };
    }

    @BeforeTest
    public void setup() {
        initMocks(this);
    }

    @Test
    public void shouldSetAndGetTheSameName() {
        Player player = makeStubPlayer(FIRST_PLAYER_NAME);

        assertEquals(player.getName(), FIRST_PLAYER_NAME);
    }

    @Test
    public void shouldCallStrategy() {
        when(chooserStrategy.choose()).thenReturn(Entity.PAPER);

        Player player = new Player(FIRST_PLAYER_NAME, chooserStrategy);
        assertEquals(player.bet(), Entity.PAPER);

        verify(chooserStrategy).choose();
    }

    @Test(dataProvider = "equalsDataSet")
    public void shouldTwoPlayersWithTheSameNameEqual(Player firstPlayer, Player secondPlayer, boolean expResult) {
        assertEquals(firstPlayer.equals(secondPlayer), expResult);
    }

    private static Player makeStubPlayer(String name) {
        return new Player(name, new IChooserStrategy() {
            @Override
            public Entity choose() {
                return null;
            }
        });
    }

}
