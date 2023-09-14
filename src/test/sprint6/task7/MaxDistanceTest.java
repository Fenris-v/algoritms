package test.sprint6.task7;

import sprint6.task7.MaxDistance;
import test.AbstractCaseTest;

public class MaxDistanceTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "5 4\n" + "2 1\n" + "4 5\n" + "4 3\n" + "3 2\n" + "2\n";
        testLogic("3");
    }

    private static void test2() {
        str = "3 3\n" + "3 1\n" + "1 2\n" + "2 3\n" + "1\n";
        testLogic("1");
    }

    private static void test3() {
        str = "6 8\n" + "6 1\n" + "1 3\n" + "5 1\n" + "3 5\n" + "3 4\n" + "6 5\n" + "5 2\n" + "6 2\n" + "4\n";
        testLogic("3");
    }

    private static void testLogic(String expected) {
        setUp(str);
        MaxDistance.main(null);
        validate(expected);
    }
}
