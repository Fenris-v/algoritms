package test.sprint1.task9;

import sprint1.task9.PowerOfFour;
import test.AbstractCaseTest;

public class PowerOfFourTest extends AbstractCaseTest {
    private static String str;
    private static final String TRUE = "True";
    private static final String False = "False";

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test1() {
        str = "16";
        testLogic(TRUE);
    }

    private static void test2() {
        str = "15";
        testLogic(False);
    }

    private static void test3() {
        str = "0";
        testLogic(False);
    }

    private static void test4() {
        str = "4";
        testLogic(TRUE);
    }

    private static void test5() {
        str = "256";
        testLogic(TRUE);
    }

    private static void testLogic(String expected) {
        setUp(str);
        PowerOfFour.main(null);
        validate(expected);
    }
}
