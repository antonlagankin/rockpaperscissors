package test.game.rockpaperscissors.utils;

import org.mockito.Mock;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.game.rockpaperscissors.domain.Entity;

import java.util.Random;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;

public class StandardRandomChooserTest {

    @Mock
    private Random random;
    private IRandomChooser preparedRandomChooser;

    @BeforeTest
    public void setup() throws Exception {
        initMocks(this);

        when(random.nextInt(Entity.values().length)).thenReturn(0, 1, 2);

        preparedRandomChooser = new StandardRandomChooser();
        Whitebox.setInternalState(preparedRandomChooser, Random.class, random);
    }

    @DataProvider(name = "randomizer_dataset")
    public Object[][] createRandomizerDataSet() {
        return new Object[][] {
                {Entity.ROCK},
                {Entity.PAPER},
                {Entity.SCISSORS}
        };
    }

    @Test(dataProvider = "randomizer_dataset")
    public void shouldReturnItemsBasedOnRandomChooserValues(Entity entity) throws Exception {
        assertEquals(preparedRandomChooser.randomize(), entity);
    }
}
