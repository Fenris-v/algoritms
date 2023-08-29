package test.sprint5.finaltask.task1;

import sprint5.finaltask.task1.Heapsort;
import test.AbstractCaseTest;

public class HeapsortTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        str = "5\n" + "alla 4 100\n" + "gena 6 1000\n" + "gosha 2 90\n" + "rita 2 90\n" + "timofey 4 80";
        testLogic("gena\n" + "timofey\n" + "alla\n" + "gosha\n" + "rita\n");
    }

    private static void test2() {
        str = "5\n" + "alla 0 0\n" + "gena 0 0\n" + "gosha 0 0\n" + "rita 0 0\n" + "timofey 0 0";
        testLogic("alla\n" + "gena\n" + "gosha\n" + "rita\n" + "timofey\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Heapsort.main(null);
        validate(expected);
    }
}
