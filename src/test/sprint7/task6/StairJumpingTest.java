package test.sprint7.task6;

import sprint7.task6.StairJumping;
import test.AbstractCaseTest;

public class StairJumpingTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static void test1() {
        str = "6 3";
        testLogic("13");
    }

    private static void test2() {
        str = "7 7";
        testLogic("32");
    }

    private static void test3() {
        str = "2 2";
        testLogic("1");
    }

    private static void test4() {
        str = "8 1";
        testLogic("1");
    }

    private static void test5() {
        str = "62 44";
        testLogic("535806680");
    }

    private static void test6() {
        str = "79 34";
        testLogic("470472762");
    }

    private static void testLogic(String expected) {
        setUp(str);
        StairJumping.main(null);
        validate(expected);
    }
}
