package test.sprint6.task4;

import sprint6.task4.BFS;
import test.AbstractCaseTest;

public class BFSTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "4 4\n" + "1 2\n" + "2 3\n" + "3 4\n" + "1 4\n" + "3\n";
        testLogic("3 2 4 1");
    }

    private static void test2() {
        str = "2 1\n" + "2 1\n" + "1\n";
        testLogic("1 2");
    }

    private static void test3() {
        str = "2 1\n" + "2 1\n" + "1\n";
        testLogic("1 2");
    }

    private static void test4() {
        str = "6 8\n" + "5 6\n" + "1 4\n" + "2 5\n" + "2 4\n" + "6 4\n" + "5 4\n" + "1 5\n" + "3 1\n" + "1\n";
        testLogic("1 3 4 5 2 6");
    }

    private static void testLogic(String expected) {
        setUp(str);
        BFS.main(null);
        validate(expected);
    }
}
