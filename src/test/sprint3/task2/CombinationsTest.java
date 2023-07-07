package test.sprint3.task2;

import sprint3.task2.Combinations;
import test.AbstractCaseTest;

public class CombinationsTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "23";
        testLogic("ad ae af bd be bf cd ce cf");
    }

    private static void test2() {
        str = "92";
        testLogic("wa wb wc xa xb xc ya yb yc za zb zc");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Combinations.main(null);
        validate(expected);
    }
}
