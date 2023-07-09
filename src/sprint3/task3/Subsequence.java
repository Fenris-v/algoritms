package sprint3.task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Гоша любит играть в игру «Подпоследовательность»: даны 2 строки, и нужно понять, является ли первая из них
// подпоследовательностью второй. Когда строки достаточно длинные, очень трудно получить ответ на этот вопрос, просто
// посмотрев на них. Помогите Гоше написать функцию, которая решает эту задачу.
//
// Формат ввода
// В первой строке записана строка s.
// Во второй — строка t.
// Обе строки состоят из маленьких латинских букв, длины строк не превосходят 150000. Строки не могут быть пустыми.
//
// Формат вывода
// Выведите True, если s является подпоследовательностью t, иначе — False.
public class Subsequence {
    private static final String TRUE = "True";
    private static final String FALSE = "False";

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String subsequence = reader.readLine();
            String sequence = reader.readLine();
            boolean isSubsequence = isSubsequence(sequence, subsequence);
            writer.write(isSubsequence ? TRUE : FALSE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isSubsequence(String sequence, String subsequence) {
        int index = 0;
        for (int i = 0; i < subsequence.length(); i++) {
            if (index == sequence.length()) {
                return false;
            }

            while (sequence.charAt(index) != subsequence.charAt(i)) {
                index++;
                if (index == sequence.length()) {
                    return false;
                }
            }

            index++;
        }

        return true;
    }
}
