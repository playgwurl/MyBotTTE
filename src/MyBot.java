import page.codeberg.terratactician_expandoria.bots.*;
import page.codeberg.terratactician_expandoria.bots.events.ChallengeTickEvent;
import page.codeberg.terratactician_expandoria.world.tiles.*;
import page.codeberg.terratactician_expandoria.world.tiles.Tile.TileType;
import page.codeberg.terratactician_expandoria.world.CubeCoordinate;
import page.codeberg.terratactician_expandoria.world.Reward;

public class MyBot extends ChallengeBot {
    @Override
    public int getMatrikel() {
        // Bitte gebe deine Matrikelnummer an.
        // Please state your matriculation number.
        return 251794;
    }

    @Override
    public String getStudentName() {
        // Bitte gebe deinen Namen an.
        // Please state your name.
        return "Sarina Hesani";
    }

    @Override
    public String getName() {
        // Hier kannst du deinem Bot einen Namen geben.
        // You can give your Bot a name.
        return "Willy Wonka";
    }

    @Override
    public void executeTurn(World world, Controller controller) {
       // Your code goes here.
       // Use the controller to play one move and confirm it with return.
       // Or just return to skip the move.

       CubeCoordinate wheat1 = null;
       CubeCoordinate wheat2 = null;
       CubeCoordinate wheat3 = null; // wird eingesammelt

        for (Tile tile : world.getMap()) {
            if (tile.takeable()) {
                controller.takeTile(tile.getCoordinate());
                CubeCoordinate targetPos = wheat1.add(wheat2).div(2); // mittl. Pos. berechnen
                controller.placeTile(TileType.Wheat, targetPos);
            }
        }

        for (Reward reward : world.getRewards()) {
            controller.collectReward(reward.getCoordinate());
        }
    }
}