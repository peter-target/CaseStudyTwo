package CaseStudytwo;

import java.util.*;

/**
 *
 * @author Peter
 */
public class BarrenLandAnalyzer {
    
    private final int UNCOUNTED_FERTILE_LAND = 0;
    private final int BARREN_LAND = 1;
    private final int COUNTED_FERTILE_LAND = 2;
    
    private int[][] land;
    private int farmWidth;
    private int farmHeight;
    
    /**
     * @param width The width of the farm plot (in meters)
     * @param height The height of the farm plot (in meters)
     * @param barrenCoordinates The set of points defining the corners of the barren square plots
     */
    public BarrenLandAnalyzer(int width, int height, String[] barrenCoordinates) {
        // The farm land is expressed as a 2D array of ints. The fertile land is first represented by 0s, which the array values default 
        // to upon intialization. 
        this.land = new int[width][height];
        this.farmWidth = width;
        this.farmHeight = height;
        
        setBarrenLand(barrenCoordinates);
    }
    
    /**
     * Populates the barren points of land in the 2D array
     * @param barrenCoordinates A list of points representing the corners of the barren plots of land
     */
    public void setBarrenLand(String[] barrenCoordinates) {
        if (barrenCoordinates != null) {
            for (String coordinates : barrenCoordinates) {
                // Points should be of the format "botLeftX botLeftY topRightX topRightY"
                String[] points = coordinates.split(" ");
                
                if (points != null && points.length == 4) {
                    int botLeftX = Integer.valueOf(points[0]);
                    int botLeftY = Integer.valueOf(points[1]);
                    int topRightX = Integer.valueOf(points[2]);
                    int topRightY = Integer.valueOf(points[3]);
                    
                    // Set the barren points of land
                    for (int y = botLeftY; y <= topRightY; y++) {
                        for (int x = botLeftX; x <= topRightX; x++) {
                            land[x][y] = BARREN_LAND;
                        }
                    }
                }
            }
        }
    }
    
    /**
     * @return The area(s) of contiguous fertile land, sorted from smallest to largest
     */
    public List<Integer> findFertileLand() {
        List<Integer> fertilePlots = new LinkedList();
        
        for (int j = 0; j < farmHeight; j++) {
            for (int i = 0; i < farmWidth; i++) {
                if (land[i][j] == UNCOUNTED_FERTILE_LAND) {
                    Integer fertileArea = findFertilePlotArea(i,j);
                    fertilePlots.add(fertileArea);
                }
            }
        }
        
        Collections.sort(fertilePlots);
        
        // If no fertile plots were found, then append a single value of 0 to the list
        if (fertilePlots.isEmpty()) {
            fertilePlots.add(0);
        }
        
        return fertilePlots;
    }
    
    /**
     * Performs a breath-first search around a fertile point, in order to determine the fertile plot's total area
     * @param firstX The x coordinate of the first fertile point
     * @param firstY The y coordinate of the first fertile point
     * @return The total area of the fertile plot
     */
    public int findFertilePlotArea(int firstX, int firstY) {
        int area = 0;
        
        Stack<Coordinate> stack = new Stack<>();
        
        stack.push(new Coordinate(firstX,firstY));
        
        while (!stack.isEmpty()) {
            Coordinate current = stack.pop();
            int x = current.getX();
            int y = current.getY();
            
            if (pointExists(x,y) && land[x][y] == UNCOUNTED_FERTILE_LAND) {
                area++;
                land[x][y] = COUNTED_FERTILE_LAND;

                // Check each neighboring point to see if they are part of the contiguous fertile plot
                stack.push(new Coordinate(x-1,y));
                stack.push(new Coordinate(x+1,y));
                stack.push(new Coordinate(x,y-1));
                stack.push(new Coordinate(x,y+1));
            }
            
        }
        
        return area;
    }
    
    /**
     * Helper function to determine if a point actually exists within the plot
     * @param x The x coordinate of the point
     * @param y The y coordinate of the point
     * @return True if the point is within the scope of the graph, false otherwise
     */
    private boolean pointExists(int x, int y) {
        return x >= 0 && x < farmWidth && y >= 0 && y < farmHeight;
    }
    
    
    /**
     * Prints the graph with the width running along x-axis, and the height along the y-axis. Can be used to visualize the graph during testing
     */
    public void printGraph() {
        for (int j = farmHeight - 1; j >= 0; j--) {
            for (int i = 0; i < farmWidth; i++) {
                System.out.print(land[i][j]);
            }
            System.out.println();
        }
    }
    
}
