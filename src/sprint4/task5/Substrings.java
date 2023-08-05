package sprint4.task5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// На вход подается строка. Нужно определить длину наибольшей подстроки, которая не содержит повторяющиеся символы.
//
// Формат ввода
// Одна строка, состоящая из строчных латинских букв. Длина строки не превосходит 10 000.
//
// Формат вывода
// Выведите натуральное число — ответ на задачу.
public class Substrings {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String str = reader.readLine();
            int maxSubstrLength = getMaxSubstrLength(str.getBytes());
            writer.write(maxSubstrLength + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getMaxSubstrLength(byte[] chars) {
        int minIndex = 0;
        int maxLength = 0;
        int currentLength;
        Map<Byte, Integer> charMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (charMap.containsKey(chars[i])) {
                maxLength = Math.max(maxLength, i - minIndex);
                while (minIndex < charMap.get(chars[i])) {
                    charMap.remove(chars[minIndex++]);
                }

                minIndex = charMap.get(chars[i]) + 1;
                currentLength = i - charMap.get(chars[i]);
                maxLength = Math.max(maxLength, currentLength);
                charMap.replace(chars[i], i);
            } else {
                charMap.put(chars[i], i);
            }
        }

        return Math.max(maxLength, chars.length - minIndex);
    }
}
