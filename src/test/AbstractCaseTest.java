package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public abstract class AbstractCaseTest {
    protected static String str;

    private static final OutputStream ORIGINAL_OUTPUT_STREAM = System.out;

    private static int testCase = 1;

    private static OutputStream outputStream;

    protected static void setUp(String str) {
        System.setIn(new ByteArrayInputStream(str.getBytes()));

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    protected static void validate(String expected) {
        String result = outputStream.toString();

        System.setOut(new PrintStream(ORIGINAL_OUTPUT_STREAM));
        if (result.equals(expected)) {
            System.out.println("\u001B[32m" + "test " + testCase + " is success finished");
        } else {
            System.out.println("\u001B[31m" + "test " + testCase + " is failed");
            System.out.println("expected: " + expected);
            System.out.println("result: " + result);
        }

        testCase++;
    }
}
