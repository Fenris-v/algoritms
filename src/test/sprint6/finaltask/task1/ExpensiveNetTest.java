package test.sprint6.finaltask.task1;

import sprint6.finaltask.task1.ExpensiveNet;
import test.AbstractCaseTest;

public class ExpensiveNetTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "4 4\n" + "1 2 5\n" + "1 3 6\n" + "2 4 8\n" + "3 4 3\n";
        testLogic("19");
    }

    private static void test2() {
        str = "3 3\n" + "1 2 1\n" + "1 2 2\n" + "2 3 1\n";
        testLogic("3");
    }

    private static void test3() {
        str = "2 0\n";
        testLogic("Oops! I did it again");
    }

    private static void test4() {
        str = "10 20\n" + "9 10 4\n" + "2 2 4\n" + "4 2 8\n" + "10 5 3\n" + "1 10 6\n" + "7 4 2\n" + "10 10 6\n" +
                "3 7 4\n" + "8 9 4\n" + "8 10 7\n" + "6 10 10\n" + "2 8 8\n" + "3 8 1\n" + "3 10 3\n" + "9 5 8\n" +
                "10 10 2\n" + "1 8 1\n" + "10 1 5\n" + "3 6 10\n" + "9 10 8\n";
        testLogic("69");
    }

    private static void testLogic(String expected) {
        setUp(str);
        ExpensiveNet.main(null);
        validate(expected);
    }
}
