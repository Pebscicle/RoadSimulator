public class RoadTile extends Occupant{

    public RoadTile(String dir) {
        switch(dir)
        {
            case "NS":
                display = "|";
                break;
            case "WE":
                display = "-";
                break;
            case "+":
                display = "+";
        }
        isOccupiable = true;
    }
}
