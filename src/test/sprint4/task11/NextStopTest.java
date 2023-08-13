package test.sprint4.task11;

import sprint4.task11.NextStop;
import test.AbstractCaseTest;

public class NextStopTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "3\n" + "-1 0\n" + "1 0\n" + "2 5\n" + "3\n" + "10 0\n" + "20 0\n" + "22 5\n";
        testLogic("3\n");
    }

    private static void test2() {
        str = "3\n" + "-1 0\n" + "1 0\n" + "0 5\n" + "3\n" + "10 0\n" + "20 0\n" + "20 5\n";
        testLogic("2\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        NextStop.main(null);
        validate(expected);
    }
}
