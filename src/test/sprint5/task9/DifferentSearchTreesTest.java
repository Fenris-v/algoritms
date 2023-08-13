package test.sprint5.task9;

import sprint5.task9.DifferentSearchTrees;
import test.AbstractCaseTest;

public class DifferentSearchTreesTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "2";
        testLogic("2");
    }

    private static void test2() {
        str = "3";
        testLogic("5");
    }

    private static void test3() {
        str = "4";
        testLogic("14");
    }

    private static void testLogic(String expected) {
        setUp(str);
        DifferentSearchTrees.main(null);
        validate(expected);
    }
}
