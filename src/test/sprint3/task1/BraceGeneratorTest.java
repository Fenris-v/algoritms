package test.sprint3.task1;

import sprint3.task1.BraceGenerator;
import test.AbstractCaseTest;

public class BraceGeneratorTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "3";
        testLogic("((()))\n" +
                          "(()())\n" +
                          "(())()\n" +
                          "()(())\n" +
                          "()()()");
    }

    private static void test2() {
        str = "2";
        testLogic("(())\n" + "()()\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        BraceGenerator.main(null);
        validate(expected);
    }
}
