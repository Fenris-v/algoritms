package test.sprint7.task1;

import sprint7.task1.Exchange;
import test.AbstractCaseTest;

public class ExchangeTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "6\n" + "7 1 5 3 6 4";
        testLogic("7");
    }

    private static void test2() {
        str = "5\n" + "1 2 3 4 5";
        testLogic("4");
    }

    private static void test3() {
        str = "6\n" + "1 12 12 16 1 8";
        testLogic("22");
    }

    private static void test4() {
        str = "33\n" + "1 29 22 65 82 83 5 10 22 76 93 29 97 26 81 62 5 36 25 41 6 65 1 10 41 91 78 13 85 43 93 10 36";
        testLogic("644");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Exchange.main(null);
        validate(expected);
    }
}
