import java.lang.Thread;
import java.util.Random;


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
    private boolean running = true;
    private Cell[][] trafficBoard;

    private int X;
    private int Y;

    private Car vehicle;

    private int xRoad;
    private int yRoad;

    
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
        Random rd = new Random();
        xRoad = rd.nextInt(Y);
        yRoad = rd.nextInt(X);
        this.vehicle = new Car(0, xRoad, "E");
    }

    public void initTrafficMap()
    {

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
        trafficBoard[vehicle.getY()][vehicle.getX()] = new Cell(vehicle); 
        printMap();
    }

    public void startTraffic()
    {
        while(running)
        {
            //DO ALL BACKGROUND LOGIC
            moveVehicles();

            //PRINT BOARD!
            printMap();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //PRIVATE METHODS

    private void moveVehicles()
    {
        int prevX = vehicle.getX();
        int prevY = vehicle.getY();
        Occupant carOccupant = trafficBoard[vehicle.getY()][vehicle.getX()].getOccupant();
        vehicle.move();
        Occupant roadOccupant = trafficBoard[vehicle.getY()][vehicle.getX()].getOccupant();

        trafficBoard[vehicle.getY()][vehicle.getX()].setOccupant(carOccupant);
        trafficBoard[prevY][prevX].setOccupant(roadOccupant);
    }

    private void printMap()
    {
        //CLEAR PREV FRAME
        for(int i=0; i < 40; i++)
        {
            System.out.println();
        }

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
