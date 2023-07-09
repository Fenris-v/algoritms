package test.sprint3.task3;

import sprint3.task3.Subsequence;
import test.AbstractCaseTest;

public class SubsequenceTest extends AbstractCaseTest {
    private static final String TRUE = "True";
    private static final String FALSE = "False";

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "abc\n" + "ahbgdcu\n";
        testLogic(TRUE);
    }

    private static void test2() {
        str = "abcp\n" + "ahpc\n";
        testLogic(FALSE);
    }

    private static void test3() {
        str = "abcp\n" + "abcp\n";
        testLogic(TRUE);
    }

    private static void test4() {
        str = "acp\n" + "abcp\n";
        testLogic(TRUE);
    }

    private static void testLogic(String expected) {
        setUp(str);
        Subsequence.main(null);
        validate(expected);
    }
}
