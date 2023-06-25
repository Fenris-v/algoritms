package test.sprint1.finaltask.task1;

import sprint1.finaltask.task1.NearestZero;
import test.AbstractCaseTest;

public class NearestZeroTest extends AbstractCaseTest {
    private static String str;

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test1() {
        str = "5\n" + "0 1 4 9 0";
        testLogic("0 1 2 1 0");
    }

    private static void test2() {
        str = "5\n" + "0 0 0 0 0";
        testLogic("0 0 0 0 0");
    }

    private static void test3() {
        str = "20\n" + "0 1 5 3 2 4 5 1 2 0 0 0 9 0 0 0 1 2 3 4";
        testLogic("0 1 2 3 4 4 3 2 1 0 0 0 1 0 0 0 1 2 3 4");
    }

    private static void test4() {
        str = "5\n" + "0 1 5 3 2";
        testLogic("0 1 2 3 4");
    }

    private static void test5() {
        str = "5\n" + "5 1 5 3 0";
        testLogic("4 3 2 1 0");
    }

    private static void testLogic(String expected) {
        setUp(str);
        NearestZero.main(null);
        write(expected);
    }
}
