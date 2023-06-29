package sprint1.task7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Вася реализовал функцию, которая переводит целое число из десятичной системы в двоичную. Но, кажется, она
// получилась не очень оптимальной.
// Попробуйте написать более эффективную программу.
// Не используйте встроенные средства языка по переводу чисел в бинарное представление.
//
// Формат ввода
// На вход подаётся целое число в диапазоне от 0 до 10000.
//
// Формат вывода
// Выведите двоичное представление этого числа.
public class WorkFromHome2 {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int decimal = Integer.parseInt(reader.readLine());
            String binary = convertDecimalToBinary(decimal);
            writer.write(String.valueOf(binary));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String convertDecimalToBinary(int decimal) {
        if (decimal < 2) {
            return String.valueOf(decimal);
        }

        StringBuilder builder = new StringBuilder();
        while (decimal > 1) {
            builder.insert(0, decimal % 2);
            decimal = decimal / 2;
        }

        return builder.insert(0, 1).toString();
    }
}
