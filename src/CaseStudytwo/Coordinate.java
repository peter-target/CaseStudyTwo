package CaseStudytwo;

/**
 *
 * @author Peter
 */
public class Coordinate {
    
    private int x;
    private int y;
    
    /**
     * Represents a single point on the graph
     * @param x The x value of the coordinate
     * @param y The y value of the coordinate
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Getter method 
     * @return The x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Getter method 
     * @return The y coordinate
     */
    public int getY() {
        return y;
    }
}
