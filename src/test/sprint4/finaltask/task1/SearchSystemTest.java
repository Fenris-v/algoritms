package test.sprint4.finaltask.task1;

import sprint4.finaltask.task1.SearchSystem;
import test.AbstractCaseTest;

public class SearchSystemTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "3\n" +
                "i love coffee\n" +
                "coffee with milk and sugar\n" +
                "free tea for everyone\n" +
                "3\n" +
                "i like black coffee without milk\n" +
                "everyone loves new year\n" +
                "mary likes black coffee without milk\n";
        testLogic("1 2\n" + "3\n" + "2 1\n");
    }

    private static void test2() {
        str = "6\n" +
                "buy flat in moscow\n" +
                "rent flat in moscow\n" +
                "sell flat in moscow\n" +
                "want flat in moscow like crazy\n" +
                "clean flat in moscow on weekends\n" +
                "renovate flat in moscow\n" +
                "1\n" +
                "flat in moscow for crazy weekends\n";
        testLogic("4 5 1 2 3\n");
    }

    private static void test3() {
        str = "3\n" +
                "i like dfs and bfs\n" +
                "i like dfs dfs\n" +
                "i like bfs with bfs and bfs\n" +
                "1\n" +
                "dfs dfs dfs dfs bfs\n";
        testLogic("3 1 2\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        SearchSystem.main(null);
        validate(expected);
    }
}
