package test.sprint4.task5;

import sprint4.task5.Substrings;
import test.AbstractCaseTest;

public class SubstringsTest extends AbstractCaseTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }

    private static void test1() {
        str = "abcabcbb\n";
        testLogic("3\n");
    }

    private static void test2() {
        str = "bbbbb\n";
        testLogic("1\n");
    }

    private static void test3() {
        str = "pwwkew\n";
        testLogic("3\n");
    }

    private static void test4() {
        str = "ojodx\n";
        testLogic("4\n");
    }

    private static void test5() {
        str = "mtwpyqlnlo\n";
        testLogic("8\n");
    }

    private static void test6() {
        str =
                "vdoejgvnubksokvsjlxtqqptanegzlzxbzckzrczhjvxybfgkkbdbqzaiceubawpkkdxisvbhzbvtklemyrdalboelmtywujlztbeehkyprhwxugzhkisqvumdiclysvdxvfcgkmvpdsjeodzzxephrlbhrnyomhbldmvhwhvtciiahdqllcqhdeumgluqjkcgcdksvpypdlvwbzsoeeqvpnaxauljtnimbzoxtzobcftclunuhogukkstqrmehpwiogkpmcijakbzgrgfbnjemkcqotguldyzafrefygakxfjqpsyhidqhfkgslbjtdljkhykybjegpnzngaaxpmloseotledyowkbxfzdbrfyccwelvatdqbqjkynnotwzujfjydvtxoskalenehehmgztlauvsnlohghswkmjegrvlnyleaecmfjbtlmbqhgnhztpgirpszqrsnsqljfxqhadaqujpzwgysxzyksmsmwbjffywsbzktxqwgkauivppgmisomniajxmwgjnfhhelbsrhmwuzkdmtahzzsvlxnbvsmmzagieriaemfjxfkipwncfzvmznnehdxgguufspidpviokmmsaywhbxkcbuvjcwnetxgmbaslkbchnmgxgzilpamyourrgpdwdeqcqioipvypmtaojbmebyfqgxkxaoaqrqybzkybhmxrcbjagamdfouaunbupctksmqjzekblegrwqtrusiqbusqabljerkahkyajwuflruxxtspeeqkqijbhppeinlsgfrotudhhtkcglxnmowyebhgsxfbwrrmhpvxvasispoljjauytpauerxirlzifofyaenoeqcrvnkihiojsxfjlmrwevfxmeukjxkpigrzxfqsnexxzokfzgviveltmdbusdvdryazfgzvhvwxucofojfkdmjdzeqchvripidnowbummaiiempkpvojenpkbtongrpscisrnhvibhdvdeueirecqvhvzbdxhrqpg\n";
        testLogic("19\n");
    }

    private static void test7() {
        str =
                "utsmdryvkywaknxvvvtpabtwpmwmndctcyeerhrkansqfyhltgoxnnhryzpfrpjgktcfvifwzmifhptkslnqrlkyvlhgbjpknkidbhbfattudrijxtznewniuhavryaqardddeoeyhkmznxopmmmwvqrjmdazxycpnebrrzpiivtlokyaxgobmfelwswkrydnhffsywbuduzakqnigbmcsttbybxqfexbltfmnneaitrqadxecdbdlogvzryirhnoajbejmqjpzkpchaftgtglmyevcxdfjyravmfxlzwjzsydorjeownjeh\n";
        testLogic("16\n");
    }

    private static void testLogic(String expected) {
        setUp(str);
        Substrings.main(null);
        validate(expected);
    }
}
