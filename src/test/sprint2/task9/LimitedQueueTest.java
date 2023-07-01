package test.sprint2.task9;

import sprint2.task9.LimitedQueue;
import test.AbstractCaseTest;

public class LimitedQueueTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "8\n" +
                "2\n" +
                "peek\n" +
                "push 5\n" +
                "push 2\n" +
                "peek\n" +
                "size\n" +
                "size\n" +
                "push 1\n" +
                "size\n";
        testLogic("None\n" + "5\n" + "2\n" + "2\n" + "error\n" + "2\n");
    }

    private static void test2() {
        str = "10\n" +
                "1\n" +
                "push 1\n" +
                "size\n" +
                "push 3\n" +
                "size\n" +
                "push 1\n" +
                "pop\n" +
                "push 1\n" +
                "pop\n" +
                "push 3\n" +
                "push 3\n";
        testLogic("1\n" + "error\n" + "1\n" + "error\n" + "1\n" + "1\n" + "error\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        LimitedQueue.main(null);
        validate(expected);
    }
}
