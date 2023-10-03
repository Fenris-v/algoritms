package test.sprint7.finaltask.task1;

import sprint7.finaltask.task1.LevenshteinDistance;
import test.AbstractCaseTest;

public class LevenshteinDistanceTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "abacaba\n" + "abaabc\n";
        testLogic("2");
    }

    private static void test2() {
        str = "innokentiy\n" + "innnokkentia\n";
        testLogic("3");
    }

    private static void test3() {
        str = "r\n" + "x\n";
        testLogic("1");
    }

    private static void testLogic(String expected) {
        setUp(str);
        LevenshteinDistance.main(null);
        validate(expected);
    }
}
