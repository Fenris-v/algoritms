package test.sprint4.task1;

import sprint4.task1.PolynomialHash;
import test.AbstractCaseTest;

public class PolynomialHashTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "123\n" + "100003\n" + "a\n";
        testLogic("97\n");
    }

    private static void test2() {
        str = "123\n" + "100003\n" + "hash\n";
        testLogic("6080\n");
    }

    private static void test3() {
        str = "123\n" + "100003\n" + "HaSH\n";
        testLogic("56156\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        PolynomialHash.main(null);
        validate(expected);
    }
}
