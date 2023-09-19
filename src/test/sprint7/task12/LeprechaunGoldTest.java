package test.sprint7.task12;

import sprint7.task12.LeprechaunGold;
import test.AbstractCaseTest;

public class LeprechaunGoldTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "5 15\n" + "3 8 1 2 5\n";
        testLogic("15");
    }

    private static void test2() {
        str = "5 19\n" + "10 10 7 7 4\n";
        testLogic("18");
    }

    private static void testLogic(String expected) {
        setUp(str);
        LeprechaunGold.main(null);
        validate(expected);
    }
}
