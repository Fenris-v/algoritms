package sprint4.task8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// Жители Алгосского архипелага придумали новый способ сравнения строк. Две строки считаются равными, если символы
// одной из них можно заменить на символы другой так, что первая строка станет точной копией второй строки. При этом
// необходимо соблюдение двух условий:
// Порядок вхождения символов должен быть сохранён.
// Одинаковым символам первой строки должны соответствовать одинаковые символы второй строки. Разным символам —– разные.
// Например, если строка s = «abacaba», то ей будет равна строка t = «xhxixhx», так как все вхождения «a» заменены на
// «x», «b» –— на «h», а «c» –— на «i». Если же первая строка s=«abc», а вторая t=«aaa», то строки уже не будут равны,
// так как разные буквы первой строки соответствуют одинаковым буквам второй.
//
// Формат ввода
// В первой строке записана строка s, во второй –— строка t. Длины обеих строк не превосходят 106. Обе строки
// содержат хотя бы по одному символу и состоят только из маленьких латинских букв.
// Строки могут быть разной длины.
//
// Формат вывода
// Выведите «YES», если строки равны (согласно вышеописанным правилам), и «NO» в ином случае.
public class StrangeComparison {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String str1 = reader.readLine();
            String str2 = reader.readLine();
            boolean isEqual = isEqual(str1, str2);
            writer.write(isEqual ? YES : NO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isEqual(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char c1;
        char c2;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            c1 = str1.charAt(i);
            c2 = str2.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            } else if (!map.containsKey(c1) && map.containsValue(c2)) {
                return false;
            } else {
                map.put(c1, c2);
            }
        }

        return true;
    }
}
