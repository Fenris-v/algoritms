package test.sprint7.task11;

import sprint7.task11.Horoscopes;
import test.AbstractCaseTest;

public class HoroscopesTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "5\n" + "4 9 2 4 6\n" + "7\n" + "9 4 0 0 2 8 4\n";
        testLogic("3\n" + "1 3 4\n" + "2 5 7\n");
    }

    private static void test2() {
        str = "4\n" + "1 1 1 1\n" + "2\n" + "2 2\n";
        testLogic("0\n");
    }

    private static void test3() {
        str = "8\n" + "1 2 1 9 1 2 1 9\n" + "5\n" + "9 9 1 9 9\n";
        testLogic("3\n" + "3 4 8\n" + "3 4 5\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Horoscopes.main(null);
        validate(expected);
    }
}
