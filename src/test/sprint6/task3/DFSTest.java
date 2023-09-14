package test.sprint6.task3;

import sprint6.task3.DFS;
import test.AbstractCaseTest;

public class DFSTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "4 4\n" + "3 2\n" + "4 3\n" + "1 4\n" + "1 2\n" + "3\n";
        testLogic("3 2 1 4");
    }

    private static void test2() {
        str = "2 1\n" + "1 2\n" + "1\n";
        testLogic("1 2");
    }

    private static void test3() {
        str = "1 0\n" + "1\n";
        testLogic("1");
    }

    private static void test4() {
        str = "6 7\n" + "3 2\n" + "5 4\n" + "3 1\n" + "1 4\n" + "1 6\n" + "1 2\n" + "1 5\n" + "1\n";
        testLogic("1 2 3 4 5 6");
    }

    private static void testLogic(String expected) {
        setUp(str);
        DFS.main(null);
        validate(expected);
    }
}
