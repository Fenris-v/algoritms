package test.sprint2.task1;

import sprint2.task1.Monitoring;
import test.AbstractCaseTest;

public class MonitoringTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "4\n" +
                "3\n" +
                "1 2 3\n" +
                "0 2 6\n" +
                "7 4 1\n" +
                "2 7 0\n";
        testLogic("1 0 7 2\n" +
                          "2 2 4 7\n" +
                          "3 6 1 0\n");
    }

    private static void test2() {
        str = "9\n" +
                "5\n" +
                "-7 -1 0 -4 -9\n" +
                "5 -1 2 2 9\n" +
                "3 1 -8 -1 -7\n" +
                "9 0 8 -8 -1\n" +
                "2 4 5 2 8\n" +
                "-7 10 0 -4 -8\n" +
                "-3 10 -7 10 3\n" +
                "1 6 -7 -5 9\n" +
                "-1 9 9 1 9\n";
        testLogic("-7 5 3 9 2 -7 -3 1 -1\n" +
                          "-1 -1 1 0 4 10 10 6 9\n" +
                          "0 2 -8 8 5 0 -7 -7 9\n" +
                          "-4 2 -1 -8 2 -4 10 -5 1\n" +
                          "-9 9 -7 -1 8 -8 3 9 9\n");
    }

    private static void test3() {
        str = "0\n" +
                "0\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n";
        testLogic("");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Monitoring.main(null);
        validate(expected);
    }
}
