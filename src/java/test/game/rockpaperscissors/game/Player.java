package test.game.rockpaperscissors.game;

import test.game.rockpaperscissors.domain.Entity;
import test.game.rockpaperscissors.strategies.choose.IChooserStrategy;

public class Player {

    private IChooserStrategy iChooserStrategy;
    private String name;

    public Player(String name, IChooserStrategy iChooserStrategy) {
        this.iChooserStrategy = iChooserStrategy;
        this.name = name;
    }

    public Entity bet() {
        return iChooserStrategy.choose();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (!name.equals(player.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
