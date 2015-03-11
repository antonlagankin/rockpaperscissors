package test.game.rockpaperscissors.strategies.choose;

import test.game.rockpaperscissors.domain.Entity;

public class PaperChooserStrategy implements IChooserStrategy {

    @Override
    public Entity choose() {
        return Entity.PAPER;
    }

}