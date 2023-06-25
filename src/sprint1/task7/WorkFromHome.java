package sprint1.task7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

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
public class WorkFromHome {
    private static final int maxValue = 10000;

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

        int sum = 0;
        StringBuilder builder = new StringBuilder();
        List<Integer> binaryList = getBinaryList();

        int index = binaryList.size() - 1;
        while (sum < decimal || index >= 0) {
            if (sum + binaryList.get(index) > decimal) {
                if (builder.length() != 0) {
                    builder.append(0);
                }
            } else {
                sum += binaryList.get(index);
                builder.append(1);
            }

            index--;
        }

        return builder.toString();
    }

    private static List<Integer> getBinaryList() {
        int sum = 1;
        int prevValue = 1;
        List<Integer> binaryList = new ArrayList<>();
        binaryList.add(prevValue);
        while (sum < maxValue) {
            prevValue = prevValue * 2;
            binaryList.add(prevValue);
            sum += prevValue;
        }

        return binaryList;
    }
}
