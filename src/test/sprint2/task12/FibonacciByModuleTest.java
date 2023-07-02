package test.sprint2.task12;

import sprint2.task12.FibonacciByModule;
import test.AbstractCaseTest;

public class FibonacciByModuleTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test1() {
        str = "3 1";
        testLogic("3");
    }

    private static void test2() {
        str = "10 1";
        testLogic("9");
    }

    private static void test3() {
        str = "10 2";
        testLogic("89");
    }

    private static void test4() {
        str = "70 6";
        testLogic("170129");
    }

    private static void test5() {
        str = "665 2";
        testLogic("88");
    }

    private static void testLogic(String expected) {
        setUp(str);
        FibonacciByModule.main(null);
        validate(expected);
    }
}
