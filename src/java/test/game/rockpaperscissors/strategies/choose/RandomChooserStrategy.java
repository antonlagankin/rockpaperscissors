package test.game.rockpaperscissors.strategies.choose;

import test.game.rockpaperscissors.domain.Entity;
import test.game.rockpaperscissors.utils.IRandomChooser;

public class RandomChooserStrategy implements IChooserStrategy {

    private IRandomChooser iRandomChooser;

    public RandomChooserStrategy(IRandomChooser iRandomChooser) {
        this.iRandomChooser = iRandomChooser;
    }

    @Override
    public Entity choose() {
        return iRandomChooser.randomize();
    }
}
