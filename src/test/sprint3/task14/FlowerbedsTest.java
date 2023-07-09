package test.sprint3.task14;

import sprint3.task14.Flowerbeds3;
import test.AbstractCaseTest;

public class FlowerbedsTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "4\n" + "7 8\n" + "7 8\n" + "2 3\n" + "6 10\n";
        testLogic("2 3\n" + "6 10\n");
    }

    private static void test2() {
        str = "4\n" + "2 3\n" + "5 6\n" + "3 4\n" + "3 4\n";
        testLogic("2 4\n" + "5 6\n");
    }

    private static void test3() {
        str = "6\n" + "1 3\n" + "3 5\n" + "4 6\n" + "5 6\n" + "2 4\n" + "7 10\n";
        testLogic("1 6\n" + "7 10\n");
    }

    private static void test4() {
        str = "17\n" +
                "50 53\n" +
                "63 67\n" +
                "43 45\n" +
                "26 28\n" +
                "2 3\n" +
                "83 84\n" +
                "47 48\n" +
                "74 82\n" +
                "5 10\n" +
                "92 94\n" +
                "58 62\n" +
                "13 18\n" +
                "70 71\n" +
                "54 56\n" +
                "85 87\n" +
                "30 34\n" +
                "96 100\n";
        testLogic("2 3\n" +
                          "5 10\n" +
                          "13 18\n" +
                          "26 28\n" +
                          "30 34\n" +
                          "43 45\n" +
                          "47 48\n" +
                          "50 53\n" +
                          "54 56\n" +
                          "58 62\n" +
                          "63 67\n" +
                          "70 71\n" +
                          "74 82\n" +
                          "83 84\n" +
                          "85 87\n" +
                          "92 94\n" +
                          "96 100\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Flowerbeds3.main(null);
        validate(expected);
    }
}
