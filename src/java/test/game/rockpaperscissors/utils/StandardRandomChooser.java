package test.game.rockpaperscissors.utils;

import test.game.rockpaperscissors.domain.Entity;

import java.util.Random;

public class StandardRandomChooser implements IRandomChooser {

    private Random random = new Random();

    @Override
    public Entity randomize() {
        Entity[] entities = Entity.values();
        return entities[random.nextInt(entities.length)];
    }
}
