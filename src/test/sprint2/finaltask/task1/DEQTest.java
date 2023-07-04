package test.sprint2.finaltask.task1;

import sprint2.finaltask.task1.Solution;
import test.AbstractCaseTest;

public class DEQTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "4\n" + "4\n" + "push_front 861\n" + "push_front -819\n" + "pop_back\n" + "pop_back\n";
        testLogic("861\n" + "-819\n");
    }


    private static void test2() {
        str = "7\n" +
                "10\n" +
                "push_front -855\n" +
                "push_front 0\n" +
                "pop_back\n" +
                "pop_back\n" +
                "push_back 844\n" +
                "pop_back\n" +
                "push_back 823\n";
        testLogic("-855\n" + "0\n" + "844\n");
    }


    private static void test3() {
        str = "6\n" +
                "6\n" +
                "push_front -201\n" +
                "push_back 959\n" +
                "push_back 102\n" +
                "push_front 20\n" +
                "pop_front\n" +
                "pop_back\n";
        testLogic("20\n" + "102\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Solution.main(null);
        validate(expected);
    }
}
