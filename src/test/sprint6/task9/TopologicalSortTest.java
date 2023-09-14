package test.sprint6.task9;

import sprint6.task9.TopologicalSort;
import test.AbstractCaseTest;

public class TopologicalSortTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "5 3\n" + "3 2\n" + "3 4\n" + "2 5\n";
        testLogic("1 3 2 4 5 ");
    }

    private static void test2() {
        str = "6 3\n" + "6 4\n" + "4 1\n" + "5 1\n";
        testLogic("2 3 5 6 4 1 ");
    }

    private static void test3() {
        str = "4 0\n";
        testLogic("1 2 3 4 ");
    }

    private static void testLogic(String expected) {
        setUp(str);
        TopologicalSort.main(null);
        validate(expected);
    }
}
