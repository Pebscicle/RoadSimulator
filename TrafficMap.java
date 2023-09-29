import java.lang.Thread;
import java.util.Random;

import javax.management.relation.RoleNotFoundException;

public class TrafficMap {
    
    /**
     * Simple e.g:
     * x = 10, y = 5
     * 
     * * * * * | * * * * *
     * * * * * | * * * * *
     * - O - - + - - - - -
     * * * * * | * * * * *
     * * * * * | * * * * *
     * 
     */
    private Cell[][] trafficBoard;

    private int X;
    private int Y;

    /**
     * Setup of the board.
     * @param x - Length of map
     * @param y - Height of map
     */
    public TrafficMap(int x, int y)
    {
        this.X = x;
        this.Y = y;
        trafficBoard = new Cell[y][x];
    }

    public void initTrafficMap()
    {
        Random rd = new Random();
        int xRoad = rd.nextInt(Y);
        int yRoad = rd.nextInt(X);

        System.out.println("x road: " + xRoad);
        System.out.println("y road: " + yRoad);


        for(int i = 0; i < trafficBoard.length; i ++)
        {
            for(int j = 0; j < trafficBoard[0].length; j++)
            {
                if(i == xRoad)
                {
                    trafficBoard[i][j] = new Cell(new RoadTile("WE"));
                }
                if(j == yRoad)
                {
                    trafficBoard[i][j] = new Cell(new RoadTile("NS"));
                }
                if(i == xRoad && j == yRoad)
                {
                    trafficBoard[i][j] = new Cell(new RoadTile("+"));
                }
                if(i != xRoad && j != yRoad)
                {
                    trafficBoard[i][j] = new Cell(new Grass());
                }
            }
        }

        printMap();
    }

    private void printMap()
    {
        for(int i = 0; i < trafficBoard.length; i ++)
        {
            for(int j = 0; j < trafficBoard[0].length; j++)
            {
                System.out.print(trafficBoard[i][j].getOccupant().getOccupantDisplay() + " ");
            }
            System.out.println();
        }
    }

}
