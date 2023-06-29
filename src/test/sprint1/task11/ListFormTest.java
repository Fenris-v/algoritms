package test.sprint1.task11;

import sprint1.task11.ListForm;
import test.AbstractCaseTest;

public class ListFormTest extends AbstractCaseTest {
    private static String str;

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "4\n" + "1 2 0 0\n" + "34\n";
        testLogic("1 2 3 4");
    }


    private static void test2() {
        str = "2\n" + "9 5\n" + "17\n";
        testLogic("1 1 2");
    }

    private static void test3() {
        str = "2\n" + "3 4\n" + "1200\n";
        testLogic("1 2 3 4");
    }

    private static void testLogic(String expected) {
        setUp(str);
        ListForm.main(null);
        validate(expected);
    }
}
