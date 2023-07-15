package test.sprint3.task5;

import sprint3.task5.HouseBuying;
import test.AbstractCaseTest;

public class HouseBuyingTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "3 300\n" + "999 999 999";
        testLogic("0");
    }

    private static void test2() {
        str = "3 1000\n" + "350 999 200";
        testLogic("2");
    }

    private static void testLogic(String expected) {
        setUp(str);
        HouseBuying.main(null);
        validate(expected);
    }
}
