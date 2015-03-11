package test.game.rockpaperscissors;

import test.game.rockpaperscissors.game.Game;
import test.game.rockpaperscissors.game.Player;
import test.game.rockpaperscissors.strategies.choose.PaperChooserStrategy;
import test.game.rockpaperscissors.strategies.choose.RandomChooserStrategy;
import test.game.rockpaperscissors.strategies.result.RockPaperScissorResultDefinitionStrategy;
import test.game.rockpaperscissors.utils.StandardRandomChooser;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(
                new Player("A", new PaperChooserStrategy()),
                new Player("B", new RandomChooserStrategy(new StandardRandomChooser())),
                new RockPaperScissorResultDefinitionStrategy(),
                100
        );

        System.out.println(game.playGameAndGetReport());
    }

}
