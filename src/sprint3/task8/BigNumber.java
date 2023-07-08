package sprint3.task8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Вечером ребята решили поиграть в игру «Большое число».
// Даны числа. Нужно определить, какое самое большое число можно из них составить.
//
// Формат ввода
// В первой строке записано n — количество чисел. Оно не превосходит 100.
// Во второй строке через пробел записаны n неотрицательных чисел, каждое из которых не превосходит 1000.
//
// Формат вывода
// Нужно вывести самое большое число, которое можно составить из данных чисел.
public class BigNumber {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int length = Integer.parseInt(reader.readLine());
            String[] numbers = getNumbers(reader.readLine(), length);
            sortNumbers(numbers);
            writer.write(String.join("", numbers));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getNumbers(String str, int length) {
        String[] numbers = new String[length];
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        for (int i = 0; i < length; i++) {
            numbers[i] = stringTokenizer.nextToken();
        }

        return numbers;
    }

    private static void sortNumbers(String[] numbers) {
        Arrays.sort(numbers, (o1, o2) -> CharSequence.compare(o2 + o1, o1 + o2));
    }
}
