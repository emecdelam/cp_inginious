package utils;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This is a custom logger to be used as a debugging tool.
 * It prints the desired input in a file instead of the console wich is used y inginious for submits.
 * */
@SuppressWarnings("unused")
public class Logger {
    @SuppressWarnings("unused")
    public static void println(String message) {
        try {
            FileWriter fileWriter = new FileWriter("log.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(message);
            printWriter.close();
        } catch (IOException e) {
            logError(e.getMessage());
        }
    }
    @SuppressWarnings("unused")
    public static void print(String message) {
        try {
            FileWriter fileWriter = new FileWriter("log.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(message);
            printWriter.close();
        } catch (IOException e) {
            logError(e.getMessage());
        }
    }
    @SuppressWarnings("unused")
    public static void clearLog() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt"))) {
            writer.print("");
        } catch (IOException e) {
            logError(e.getMessage());
        }
    }
    public static void logError(String errorMessage) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss] ");
            Date now = new Date();
            String formattedDatetime = dateFormat.format(now);
            FileWriter fileWriter = new FileWriter("errors.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(formattedDatetime + "Error:\n" + errorMessage);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
