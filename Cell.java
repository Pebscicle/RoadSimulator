public class Cell {
    

    /**
     * For information:
     * - : East-West facing road
     * | : North-South facing road
     * + : Intersection
     * O : Vehicle
     * * : Grass
     */
    private Occupant cellOccupant;
    public Occupant getOccupant(){return cellOccupant;}


    public Cell(Occupant occupant)
    {
        this.cellOccupant = occupant;
    }

}
