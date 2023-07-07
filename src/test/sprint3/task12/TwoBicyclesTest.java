package test.sprint3.task12;

import sprint3.task12.TwoBicycles2;
import test.AbstractCaseTest;

public class TwoBicyclesTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "6\n" + "1 2 4 4 6 8\n" + "3";
        testLogic("3 5");
    }

    private static void test2() {
        str = "6\n" + "1 2 4 4 4 4\n" + "3";
        testLogic("3 -1");
    }

    private static void test3() {
        str = "6\n" + "1 2 4 4 4 4\n" + "10";
        testLogic("-1 -1");
    }

    private static void test4() {
        str = "6\n" + "20 20 24 24 24 24\n" + "10";
        testLogic("1 1");
    }

    private static void testLogic(String expected) {
        setUp(str);
        TwoBicycles2.main(null);
        validate(expected);
    }
}
