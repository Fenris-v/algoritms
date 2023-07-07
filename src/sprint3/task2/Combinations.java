package sprint3.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// На клавиатуре старых мобильных телефонов каждой цифре соответствовало несколько букв. Примерно так:
// 2:'abc',
// 3:'def',
// 4:'ghi',
// 5:'jkl',
// 6:'mno',
// 7:'pqrs',
// 8:'tuv',
// 9:'wxyz'
//
// Вам известно в каком порядке были нажаты кнопки телефона, без учета повторов. Напечатайте все комбинации букв,
// которые можно набрать такой последовательностью нажатий.
//
// Формат ввода
// На вход подается строка, состоящая из цифр 2-9 включительно. Длина строки не превосходит 10 символов.
//
// Формат вывода
// Выведите все возможные комбинации букв через пробел.
public class Combinations {
    private static final String[][] LETTERS = new String[10][4];

    private static StringBuilder stringBuilder;

    static {
        LETTERS[2][0] = "a";
        LETTERS[2][1] = "b";
        LETTERS[2][2] = "c";

        LETTERS[3][0] = "d";
        LETTERS[3][1] = "e";
        LETTERS[3][2] = "f";

        LETTERS[4][0] = "g";
        LETTERS[4][1] = "h";
        LETTERS[4][2] = "i";

        LETTERS[5][0] = "j";
        LETTERS[5][1] = "k";
        LETTERS[5][2] = "l";

        LETTERS[6][0] = "m";
        LETTERS[6][1] = "n";
        LETTERS[6][2] = "o";

        LETTERS[7][0] = "p";
        LETTERS[7][1] = "q";
        LETTERS[7][2] = "r";
        LETTERS[7][3] = "s";

        LETTERS[8][0] = "t";
        LETTERS[8][1] = "u";
        LETTERS[8][2] = "v";

        LETTERS[9][0] = "w";
        LETTERS[9][1] = "x";
        LETTERS[9][2] = "y";
        LETTERS[9][3] = "z";
    }

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String str = reader.readLine();
            int[] values = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
            stringBuilder = new StringBuilder();
            getCombinations(values, 0, "");
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getCombinations(int[] values, int index, String prefix) {
        int value = values[index];
        String letter;
        for (int i = 0; i < LETTERS[value].length; i++) {
            letter = LETTERS[value][i];
            if (letter == null) {
                return;
            } else if (index < values.length - 1) {
                getCombinations(values, index + 1, prefix + letter);
            } else {
                stringBuilder.append(prefix).append(letter).append(" ");
            }
        }
    }
}
