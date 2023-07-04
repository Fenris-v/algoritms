package test.sprint2.finaltask.task2;

import sprint2.finaltask.task2.Solution;
import test.AbstractCaseTest;

public class CalculatorTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }

    private static void test1() {
        str = "2 1 + 3 *";
        testLogic("9");
    }

    private static void test2() {
        str = "7 2 + 4 * 2 +";
        testLogic("38");
    }

    private static void test3() {
        str = "10 2 4 * -";
        testLogic("2");
    }

    private static void test4() {
        str = "4 2 * 4 / 25 * 2 - 12 / 1000 + 2 / -999 +";
        testLogic("-497");
    }

    private static void test5() {
        str = "2 5 - 4 /";
        testLogic("-1");
    }

    private static void test6() {
        str = "4 2 * 4 / 25 * 2 - 12 / 500 2 * + 2 / -999 + 71 + -1 * 2 / 1000 + 6 * 8065 - 787 + 66 * 456 - 45 * 10 /";
        testLogic("-2052");
    }

    private static void test7() {
        str = "0 10 * -8 10 / + -9 4 / -10 5 * - * 1 0 - 6 -3 * - 7 3 / 10 -6 - - - /";
        testLogic("-2");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Solution.main(null);
        validate(expected);
    }
}
