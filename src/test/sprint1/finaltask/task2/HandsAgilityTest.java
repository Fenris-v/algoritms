package test.sprint1.finaltask.task2;

import sprint1.finaltask.task2.HandsAgility;
import test.AbstractCaseTest;

public class HandsAgilityTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "3\n" +
                "1231\n" +
                "2..2\n" +
                "2..2\n" +
                "2..2";
        testLogic("2");
    }

    private static void test2() {
        str = "4\n" +
                "1111\n" +
                "9999\n" +
                "1111\n" +
                "9911";
        testLogic("1");
    }

    private static void test3() {
        str = "4\n" +
                "1111\n" +
                "1111\n" +
                "1111\n" +
                "1111";
        testLogic("0");
    }

    private static void testLogic(String expected) {
        setUp(str);
        HandsAgility.main(null);
        validate(expected);
    }
}
