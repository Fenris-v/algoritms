package test.sprint2.task8;

import sprint2.task8.BracketSequence;
import test.AbstractCaseTest;

public class BracketSequenceTest extends AbstractCaseTest {
    private static final String TRUE = "True";
    private static final String FALSE = "False";

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "";
        testLogic(TRUE);
    }

    private static void test2() {
        str = "{[()]}";
        testLogic(TRUE);
    }

    private static void test3() {
        str = "()";
        testLogic(TRUE);
    }

    private static void test4() {
        str = "[{[()]}";
        testLogic(FALSE);
    }

    private static void testLogic(String expected) {
        setUp(str);
        BracketSequence.main(null);
        validate(expected);
    }
}
