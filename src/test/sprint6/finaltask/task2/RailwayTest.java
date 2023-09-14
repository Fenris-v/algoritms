package test.sprint6.finaltask.task2;

import sprint6.finaltask.task2.Railway;
import test.AbstractCaseTest;

public class RailwayTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "3\n" + "RB\n" + "R\n";
        testLogic("NO");
    }

    private static void test2() {
        str = "4\n" + "BBB\n" + "RB\n" + "B\n";
        testLogic("YES");
    }

    private static void test3() {
        str = "5\n" + "RRRB\n" + "BRR\n" + "BR\n" + "R\n";
        testLogic("NO");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Railway.main(null);
        validate(expected);
    }
}
