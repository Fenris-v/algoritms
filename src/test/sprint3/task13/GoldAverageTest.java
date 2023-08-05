package test.sprint3.task13;

import sprint3.task13.GoldAverage;
import test.AbstractCaseTest;

public class GoldAverageTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "2\n" + "1\n" + "1 3\n" + "2\n";
        testLogic("2\n");
    }

    private static void test2() {
        str = "2\n" + "2\n" + "1 2\n" + "3 4\n";
        testLogic("2.5\n");
    }

    private static void test3() {
        str = "8\n" + "10\n" + "0 0 0 1 3 3 5 10\n" + "4 4 5 7 7 7 8 9 9 10\n";
        testLogic("5\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        GoldAverage.main(null);
        validate(expected);
    }
}
