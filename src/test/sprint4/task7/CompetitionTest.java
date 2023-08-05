package test.sprint4.task7;

import sprint4.task7.Competition;
import test.AbstractCaseTest;

public class CompetitionTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
    }

    private static void test1() {
        str = "2\n" + "0 1\n";
        testLogic("2");
    }

    private static void test2() {
        str = "3\n" + "0 1 0\n";
        testLogic("2");
    }

    private static void test3() {
        str = "10\n" + "0 0 1 0 0 0 1 0 0 1\n";
        testLogic("4");
    }

    private static void test4() {
        str = "87\n" +
                "1 1 0 1 1 1 0 1 0 1 1 1 0 1 0 0 0 0 1 0 0 0 0 1 0 1 0 0 1 1 0 1 1 1 0 1 1 0 0 1 0 0 1 1 1 1 1 0 1 1 0 0 0 0 1 0 0 1 1 1 0 1 1 1 0 1 0 1 1 0 1 0 1 0 1 0 1 1 0 0 0 1 1 1 1 0 0\n";
        testLogic("70");
    }

    private static void test5() {
        str = "2\n" + "1 1\n";
        testLogic("0");
    }

    private static void test6() {
        str = "1\n" + "1\n";
        testLogic("0");
    }

    private static void test7() {
        str = "31\n" + "0 1 1 1 1 1 0 1 1 0 1 0 1 0 1 0 1 1 0 1 1 1 0 1 0 0 1 0 0 1 0\n";
        testLogic("22");
    }

    private static void test8() {
        str = "9\n" + "0 0 1 1 1 0 0 1 1\n";
        testLogic("8");
    }

    private static void test9() {
        str = "3\n" + "0 1 0\n";
        testLogic("2");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Competition.main(null);
        validate(expected);
    }
}
