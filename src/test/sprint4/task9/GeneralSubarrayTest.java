package test.sprint4.task9;

import sprint4.task9.GeneralSubarray;
import test.AbstractCaseTest;

public class GeneralSubarrayTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "5\n" + "1 2 3 2 1\n" + "5\n" + "3 2 1 5 6\n";
        testLogic("3\n");
    }

    private static void test2() {
        str = "5\n" + "1 2 3 4 5\n" + "3\n" + "4 5 9\n";
        testLogic("2\n");
    }

    private static void test3() {
        str = "1\n" + "1\n" + "1\n" + "1\n";
        testLogic("1\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        GeneralSubarray.main(null);
        validate(expected);
    }
}
