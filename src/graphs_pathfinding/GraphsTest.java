package graphs_pathfinding;
import org.junit.jupiter.api.Assertions;
import utils.TestClass;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class GraphsTest {
    @Test
    public void testMain(){
        String input1 = """
                14 15
                0 1
                0 2
                0 3
                0 4
                1 5
                1 6
                2 7
                6 7
                5 4
                4 8
                8 9
                9 3
                3 10
                10 11
                12 13
                0 11
                """;
        String output1 = """
                0 3 10 11\r
                """;

        Assertions.assertEquals(TestClass.publicTest(input1,Graphs.class),output1);

    }
    @SuppressWarnings("unchecked")
    @Test
    public void testPathFinder(){
        LinkedList<Integer>[] g = new LinkedList[5];
        for(int v = 0; v < g.length; v++) {
            g[v] = new LinkedList<>();
        }
        g[0].add(1);
        g[1].add(2);
        g[2].add(0);
        g[4].add(5);
        ArrayList<Integer> output1 = new ArrayList<>();
        output1.add(2);
        output1.add(0);
        output1.add(1);
        assertEquals(output1, Graphs.findPath(g,2,1));
    }

}
