package test.sprint3.task10;

import sprint3.task10.Bubble;
import test.AbstractCaseTest;

public class BubbleTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "5\n" + "4 3 9 2 1";
        testLogic("3 4 2 1 9\n" + "3 2 1 4 9\n" + "2 1 3 4 9\n" + "1 2 3 4 9\n");
    }

    private static void test2() {
        str = "5\n" + "12 8 9 10 11";
        testLogic("8 9 10 11 12\n");
    }

    private static void test3() {
        str = "2\n" + "4 5\n" + "Просто пример из условия";
        testLogic("4 5\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Bubble.main(null);
        validate(expected);
    }
}
