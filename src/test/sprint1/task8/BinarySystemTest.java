package test.sprint1.task8;

import sprint1.task8.BinarySystem;
import test.AbstractCaseTest;

public class BinarySystemTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static void test1() {
        str = "1010\n" + "1011\n";
        testLogic("10101");
    }

    private static void test2() {
        str = "1\n" + "1\n";
        testLogic("10");
    }

    private static void test3() {
        str = "10\n" + "0\n";
        testLogic("10");
    }

    private static void test4() {
        str = "100\n" + "100\n";
        testLogic("1000");
    }

    private static void test5() {
        str = "101\n" + "1\n";
        testLogic("110");
    }

    private static void test6() {
        str = "101111\n" + "0\n";
        testLogic("101111");
    }

    private static void testLogic(String expected) {
        setUp(str);
        BinarySystem.main(null);
        validate(expected);
    }
}
