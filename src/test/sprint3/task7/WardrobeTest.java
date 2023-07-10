package test.sprint3.task7;

import sprint3.task7.Wardrobe;
import test.AbstractCaseTest;

public class WardrobeTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "7\n" + "0 2 1 2 0 0 1";
        testLogic("0 0 0 1 1 2 2");
    }

    private static void test2() {
        str = "5\n" + "2 1 2 0 1";
        testLogic("0 1 1 2 2");
    }

    private static void test3() {
        str = "6\n" + "2 1 1 2 0 2";
        testLogic("0 1 1 2 2 2");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Wardrobe.main(null);
        validate(expected);
    }
}
