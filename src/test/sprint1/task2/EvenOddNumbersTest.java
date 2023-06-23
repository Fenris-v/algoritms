package test.sprint1.task2;

import sprint1.task2.EvenOddNumbers;
import test.AbstractCaseTest;

import java.util.Arrays;
import java.util.stream.Collectors;

import static sprint1.task2.EvenOddNumbers.FAIL;
import static sprint1.task2.EvenOddNumbers.WIN;

public class EvenOddNumbersTest extends AbstractCaseTest {
    private static int[] numbers;

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
    }

    private static void test1() {
        numbers = new int[]{1, 3, 5};
        testLogic(WIN);
    }

    private static void test2() {
        numbers = new int[]{1, 1, 1};
        testLogic(WIN);
    }

    private static void test3() {
        numbers = new int[]{2, 28, 60};
        testLogic(WIN);
    }

    private static void test4() {
        numbers = new int[]{2, 15, 60};
        testLogic(FAIL);
    }

    private static void test5() {
        numbers = new int[]{0, 15, 60};
        testLogic(FAIL);
    }

    private static void test6() {
        numbers = new int[]{0, 10, 60};
        testLogic(WIN);
    }

    private static void test7() {
        numbers = new int[]{2, 2, 2};
        testLogic(WIN);
    }

    private static void test8() {
        numbers = new int[]{-80, 25, 30};
        testLogic(FAIL);
    }

    private static void test9() {
        numbers = new int[]{-80, -24, 30};
        testLogic(WIN);
    }

    private static void testLogic(String expected) {
        String str = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(" "));

        setUp(str);
        EvenOddNumbers.main(null);
        write(expected);
    }
}
