package test.sprint3.task15;

import sprint3.task15.DiffOfTrashIndexes;
import test.AbstractCaseTest;

public class DiffOfTrashIndexesTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "3\n" + "2 3 4\n" + "2";
        testLogic("1");
    }

    private static void test2() {
        str = "3\n" + "1 3 1\n" + "1";
        testLogic("0");
    }

    private static void test3() {
        str = "3\n" + "1 3 5\n" + "3";
        testLogic("4");
    }

    private static void testLogic(String expected) {
        setUp(str);
        DiffOfTrashIndexes.main(null);
        validate(expected);
    }
}
