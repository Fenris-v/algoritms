package test.sprint2.task6;

import sprint2.task6.StackMaxApplication;
import test.AbstractCaseTest;

public class StackMaxTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "8\n" +
                "get_max\n" +
                "push 7\n" +
                "pop\n" +
                "push -2\n" +
                "push -1\n" +
                "pop\n" +
                "get_max\n" +
                "get_max\n";
        testLogic("None\n" + "-2\n" + "-2\n");
    }

    private static void test2() {
        str = "7\n" + "get_max\n" + "pop\n" + "pop\n" + "pop\n" + "push 10\n" + "get_max\n" + "push -9\n";
        testLogic("None\n" + "error\n" + "error\n" + "error\n" + "10\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        StackMaxApplication.main(null);
        validate(expected);
    }
}
