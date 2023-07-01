package test.sprint1.task3;

import sprint1.task3.Neighbors;
import test.AbstractCaseTest;

public class NeighborsTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    private static void test1() {
        str = "4\n" +
                "3\n" +
                "1 2 3\n" +
                "0 2 6\n" +
                "7 4 1\n" +
                "2 7 0\n" +
                "3\n" +
                "0\n";
        testLogic("7 7");
    }

    private static void test2() {
        str = "4\n" +
                "3\n" +
                "1 2 3\n" +
                "0 2 6\n" +
                "7 4 1\n" +
                "2 7 0\n" +
                "2\n" +
                "1\n";
        testLogic("1 2 7 7");
    }

    private static void test3() {
        str = "4\n" +
                "3\n" +
                "1 2 3\n" +
                "0 2 6\n" +
                "7 4 1\n" +
                "2 7 0\n" +
                "0\n" +
                "0\n";
        testLogic("0 2");
    }

    private static void test4() {
        str = "4\n" +
                "3\n" +
                "1 -10 3\n" +
                "0 2 1000\n" +
                "7 -50 1\n" +
                "2 7 0\n" +
                "1\n" +
                "1\n";
        testLogic("-50 -10 0 1000");
    }

    private static void test5() {
        str = "4\n" +
                "3\n" +
                "1 2 3\n" +
                "0 2 6\n" +
                "7 4 1\n" +
                "2 7 0\n" +
                "0\n" +
                "2\n";
        testLogic("2 6");
    }

    private static void test6() {
        str = "4\n" +
                "3\n" +
                "1 2 3\n" +
                "0 2 6\n" +
                "7 4 1\n" +
                "2 7 0\n" +
                "2\n" +
                "2\n";
        testLogic("0 4 6");
    }

    private static void test7() {
        str = "4\n" +
                "3\n" +
                "1 2 3\n" +
                "0 2 6\n" +
                "7 4 1\n" +
                "2 7 0\n" +
                "2\n" +
                "2\n";
        testLogic("0 4 6");
    }

    private static void test8() {
        str = "4\n" +
                "3\n" +
                "1 2 3\n" +
                "0 2 6\n" +
                "7 4 1\n" +
                "2 7 0\n" +
                "0\n" +
                "1\n";
        testLogic("1 2 3");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Neighbors.main(null);
        validate(expected);
    }
}
