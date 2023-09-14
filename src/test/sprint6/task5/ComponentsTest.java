package test.sprint6.task5;

import sprint6.task5.Components;
import test.AbstractCaseTest;

public class ComponentsTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "6 3\n" + "1 2\n" + "6 5\n" + "2 3\n";
        testLogic("3\n" + "1 2 3\n" + "4\n" + "5 6\n");
    }

    private static void test2() {
        str = "2 0\n";
        testLogic("2\n" + "1\n" + "2\n");
    }

    private static void test3() {
        str = "4 3\n" + "2 3\n" + "2 1\n" + "4 3\n";
        testLogic("1\n" + "1 2 3 4\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Components.main(null);
        validate(expected);
    }
}
