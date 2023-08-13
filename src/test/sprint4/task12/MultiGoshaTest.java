package test.sprint4.task12;

import sprint4.task12.MultiGosha2;
import test.AbstractCaseTest;

public class MultiGoshaTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "10 2\n" + "gggggooooogggggoooooogggggssshaa";
        testLogic("0 5\n");
    }

    private static void test2() {
        str = "3 4\n" + "allallallallalla";
        testLogic("0 1 2\n");
    }

    private static void test3() {
        str = "10 6\n" + "kkkkkkkkkkkkkkkkkkkk";
        testLogic("0\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        MultiGosha2.main(null);
        validate(expected);
    }
}
