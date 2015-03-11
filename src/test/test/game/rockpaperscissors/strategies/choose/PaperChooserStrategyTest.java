package test.game.rockpaperscissors.strategies.choose;

import org.testng.annotations.Test;
import test.game.rockpaperscissors.domain.Entity;

import static org.testng.Assert.assertEquals;

public class PaperChooserStrategyTest {

    private static final int RETRIES_COUNT = 100;

    @Test
    public void shouldStrategyAlwaysReturnPaper() {
        IChooserStrategy strategy = new PaperChooserStrategy();
        for (int i = 0; i < RETRIES_COUNT; i++) {
            assertEquals(strategy.choose(), Entity.PAPER);
        }
    }

}
