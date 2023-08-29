package test.sprint6.task2;

import sprint6.task2.GraphInMatrixConverter;
import test.AbstractCaseTest;

public class GraphInMatrixConverterTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        str = "5 3\n" + "1 3\n" + "2 3\n" + "5 2\n";
        testLogic("0 0 1 0 0\n" + "0 0 1 0 0\n" + "0 0 0 0 0\n" + "0 0 0 0 0\n" + "0 1 0 0 0\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        GraphInMatrixConverter.main(null);
        validate(expected);
    }
}
