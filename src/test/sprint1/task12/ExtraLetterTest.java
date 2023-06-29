package test.sprint1.task12;

import sprint1.task12.ExtraLetter;
import test.AbstractCaseTest;

public class ExtraLetterTest extends AbstractCaseTest {
    private static String str;

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "abcd\n" + "abcde";
        testLogic("e");
    }

    private static void test2() {
        str = "go\n" + "ogg";
        testLogic("g");
    }

    private static void test3() {
        str = "xtkpx\n" + "xkctpx\n";
        testLogic("c");
    }

    private static void testLogic(String expected) {
        setUp(str);
        ExtraLetter.main(null);
        validate(expected);
    }
}
