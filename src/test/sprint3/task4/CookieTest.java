package test.sprint3.task4;

import sprint3.task4.Cookie;
import test.AbstractCaseTest;

public class CookieTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "2\n" + "1 2\n" + "3\n" + "2 1 3\n";
        testLogic("2");
    }

    private static void test2() {
        str = "3\n" + "2 1 3\n" + "2\n" + "1 1\n";
        testLogic("1");
    }

    private static void test3() {
        str = "10\n" + "8 5 5 8 6 9 8 2 4 7\n" + "8\n" + "9 8 1 1 1 5 10 8\n";
        testLogic("5");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Cookie.main(null);
        validate(expected);
    }
}
