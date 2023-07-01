package test.sprint2.task10;

import sprint2.task10.LinkListQueueApplication;
import test.AbstractCaseTest;

public class LinkListQueueTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "10\n" +
                "put -34\n" +
                "put -23\n" +
                "get\n" +
                "size\n" +
                "get\n" +
                "size\n" +
                "get\n" +
                "get\n" +
                "put 80\n" +
                "size\n";
        testLogic("-34\n" + "1\n" + "-23\n" + "0\n" + "error\n" + "error\n" + "1\n");
    }

    private static void test2() {
        str = "6\n" + "put -66\n" + "put 98\n" + "size\n" + "size\n" + "get\n" + "get\n";
        testLogic("2\n" + "2\n" + "-66\n" + "98\n");
    }

    private static void test3() {
        str = "9\n" +
                "get\n" +
                "size\n" +
                "put 74\n" +
                "get\n" +
                "size\n" +
                "put 90\n" +
                "size\n" +
                "size\n" +
                "size\n";
        testLogic("error\n" + "0\n" + "74\n" + "0\n" + "1\n" + "1\n" + "1\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        LinkListQueueApplication.main(null);
        validate(expected);
    }
}
