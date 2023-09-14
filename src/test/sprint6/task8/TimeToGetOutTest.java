package test.sprint6.task8;

import sprint6.task8.TimeToGetOut;
import test.AbstractCaseTest;

public class TimeToGetOutTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "6 8\n" + "2 6\n" + "1 6\n" + "3 1\n" + "2 5\n" + "4 3\n" + "3 2\n" + "1 2\n" + "1 4\n";
        testLogic("0 11\n" + "1 6\n" + "8 9\n" + "7 10\n" + "2 3\n" + "4 5\n");
    }

    private static void test2() {
        str = "3 2\n" + "1 2\n" + "2 3\n";
        testLogic("0 5\n" + "1 4\n" + "2 3\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        TimeToGetOut.main(null);
        validate(expected);
    }
}
