package ad_hoc;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
class AdHocTest {
    @Test
    public void testMain(){
        String input1 = """
                8
                24
                1 1
                1 2
                1 3
                2 1
                2 2
                2 3
                3 1
                3 2
                3 3
                4 1
                4 2
                4 3
                5 1
                5 2
                5 3
                6 1
                6 2
                6 3
                7 1
                7 2
                7 3
                8 1
                8 2
                8 3
                """;
        String output1 = """
                2 2\r
                3 4\r
                5 8\r
                1 1\r
                3 4\r
                5 8\r
                4 4\r
                1 2\r
                5 8\r
                3 3\r
                1 2\r
                5 8\r
                6 6\r
                7 8\r
                1 4\r
                5 5\r
                7 8\r
                1 4\r
                8 8\r
                5 6\r
                1 4\r
                7 7\r
                5 6\r
                1 4\r
                """;
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(input1.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            AdHoc.main(new String[]{});
            String actualOutput = outputStream.toString();
            assertEquals(output1, actualOutput);
        } finally {
            System.setIn(originalSystemIn);
            System.setOut(originalSystemOut);
        }
    }
}