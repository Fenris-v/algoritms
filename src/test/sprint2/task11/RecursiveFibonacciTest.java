package test.sprint2.task11;

import sprint2.task11.RecursiveFibonacci;
import test.AbstractCaseTest;

public class RecursiveFibonacciTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "3";
        testLogic("3");
    }

    private static void test2() {
        str = "0";
        testLogic("1");
    }

    private static void testLogic(String expected) {
        setUp(str);
        RecursiveFibonacci.main(null);
        validate(expected);
    }
}
