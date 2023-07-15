package test.sprint3.task6;

import sprint3.task6.TrianglePerimeter;
import test.AbstractCaseTest;

public class TrianglePerimeterTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "4\n" + "6 3 3 2";
        testLogic("8");
    }

    private static void test2() {
        str = "6\n" + "5 3 7 2 8 3";
        testLogic("20");
    }

    private static void testLogic(String expected) {
        setUp(str);
        TrianglePerimeter.main(null);
        validate(expected);
    }
}
