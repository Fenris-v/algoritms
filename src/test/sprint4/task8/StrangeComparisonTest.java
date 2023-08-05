package test.sprint4.task8;

import sprint4.task8.StrangeComparison;
import test.AbstractCaseTest;

public class StrangeComparisonTest extends AbstractCaseTest {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "mxyskaoghi\n" + "qodfrgmslc\n";
        testLogic(YES);
    }

    private static void test2() {
        str = "agg\n" + "xdd\n";
        testLogic(YES);
    }

    private static void test3() {
        str = "agg\n" + "xda\n";
        testLogic(NO);
    }

    private static void test4() {
        str = "aba\n" + "xxx\n";
        testLogic(NO);
    }

    private static void testLogic(String expected) {
        setUp(str);
        StrangeComparison.main(null);
        validate(expected);
    }
}
