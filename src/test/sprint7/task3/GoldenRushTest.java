package test.sprint7.task3;

import sprint7.task3.GoldenRush;
import test.AbstractCaseTest;

public class GoldenRushTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "10\n" + "3\n" + "8 1\n" + "2 10\n" + "4 5\n";
        testLogic("36");
    }

    private static void test2() {
        str = "10000\n" + "1\n" + "4 20\n";
        testLogic("80");
    }

    private static void test3() {
        str = "226\n" + "10\n" + "16 17\n" + "16 3\n" + "25 20\n" + "11 34\n" + "26 31\n" + "7 39\n" + "21 34\n" +
                "19 21\n" + "1 26\n" + "29 33\n";
        testLogic("4301");
    }

    private static void testLogic(String expected) {
        setUp(str);
        GoldenRush.main(null);
        validate(expected);
    }
}
