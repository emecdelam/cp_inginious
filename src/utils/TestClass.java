package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
/**
 * This is a custom Test class to easily test using in out.
 * It is used like this :
 * @Test
 * public void testMain(){
 *     output = TestClass.publicTest(input)
 * }
 * */
public class TestClass {
    public static String publicTest(String input, Class<?> testedClass) {
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(outputStream));
        try {
            Method mainMethod = testedClass.getMethod("main", String[].class);
            mainMethod.invoke(null, (Object) new String[0]);
            return outputStream.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Test failed: " + e.getMessage();
        } finally {
            System.setIn(originalSystemIn);
            System.setOut(originalSystemOut);
        }
    }
}