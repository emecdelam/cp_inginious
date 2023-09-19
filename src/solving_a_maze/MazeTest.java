package solving_a_maze;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import utils.TestClass;

import java.util.Arrays;

public class MazeTest {
    @Test
    public void testMain(){
        String input = """
                11 11
                ###########
                #....T#.#.#
                #.#.###.#.#
                #.#.#.....#
                #.#.#.###.#
                #.#.#.#.#.#
                #.#.#.#S#.#
                #.#.#.#.#.#
                #.#.###.#.#
                #.........#
                ###########
                """;
        String output = """
                6 7\r
                7 7\r
                8 7\r
                9 7\r
                9 6\r
                9 5\r
                9 4\r
                9 3\r
                8 3\r
                7 3\r
                6 3\r
                5 3\r
                4 3\r
                3 3\r
                2 3\r
                1 3\r
                1 4\r
                1 5\r
                """;
        Assertions.assertEquals(TestClass.publicTest(input,Maze.class),output);
    }
    @Test
    public void testLineToString(){
        String input = "Test";
        char[] res = {'T','e','s','t'};
        Assertions.assertEquals(Arrays.toString(Maze.lineToChar(input)),Arrays.toString(res));
    }
}
