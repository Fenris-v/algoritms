package test.sprint3.task9;

import sprint3.task9.Conferences2;
import test.AbstractCaseTest;

public class ConferencesTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "7\n" + "1 2 3 1 2 3 4\n" + "3\n";
        testLogic("1 2 3");
    }

    private static void test2() {
        str = "6\n" + "1 1 1 2 2 3\n" + "1\n";
        testLogic("1");
    }

    private static void test3() {
        str = "6\n" + "1 1 1 2 2 3\n" + "3\n";
        testLogic("1 2 3");
    }

    private static void test4() {
        str = "9\n" + "1 1 1 2 2 3 7 5 5\n" + "3\n";
        testLogic("1 2 5");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Conferences2.main(null);
        validate(expected);
    }
}
