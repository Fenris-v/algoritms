package test.sprint4.finaltask.task2;

import sprint4.finaltask.task2.HashTableSolution;
import test.AbstractCaseTest;

public class HashTableTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "10\n" +
                "get 1\n" +
                "put 1 10\n" +
                "put 2 4\n" +
                "get 1\n" +
                "get 2\n" +
                "delete 2\n" +
                "get 2\n" +
                "put 1 5\n" +
                "get 1\n" +
                "delete 2\n";
        testLogic("None\n" + "10\n" + "4\n" + "4\n" + "None\n" + "5\n" + "None\n");
    }

    private static void test2() {
        str = "8\n" +
                "get 9\n" +
                "delete 9\n" +
                "put 9 1\n" +
                "get 9\n" +
                "put 9 2\n" +
                "get 9\n" +
                "put 9 3\n" +
                "get 9\n";
        testLogic("None\n" + "None\n" + "1\n" + "2\n" + "3\n");
    }

    private static void test3() {
        str = "15\n" +
                "get 31\n" +
                "get -34\n" +
                "get 24\n" +
                "delete 11\n" +
                "delete 36\n" +
                "delete 21\n" +
                "get 29\n" +
                "get -30\n" +
                "put -7 6\n" +
                "put -7 -26\n" +
                "put -7 6\n" +
                "get -7\n" +
                "get -7\n" +
                "get -7\n" +
                "get -7\n";
        testLogic("None\n" +
                          "None\n" +
                          "None\n" +
                          "None\n" +
                          "None\n" +
                          "None\n" +
                          "None\n" +
                          "None\n" +
                          "6\n" +
                          "6\n" +
                          "6\n" +
                          "6\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        HashTableSolution.main(null);
        validate(expected);
    }
}
