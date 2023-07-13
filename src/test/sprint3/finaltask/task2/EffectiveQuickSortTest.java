package test.sprint3.finaltask.task2;

import sprint3.finaltask.task2.EffectiveQuickSort;
import test.AbstractCaseTest;

public class EffectiveQuickSortTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        str = "5\n" + "alla 4 100\n" + "gena 6 1000\n" + "gosha 2 90\n" + "rita 2 90\n" + "timofey 4 80";
        testLogic("gena\n" + "timofey\n" + "alla\n" + "gosha\n" + "rita\n");
    }

    private static void test2() {
        str = "5\n" + "alla 0 0\n" + "gena 0 0\n" + "gosha 0 0\n" + "rita 0 0\n" + "timofey 0 0";
        testLogic("alla\n" + "gena\n" + "gosha\n" + "rita\n" + "timofey\n");
    }

    private static void test3() {
        str = "13\n" +
                "tufhdbi 76 58\n" +
                "rqyoazgbmv 59 78\n" +
                "qvgtrlkmyrm 35 27\n" +
                "tgcytmfpj 70 27\n" +
                "xvf 84 19\n" +
                "jzpnpgpcqbsmczrgvsu 30 3\n" +
                "evjphqnevjqakze 92 15\n" +
                "wwzwv 87 8\n" +
                "tfpiqpwmkkduhcupp 1 82\n" +
                "tzamkyqadmybky 5 81\n" +
                "amotrxgba 0 6\n" +
                "easfsifbzkfezn 100 28\n" +
                "kivdiy 70 47\n" +
                "Просто тест";
        testLogic("easfsifbzkfezn\n" +
                          "evjphqnevjqakze\n" +
                          "wwzwv\n" +
                          "xvf\n" +
                          "tufhdbi\n" +
                          "tgcytmfpj\n" +
                          "kivdiy\n" +
                          "rqyoazgbmv\n" +
                          "qvgtrlkmyrm\n" +
                          "jzpnpgpcqbsmczrgvsu\n" +
                          "tzamkyqadmybky\n" +
                          "tfpiqpwmkkduhcupp\n" +
                          "amotrxgba\n");
    }

    private static void test4() {
        str = "5\n" +
                "alla 0 10\n" +
                "gena 0 9\n" +
                "gosha 0 8\n" +
                "rita 0 7\n" +
                "timofey 0 0\n" +
                "Сортировка по штрафу";
        testLogic("timofey\n" + "rita\n" + "gosha\n" + "gena\n" + "alla\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        EffectiveQuickSort.main(null);
        validate(expected);
    }
}
