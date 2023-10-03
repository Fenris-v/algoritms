package test.sprint7.task10;

import sprint7.task10.Travel;
import test.AbstractCaseTest;

public class TravelTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "5\n" + "4 2 9 1 13\n";
        testLogic("3\n" + "1 3 5");
    }

    private static void test2() {
        str = "6\n" + "1 2 4 8 16 32\n";
        testLogic("6\n" + "1 2 3 4 5 6");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Travel.main(null);
        validate(expected);
    }
}
