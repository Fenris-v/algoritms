package test.sprint6.task10;

import sprint6.task10.Sights;
import test.AbstractCaseTest;

public class SightsTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "4 4\n" + "1 2 1\n" + "2 3 3\n" + "3 4 5\n" + "1 4 2\n";
        testLogic("0 1 4 2\n" + "1 0 3 3\n" + "4 3 0 5\n" + "2 3 5 0\n");
    }

    private static void test2() {
        str = "3 2\n" + "1 2 1\n" + "1 2 2\n";
        testLogic("0 1 -1\n" + "1 0 -1\n" + "-1 -1 0\n");
    }

    private static void test3() {
        str = "2 0\n";
        testLogic("0 -1\n" + "-1 0\n");
    }

    private static void test4() {
        str = "6 8\n" + "4 1 3\n" + "2 1 9\n" + "1 3 3\n" + "6 5 3\n" + "3 6 8\n" + "2 6 10\n" + "2 3 5\n" + "5 3 3\n";
        testLogic("0 8 3 3 6 9\n" + "8 0 5 11 8 10\n" + "3 5 0 6 3 6\n" + "3 11 6 0 9 12\n" + "6 8 3 9 0 3\n" +
                          "9 10 6 12 3 0\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Sights.main(null);
        validate(expected);
    }
}
