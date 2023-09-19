package test.sprint7.task2;

import sprint7.task2.Schedule;
import test.AbstractCaseTest;

public class ScheduleTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "5\n" + "9 10\n" + "9.3 10.3\n" + "10 11\n" + "10.3 11.3\n" + "11 12\n";
        testLogic("3\n" + "9 10\n" + "10 11\n" + "11 12\n");
    }

    private static void test2() {
        str = "3\n" + "9 10\n" + "11 12.25\n" + "12.15 13.3\n";
        testLogic("2\n" + "9 10\n" + "11 12.25\n");
    }

    private static void test3() {
        str = "7\n" + "19 19\n" + "7 14\n" + "12 14\n" + "8 22\n" + "22 23\n" + "5 21\n" + "9 23\n";
        testLogic("3\n" + "7 14\n" + "19 19\n" + "22 23\n");
    }

    private static void test4() {
        str = "59\n" + "15 22\n" + "17 20\n" + "12 13\n" + "21 23\n" + "15 15\n" + "3 23\n" + "20 23\n" + "7 18\n" +
                "11 13\n" + "2 16\n" + "7 19\n" + "1 10\n" + "16 23\n" + "15 17\n" + "15 19\n" + "12 14\n" + "8 9\n" +
                "8 17\n" + "19 23\n" + "12 15\n" + "3 10\n" + "3 8\n" + "17 20\n" + "20 21\n" + "0 0\n" + "17 21\n" +
                "13 17\n" + "2 23\n" + "20 20\n" + "18 19\n" + "9 10\n" + "7 10\n" + "23 23\n" + "22 22\n" + "8 10\n" +
                "4 9\n" + "21 21\n" + "18 22\n" + "14 19\n" + "19 20\n" + "22 23\n" + "12 22\n" + "3 9\n" + "15 23\n" +
                "2 21\n" + "8 8\n" + "10 15\n" + "13 13\n" + "0 7\n" + "11 19\n" + "0 22\n" + "2 6\n" + "15 16\n" +
                "5 8\n" + "20 23\n" + "18 23\n" + "11 22\n" + "17 20\n" + "12 14\n";
        testLogic("17\n" + "0 0\n" + "2 6\n" + "8 8\n" + "8 9\n" + "9 10\n" + "11 13\n" + "13 13\n" + "15 15\n" +
                          "15 16\n" + "18 19\n" + "19 20\n" + "20 20\n" + "20 21\n" + "21 21\n" + "22 22\n" +
                          "22 23\n" + "23 23\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Schedule.main(null);
        validate(expected);
    }
}
