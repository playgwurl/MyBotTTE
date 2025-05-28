import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import page.codeberg.terratactician_expandoria.bots.*;
import page.codeberg.terratactician_expandoria.bots.events.ChallengeTickEvent;
import page.codeberg.terratactician_expandoria.world.tiles.*;
import page.codeberg.terratactician_expandoria.world.tiles.Tile.TileType;
import page.codeberg.terratactician_expandoria.world.CubeCoordinate;
import page.codeberg.terratactician_expandoria.world.Hand;
import page.codeberg.terratactician_expandoria.world.Reward;

public class MyBot extends ChallengeBot {
    @Override
    public int getMatrikel() {return 251794;}

    @Override
    public String getStudentName() {return "Sarina Hesani";}

    @Override
    public String getName() {return "slim shady";}

    World world;
    Controller controller;

    @Override
    public void executeTurn(World world, Controller controller) {
       
        this.world = world;
        this.controller = controller;

        if (world.getMap().at(new CubeCoordinate(0,0,0)) == null) {
            controller.placeTile(new CubeCoordinate(0,0,0));
        }

        // collect rewards  
        if(controller.actionPossible() && !world.getRewards().isEmpty()) {
            CubeCoordinate rewardCoord = world.getRewards().get(0).getCoordinate();  // gibt eine Liste zurück mit allen rewards die es gibt
            controller.collectReward(rewardCoord);
        }

        // redraws
        if (controller.actionPossible() && world.getRedrawTime() == 0) {
            controller.redraw();
        } else if (controller.actionPossible() && world.getRound() < 2) { // ziehe ich acuh nach wenn es nicht kostenlos ist
            controller.redraw();
        }

        if (controller.actionPossible() && !world.getHand().isEmpty()) {
            // schreibe methode damit man auf die hand schaut und merkt welche Tiles man hat
            switch (world.getHand().get(0).newInstanceBare().getTileType()) {
                case Wheat -> placeWheat();
                case Forest -> placeForest();
                case Windmill -> placeWindmill();
                case Beehive -> placeBeehive();
                case SmallHouse -> placeSmallHouse();
                case DoubleHouse -> placeDoubleHouse();
                case Moai -> placeMoai();
                case StoneRocks -> placeStone();
                case StoneMountain -> placeMountain();
                case StoneQuarry -> placeQuarry();
                case StoneHill -> placeHill();
                case Marketplace -> placeMarketplace();
                default -> placeTileRandom();
            }
        }
    }

    //=============================================================================================================================//
    
    private int neighborsCount(CubeCoordinate coord, TileType tt) {
        int countN = 0;
        for (CubeCoordinate c : coord.getRing(1)) {
            if (world.getMap().at(c) != null && world.getMap().at(c).getTileType() == tt) {
                countN++;
            }
        } return countN;
    }
    private CubeCoordinate findMaxNeighbors(List<CubeCoordinate> coordList, TileType tt) {
        List<Integer> countList = new ArrayList<>();
        for (CubeCoordinate coord : coordList) {
            countList.add(neighborsCount(coord, tt));
        }
        int max = -1;
        for (Integer count : countList) {
            if (count > max) max = count;
        }

        if (max == -1 ) return null;
        else return coordList.get(countList.indexOf(max));
    }

    private void placeWheat() {
        
        System.out.println("setz weizen");
        List<CubeCoordinate> list = new ArrayList<>();

        CubeCoordinate coord = placeTileRandom();
        list.add(coord);
    }

    private void placeForest() {
        System.out.println("place Forest");
        return;
    }

    private void placeWindmill() {
        System.out.println("place windmill");
        return;
    }

    private void placeBeehive() {
        System.out.println("place beehive");
        return;
    }

    private void placeSmallHouse() {
        System.out.println("place small house");
        return;
    }

    private void placeDoubleHouse() {
        System.out.println("place double house");
        return;
    }

    private void placeMoai() {
        System.out.println("place moai");
        return;
    }

    private void placeStone() { // Stone lvl 1 & 2
        System.out.println("place stone lvl 1 or 2");
        return;
    }

    private void placeMountain() { // Mountain = Stone lvl 3
        System.out.println("place mountain");
        return;
    }

    private void placeQuarry() {
        System.out.println("place quarry");
        return;
    }

    private void placeHill() {
        System.out.println("place hill");
        return;
    }

    private void placeMarketplace() {
        System.out.println("place market place");
        return;
    }


    private CubeCoordinate placeTileRandom() {
        // place tiles random
        if (!world.getHand().isEmpty()) {
            for (CubeCoordinate coord : world.getBuildArea()) {
                if (!controller.actionPossible()) break;
                if (world.getMap().at(coord) != null) continue; // 'continue' mach ein weiter Schleifenlauf
                
                Hand hand = world.getHand();
                controller.placeTile(hand.get(0), coord);
                return coord;
            }
        }
        return null; // if (world.getHand().isEmpty())
    }

    //=============================================================================================================================//

    public class WheatLogic {
        public CubeCoordinate bestPlace() {
            int wheatAmount = 0; // ich will zählen wie viele Wheat Tiles ich schon nebeneinander platziert habe, weil ich nicht
            // mehr als 9 Wheat Tiles nebeneinander haben will...aber wie ? das erste Wheat Tile hat auch keine nachbarn...heißt
            // es muss random platziert werden
            int bestScore = -1;
            CubeCoordinate bestCoord = null;
            // ohne Nachbarn :

            // with Wheat-Nachbarn :
            for (CubeCoordinate coordWheat : world.getBuildArea()) {
                if (world.getMap().at(coordWheat) == null) {

                }
            }
        }
    }
}