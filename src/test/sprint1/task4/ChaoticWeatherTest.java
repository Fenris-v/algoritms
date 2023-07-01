package test.sprint1.task4;

import sprint1.task4.ChaoticWeather;
import test.AbstractCaseTest;

public class ChaoticWeatherTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "7\n" + "-1 -10 -8 0 2 0 5\n";
        testLogic("3");
    }

    private static void test2() {
        str = "5\n" + "1 1 1 1 1\n";
        testLogic("0");
    }

    private static void test3() {
        str = "5\n" + "1 2 5 4 8\n";
        testLogic("2");
    }

    private static void testLogic(String expected) {
        setUp(str);
        ChaoticWeather.main(null);
        validate(expected);
    }
}
