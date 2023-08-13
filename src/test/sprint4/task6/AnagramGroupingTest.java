package test.sprint4.task6;

import sprint4.task6.AnagramGrouping;
import test.AbstractCaseTest;

public class AnagramGroupingTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        str = "6\n" + "tan eat tea ate nat bat";
        testLogic("0 4\n" + "1 2 3\n" + "5\n");
    }

    private static void test2() {
        str = "96\n" + // boubpctay taqisdegw
                "qkxjwwgvb phvcteymy boubpctay dgeqvkqkg coiuoqrfx umuvewrhe pudjfbcjs dqxmwmqad gngggvpin kydbjfsax taqisdegw pexcmsvol xugydukrs ukflpqchx porkxaosi flqztcjcq kcobyytkd buhklnawe wtsydwrpk hghsajqru yrfcwmlks ijzrgrdev kfopjafmr vpabzpyue ikxarjiuf feeqsomhh olirhzbnu icgyukoec qzovuzcjx ebfvtlknj rfacyswir cyqmmffge fkdptfipl utqfqpqou bmfwmjlui dvosqocgw kgnsvwnnf mxbxikhxk upzcvbmdu wacvwplxi xwqdotjhh ahnbtkymz nxocfyixp krmanpgxw rwetebrna yizcnuqro qtstucrjj cmbqkojba iijlxcfhu uueiteedy avnecmryp yheexwubb soswzlwqu geuijqyaa njmhwrhoz jbmdpgyzg pqvlrmztu kkafldrag bffqlqfbu ydnqnwcks tfvfudgwk xjmrvrxql vdrigelpq dqvapdvbk tzqwpexcj lvkjnozyu rguxnuyzq aygoipsyp yikdgajbo lwjaqwhvg nzhrmmocy xsndkqyxq anuquhopo fqoevkaao fxekfnlhf mrxsjudcj rqrnvazrb kzshthoki katwqhxxa zurwplxve pibxwfaqp jbzhfrwbb gddkedbdb fzpjxpzoe nrfcnhnqg rvmjceqav kuyktakad kfotbknoa mzvpdxbnh deuyntynj yefbwjfxm kgcfqkdlx vphfpzget azzhxcaqq ldllognfv kkterexpu";
        testLogic("0\n" + "1\n" + "2\n" + "3\n" + "4\n" + "5\n" + "6\n" + "7\n" + "8\n" + "9\n" + "10\n" + "11\n" +
                          "12\n" + "13\n" + "14\n" + "15\n" + "16\n" + "17\n" + "18\n" + "19\n" + "20\n" + "21\n" +
                          "22\n" + "23\n" + "24\n" + "25\n" + "26\n" + "27\n" + "28\n" + "29\n" + "30\n" + "31\n" +
                          "32\n" + "33\n" + "34\n" + "35\n" + "36\n" + "37\n" + "38\n" + "39\n" + "40\n" + "41\n" +
                          "42\n" + "43\n" + "44\n" + "45\n" + "46\n" + "47\n" + "48\n" + "49\n" + "50\n" + "51\n" +
                          "52\n" + "53\n" + "54\n" + "55\n" + "56\n" + "57\n" + "58\n" + "59\n" + "60\n" + "61\n" +
                          "62\n" + "63\n" + "64\n" + "65\n" + "66\n" + "67\n" + "68\n" + "69\n" + "70\n" + "71\n" +
                          "72\n" + "73\n" + "74\n" + "75\n" + "76\n" + "77\n" + "78\n" + "79\n" + "80\n" + "81\n" +
                          "82\n" + "83\n" + "84\n" + "85\n" + "86\n" + "87\n" + "88\n" + "89\n" + "90\n" + "91\n" +
                          "92\n" + "93\n" + "94\n" + "95\n");
    }

    private static void test3() {
        str = "117\n" +
                "uz zx mc fi vj az uw ky fz jk yp wc tp av ga yq vo ct yy lr ux uy fe le xu ss xg pj gg rv yi ly mm sh nc ae ak at db sn co no is nz dk bh hy uc tf vn gh nn mq bp nt dg sq yv mw gx as lf lg ju rb bl ud vz rd fe gt ha zj vu kg cn jl vw zu zu uz zu zu uz uz zu uz zu zu uz uz uz uz zu uz zu uz uz zu uz zu uz zu zu uz zu zu zu zu zu zu zu zu zu zu uz zu";
        testLogic(
                "0 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116\n" +
                        "1\n" + "2\n" + "3\n" + "4\n" + "5\n" + "6\n" + "7\n" + "8\n" + "9\n" + "10\n" + "11\n" +
                        "12\n" + "13\n" + "14\n" + "15\n" + "16\n" + "17\n" + "18\n" + "19\n" + "20 24\n" + "21\n" +
                        "22 69\n" + "23\n" + "25\n" + "26 59\n" + "27\n" + "28\n" + "29\n" + "30\n" + "31\n" + "32\n" +
                        "33\n" + "34 75\n" + "35\n" + "36\n" + "37\n" + "38\n" + "39\n" + "40\n" + "41\n" + "42\n" +
                        "43\n" + "44\n" + "45\n" + "46\n" + "47\n" + "48\n" + "49\n" + "50\n" + "51\n" + "52\n" +
                        "53\n" + "54\n" + "55\n" + "56\n" + "57\n" + "58\n" + "60\n" + "61\n" + "62\n" + "63\n" +
                        "64\n" + "65\n" + "66\n" + "67\n" + "68\n" + "70\n" + "71\n" + "72\n" + "73\n" + "74\n" +
                        "76\n" + "77\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        AnagramGrouping.main(null);
        validate(expected);
    }
}
