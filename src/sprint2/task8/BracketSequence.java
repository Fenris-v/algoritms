package sprint2.task8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// Вот какую задачу Тимофей предложил на собеседовании одному из кандидатов. Если вы с ней ещё не сталкивались, то
// наверняка столкнётесь –— она довольно популярная.
// Дана скобочная последовательность. Нужно определить, правильная ли она.
//
// Будем придерживаться такого определения:
// - пустая строка —– правильная скобочная последовательность;
// - правильная скобочная последовательность, взятая в скобки одного типа, –— правильная скобочная последовательность;
// - правильная скобочная последовательность с приписанной слева или справа правильной скобочной последовательностью —–
// тоже правильная.
// На вход подаётся последовательность из скобок трёх видов: [], (), {}.
// Напишите функцию is_correct_bracket_seq, которая принимает на вход скобочную последовательность и возвращает True,
// если последовательность правильная, а иначе False.
//
// Формат ввода
// На вход подаётся одна строка, содержащая скобочную последовательность. Скобки записаны подряд, без пробелов.
//
// Формат вывода
// Выведите «True» или «False».
public class BracketSequence {
    private static final String TRUE = "True";
    private static final String FALSE = "False";

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String str = reader.readLine();
            boolean isValidSequence = isValidSequence(str);
            writer.write(isValidSequence ? TRUE : FALSE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isValidSequence(String str) {
        if (str == null) {
            return true;
        }

        List<Character> bracketsToClose = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char bracket = str.charAt(i);
            if (bracketsToClose.isEmpty() && bracket != '[' && bracket != '(' && bracket != '{') {
                return false;
            } else if (bracket == ']' || bracket == ')' || bracket == '}') {
                char c = bracketsToClose.remove(0);
                if (c != bracket) {
                    return false;
                }
            } else if (bracket == '[') {
                bracketsToClose.add(0, ']');
            } else if (bracket == '(') {
                bracketsToClose.add(0, ')');
            } else if (bracket == '{') {
                bracketsToClose.add(0, '}');
            }
        }

        return bracketsToClose.isEmpty();
    }
}
