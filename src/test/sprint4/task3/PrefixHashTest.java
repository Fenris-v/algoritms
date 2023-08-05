package test.sprint4.task3;

import sprint4.task3.PrefixHash2;
import test.AbstractCaseTest;

public class PrefixHashTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "1000\n" +
                "1000009\n" +
                "abcdefgh\n" +
                "7\n" +
                "1 1\n" +
                "1 5\n" +
                "2 3\n" +
                "3 4\n" +
                "4 4\n" +
                "1 8\n" +
                "5 8\n";
        testLogic("97\n" +
                "225076\n" +
                "98099\n" +
                "99100\n" +
                "100\n" +
                "436420\n" +
                "193195\n");
    }

    private static void test2() {
        str = "100\n" + "10\n" + "a\n" + "1\n" + "1 1\n";
        testLogic("7\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        PrefixHash2.main(null);
        validate(expected);
    }
}
