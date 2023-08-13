package test.sprint4.task10;

import sprint4.task10.SumOfFours3;
import test.AbstractCaseTest;

public class SumOfFoursTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "8\n" + "10\n" + "2 3 2 4 1 10 3 0\n";
        testLogic("3\n" + "0 3 3 4\n" + "1 2 3 4\n" + "2 2 3 3\n");
    }

    private static void test2() {
        str = "6\n" + "0\n" + "1 0 -1 0 2 -2\n";
        testLogic("3\n" + "-2 -1 1 2\n" + "-2 0 0 2\n" + "-1 0 0 1\n");
    }

    private static void test3() {
        str = "5\n" + "4\n" + "1 1 1 1 1\n";
        testLogic("1\n" + "1 1 1 1\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        SumOfFours3.main(null);
        validate(expected);
    }
}
