package test.sprint6.task1;

import sprint6.task1.GraphBuilder;
import test.AbstractCaseTest;

public class GraphBuilderTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        str = "5 3\n" + "1 3\n" + "2 3\n" + "5 2\n";
        testLogic("1 3\n" + "1 3\n" + "0\n" + "0\n" + "1 2\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        GraphBuilder.main(null);
        validate(expected);
    }
}
