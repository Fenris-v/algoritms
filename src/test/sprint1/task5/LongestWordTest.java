package test.sprint1.task5;

import sprint1.task5.LongestWord;
import test.AbstractCaseTest;

public class LongestWordTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "19\n" + "i love segment tree";
        testLogic("segment\n" + "7");
    }

    private static void test2() {
        str = "21\n" + "frog jumps from river\n";
        testLogic("jumps\n" + "5");
    }

    private static void test3() {
        str = "21\n" + "    frog   jumps from river                                               \n";
        testLogic("jumps\n" + "5");
    }

    private static void testLogic(String expected) {
        setUp(str);
        LongestWord.main(null);
        validate(expected);
    }
}
