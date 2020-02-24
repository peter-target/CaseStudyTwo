package CaseStudytwo;

import java.util.*;

/**
 *
 * @author Peter
 */
public class Main {

    // Default values given in the prompt
    private static final int FARM_WIDTH = 400; 
    private static final int FARM_HEIGHT = 600;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> coordinates = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type in barren plots in the format 'botLeftX botLeftY topRightX topRightY' and then press 'Enter' once to save the plot");
        System.out.println("Press 'Enter' a second time, or type 'exit' to complete the analysis");
        System.out.println();
        
        String readString = scanner.nextLine();
        if (isValid(readString)) {
            //First String needs to be checked outside the loop in order to use hasNextLine()
            coordinates.add(readString);
        }
        while (readString != null) {
            
            if (readString.isEmpty() || readString.equalsIgnoreCase("exit")) {
                break;
            }
            
            if (scanner.hasNextLine()) {
                readString = scanner.nextLine();
                
                if (isValid(readString)) {
                    coordinates.add(readString);
                }
            }
            else {
                readString = null;
            }
            
            
        }
        
        String[] coordinatesArray = new String[coordinates.size()];
        int index = 0;
        Iterator i = coordinates.iterator();
        
        while (i.hasNext()) {
            String s = (String) i.next();
            coordinatesArray[index] = s;;
            index++;
        }
        
        BarrenLandAnalyzer analysis = new BarrenLandAnalyzer(FARM_WIDTH, FARM_HEIGHT, coordinatesArray);
        List<Integer> fertilePlots = analysis.findFertileLand();
        printAreas(fertilePlots);
    }
    
    /**
     * Checks if a given String line matches the format "Integer Integer Integer Integer"
     * @param s The String being checked
     * @return True if the String contains four integers separated by spaces, false otherwise
     */
    public static boolean isValid(String s) {
        boolean valid = false;
        
        if (s != null) {
            String[] split = s.split(" ");
            
            if (split.length == 4 && split[0].matches("\\d+") && split[1].matches("\\d+") && split[2].matches("\\d+") && split[3].matches("\\d+")) {
                valid = true;
            }
        }
        
        return valid;
    }
    
    /**
     * Prints a list of areas as a single line, with each area separated by a space
     * @param areas The areas to be printed
     */
    public static void printAreas(List<Integer> areas) {
        StringBuilder output = new StringBuilder();
        
        if (areas != null) {
            Iterator i = areas.iterator();
            
            while (i.hasNext()) {
                Integer anArea = (Integer) i.next();
                
                output.append(anArea);
                
                if (i.hasNext()) {
                    output.append(" ");
                }
            }
        }
        
        System.out.println(output.toString());
    }
    
}
