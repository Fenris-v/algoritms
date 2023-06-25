package test.sprint1.task7;

import sprint1.task7.WorkFromHome;
import test.AbstractCaseTest;

public class WorkFromHomeTest extends AbstractCaseTest {
    private static String str;

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "5";
        testLogic("101");
    }

    private static void test2() {
        str = "14";
        testLogic("1110");
    }

    private static void testLogic(String expected) {
        setUp(str);
        WorkFromHome.main(null);
        write(expected);
    }
}
