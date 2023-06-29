package test.sprint1.task6;

import sprint1.task6.Palindrome;
import test.AbstractCaseTest;

public class PalindromeTest extends AbstractCaseTest {
    private static String str;
    private final static String TRUE = "True";
    private final static String FALSE = "False";

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "A man, a plan, a canal: Panama";
        testLogic(TRUE);
    }

    private static void test2() {
        str = "zo";
        testLogic(FALSE);
    }

    private static void testLogic(String expected) {
        setUp(str);
        Palindrome.main(null);
        validate(expected);
    }
}
