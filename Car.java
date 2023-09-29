public class Car extends Vehicle{
    
    private int X;
    public int getX(){return X;}
    private int Y;
    public int getY(){return Y;}
    private String dir;

    public Car(int x, int y, String heading)
    {
        switch(heading)
        {
            case "N":
                display = "^";
                break;
            case "W":
                display = "<";
                break;
            case "E":
                display = ">";
                break;
            case "S":
                display = "v";
                break;
        }
        this.X = x;
        this.Y = y;
        this.dir = heading;
    }

    public void move()
    {
        switch(dir)
        {
            case "N":
                Y--;
                break;
            case "W":
                X--;
                break;
            case "E":
                X++;
                break;
            case "S":
                Y++;
                break;
        }
    }

}
