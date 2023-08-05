package test.sprint4.task4;

import sprint4.task4.Sections2;
import test.AbstractCaseTest;

public class SectionsTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        str = "8\n" +
                "вышивание крестиком\n" +
                "рисование мелками на парте\n" +
                "настольный керлинг\n" +
                "настольный керлинг\n" +
                "кухня африканского племени ужасмай\n" +
                "тяжелая атлетика\n" +
                "таракановедение\n" +
                "таракановедение\n";
        testLogic("вышивание крестиком\n" +
                          "рисование мелками на парте\n" +
                          "настольный керлинг\n" +
                          "кухня африканского племени ужасмай\n" +
                          "тяжелая атлетика\n" +
                          "таракановедение\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Sections2.main(null);
        validate(expected);
    }
}
