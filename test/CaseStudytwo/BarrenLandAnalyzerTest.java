package CaseStudytwo;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.*;

/**
 *
 * @author Peter
 */
public class BarrenLandAnalyzerTest {
    
    public BarrenLandAnalyzerTest() {
    }
    
    /**
     * Given example #1
     */
    @org.junit.Test
    public void testGivenExampleOne() {
        
        String[] points = {"0 292 399 307"};
        BarrenLandAnalyzer analysis = new BarrenLandAnalyzer(400, 600, points);
        List<Integer> fertilePlots = analysis.findFertileLand();
        List<Integer> expected = Arrays.asList(116800, 116800);
        assertThat(fertilePlots, is(expected));
    }
    
    /**
     * Given example #2
     */
    @org.junit.Test
    public void testGivenExampleTwo() {
        
        String[] points = {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};
        BarrenLandAnalyzer analysis = new BarrenLandAnalyzer(400, 600, points);
        List<Integer> fertilePlots = analysis.findFertileLand();
        List<Integer> expected = Arrays.asList(22816, 192608);
        assertThat(fertilePlots, is(expected));
    }
    
    /**
     * Basic example on a smaller graph
     */
    @org.junit.Test
    public void testBasicExample() {
        
        String[] points = {"0 2 5 3"};
        BarrenLandAnalyzer analysis = new BarrenLandAnalyzer(6, 5, points);
        List<Integer> fertilePlots = analysis.findFertileLand();
        List<Integer> expected = Arrays.asList(6, 12);
        assertThat(fertilePlots, is(expected));
    }
    
    /**
     * One single point of barren land
     */
    @org.junit.Test
    public void testOnePointBarrenLand() {
        
        String[] points = {"0 0 0 0"};
        BarrenLandAnalyzer analysis = new BarrenLandAnalyzer(6, 5, points);
        List<Integer> fertilePlots = analysis.findFertileLand();
        List<Integer> expected = Arrays.asList(29);
        assertThat(fertilePlots, is(expected));
    }
    
    /**
     * One single point of fertile land. Also includes a size-1 row
     */
    @org.junit.Test
    public void testOnePointFertileLand() {
        
        String[] points = {"0 0 5 3", "0 4 4 4"};
        BarrenLandAnalyzer analysis = new BarrenLandAnalyzer(6, 5, points);
        List<Integer> fertilePlots = analysis.findFertileLand();
        List<Integer> expected = Arrays.asList(1);
        assertThat(fertilePlots, is(expected));
    }
    
    /**
     * Two distinct plots of fertile land connected kitty-corner
     */
    @org.junit.Test
    public void testKittyCornerPlots() {
        
        String[] points = {"0 3 3 4", "4 0 5 2"};
        BarrenLandAnalyzer analysis = new BarrenLandAnalyzer(6, 5, points);
        List<Integer> fertilePlots = analysis.findFertileLand();
        List<Integer> expected = Arrays.asList(4,12);
        assertThat(fertilePlots, is(expected));
    }
    
    /**
     * Three distinct plots of barren land. Includes a size-1 column
     */
    @org.junit.Test
    public void testThreeBarrenPlots() {
        
        String[] points = {"1 1 2 2", "4 0 4 4", "0 4 1 4"};
        BarrenLandAnalyzer analysis = new BarrenLandAnalyzer(6, 5, points);
        List<Integer> fertilePlots = analysis.findFertileLand();
        List<Integer> expected = Arrays.asList(5,14);
        assertThat(fertilePlots, is(expected));
    }
    
    /**
     * Three distinct plots of fertile land
     */
    @org.junit.Test
    public void testThreeFertilePlots() {
        
        String[] points = {"0 5 9 6", "4 0 7 4"};
        BarrenLandAnalyzer analysis = new BarrenLandAnalyzer(10, 10, points);
        List<Integer> fertilePlots = analysis.findFertileLand();
        List<Integer> expected = Arrays.asList(10,20,30);
        assertThat(fertilePlots, is(expected));
    }
    
    /**
     * Plots of barren land which overlap
     */
    @org.junit.Test
    public void testOverlappingBarrenPlots() {
        
        String[] points = {"0 0 3 4", "0 3 5 4"};
        BarrenLandAnalyzer analysis = new BarrenLandAnalyzer(6, 5, points);
        List<Integer> fertilePlots = analysis.findFertileLand();
        List<Integer> expected = Arrays.asList(6);
        assertThat(fertilePlots, is(expected));
    }
    

    /**
     * No fertile land
     */
    @org.junit.Test
    public void testNoFertileLand() {
        
        String[] points = {"0 0 3 4", "4 0 5 4"};
        BarrenLandAnalyzer analysis = new BarrenLandAnalyzer(6, 5, points);
        List<Integer> fertilePlots = analysis.findFertileLand();
        List<Integer> expected = Arrays.asList(0);
        assertThat(fertilePlots, is(expected));
    }
    
    /**
     * No barren land
     */
    @org.junit.Test
    public void testNoBarrenLand() {
        
        String[] points = {};
        BarrenLandAnalyzer analysis = new BarrenLandAnalyzer(6, 5, points);
        List<Integer> fertilePlots = analysis.findFertileLand();
        List<Integer> expected = Arrays.asList(30);
        assertThat(fertilePlots, is(expected));
    }
}
