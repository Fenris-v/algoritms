package test.sprint7.task8;

import sprint7.task8.FlowerField;
import test.AbstractCaseTest;

public class FlowerFieldTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "2 3\n" + "101\n" + "110\n";
        testLogic("3");
    }

    private static void test2() {
        str = "3 3\n" + "100\n" + "110\n" + "001\n";
        testLogic("2");
    }

    private static void testLogic(String expected) {
        setUp(str);
        FlowerField.main(null);
        validate(expected);
    }
}
