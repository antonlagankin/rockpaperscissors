package test.game.rockpaperscissors.strategies.choose;

import org.mockito.Mock;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.game.rockpaperscissors.domain.Entity;
import test.game.rockpaperscissors.utils.IRandomChooser;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.testng.Assert.assertEquals;

public class RandomChooserStrategyTest {

    @Mock
    private IRandomChooser mockedRandomChooser;
    private IChooserStrategy preparedRandomChooserStrategy;

    @BeforeTest
    public void setup() {
        initMocks(this);

        when(mockedRandomChooser.randomize()).thenReturn(Entity.PAPER, Entity.ROCK, Entity.SCISSORS);
        preparedRandomChooserStrategy = new RandomChooserStrategy(mockedRandomChooser);
    }

    @DataProvider(name = "random_chooser_dataset")
    public Object[][] createRandomChooserDataset() {
        return new Object[][] {
                {Entity.PAPER},
                {Entity.ROCK},
                {Entity.SCISSORS}
        };
    }

    @Test(dataProvider = "random_chooser_dataset")
    public void shouldStrategyReturnValueBasedOnRandomChooserResult(Entity expectedValue) {
        assertEquals(preparedRandomChooserStrategy.choose(), expectedValue);
    }

}
