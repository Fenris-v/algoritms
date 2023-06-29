package test.sprint1.task10;

import sprint1.task10.Factorization;
import test.AbstractCaseTest;

public class FactorizationTest extends AbstractCaseTest {
    private static String str;

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "8";
        testLogic("2 2 2");
    }

    private static void test2() {
        str = "13";
        testLogic("13");
    }

    private static void test3() {
        str = "100";
        testLogic("2 2 5 5");
    }

    private static void test4() {
        str = "917521579";
        testLogic("13 70578583");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Factorization.main(null);
        validate(expected);
    }
}
