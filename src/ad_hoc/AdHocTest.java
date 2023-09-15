package ad_hoc;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import ad_hoc.AdHoc;
class AdHocTest {
    @Test
    public void testMain(){
        String input1 = "8\n3\n3 1\n7 2\n2 3\n";
        String output1 = "4 4\r\n5 6\r\n5 8\r\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(input1.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            AdHoc.main(new String[]{});
            String actualOutput = outputStream.toString();
            String expectedOutput = output1;
            assertEquals(expectedOutput, actualOutput);
        } finally {
            System.setIn(originalSystemIn);
            System.setOut(originalSystemOut);
        }
    }
}