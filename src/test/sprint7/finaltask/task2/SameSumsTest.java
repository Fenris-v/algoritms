package test.sprint7.finaltask.task2;

import sprint7.finaltask.task2.SameSums;
import test.AbstractCaseTest;

public class SameSumsTest extends AbstractCaseTest {
    private static final String TRUE = "True";
    private static final String FALSE = "False";

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "4\n" + "1 5 7 1\n";
        testLogic(TRUE);
    }

    private static void test2() {
        str = "3\n" + "2 10 9\n";
        testLogic(FALSE);
    }

    private static void test3() {
        str = "6\n" + "1 5 7 1 1 1\n";
        testLogic(TRUE);
    }

    private static void test4() {
        str = "1\n" + "4\n";
        testLogic(FALSE);
    }

    private static void testLogic(String expected) {
        setUp(str);
        SameSums.main(null);
        validate(expected);
    }
}
