package test.sprint2.task7;

import sprint2.task7.StackMaxEffectiveApplication;
import test.AbstractCaseTest;

public class StackMaxEffectiveTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "10\n" +
                "pop\n" +
                "pop\n" +
                "push 4\n" +
                "push -5\n" +
                "push 7\n" +
                "pop\n" +
                "pop\n" +
                "get_max\n" +
                "pop\n" +
                "get_max\n";
        testLogic("error\n" + "error\n" + "4\n" + "None\n");
    }

    private static void test2() {
        str = "10\n" +
                "get_max\n" +
                "push -6\n" +
                "pop\n" +
                "pop\n" +
                "get_max\n" +
                "push 2\n" +
                "get_max\n" +
                "pop\n" +
                "push -2\n" +
                "push -6\n";
        testLogic("None\n" + "error\n" + "None\n" + "2\n");
    }

    private static void test3() {
        str = "31\n" +
                "get_max\n" +
                "push -7\n" +
                "pop\n" +
                "get_max\n" +
                "pop\n" +
                "push 2\n" +
                "get_max\n" +
                "pop\n" +
                "get_max\n" +
                "push 7\n" +
                "push -5\n" +
                "pop\n" +
                "push -6\n" +
                "pop\n" +
                "get_max\n" +
                "pop\n" +
                "get_max\n" +
                "get_max\n" +
                "pop\n" +
                "push -4\n" +
                "push 10\n" +
                "push -8\n" +
                "push -6\n" +
                "push -10\n" +
                "push 0\n" +
                "pop\n" +
                "push 7\n" +
                "get_max\n" +
                "push 3\n" +
                "push -10\n" +
                "get_max\n";
        testLogic("None\n" +
                          "None\n" +
                          "error\n" +
                          "2\n" +
                          "None\n" +
                          "7\n" +
                          "None\n" +
                          "None\n" +
                          "error\n" +
                          "10\n" +
                          "10\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        StackMaxEffectiveApplication.main(null);
        validate(expected);
    }
}
