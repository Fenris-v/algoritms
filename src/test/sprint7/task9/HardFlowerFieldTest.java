package test.sprint7.task9;

import sprint7.task9.HardFlowerField;
import test.AbstractCaseTest;

public class HardFlowerFieldTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "2 3\n" + "101\n" + "110\n";
        testLogic("3\n" + "URR");
    }

    private static void test2() {
        str = "3 3\n" + "100\n" + "110\n" + "001\n";
        testLogic("2\n" + "UURR");
    }

    private static void test3() {
        str = "5 5\n" + "00101\n" + "00110\n" + "11010\n" + "11001\n" + "01010\n";
        testLogic("6\n" + "UURURURR");
    }

    private static void testLogic(String expected) {
        setUp(str);
        HardFlowerField.main(null);
        validate(expected);
    }
}
