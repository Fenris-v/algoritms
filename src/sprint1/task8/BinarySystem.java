package sprint1.task8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Тимофей записал два числа в двоичной системе счисления и попросил Гошу вывести их сумму, также в двоичной системе.
// Встроенную в язык программирования возможность сложения двоичных чисел применять нельзя. Помогите Гоше решить задачу.
// Решение должно работать за O(N), где N –— количество разрядов максимального числа на входе.
//
// Формат ввода
// Два числа в двоичной системе счисления, каждое на отдельной строке. Длина каждого числа не превосходит 10 000
// символов.
//
// Формат вывода
// Одно число в двоичной системе счисления.
public class BinarySystem {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String firstValue = reader.readLine();
            String secondValue = reader.readLine();
            String result = getSum(firstValue, secondValue);
            writer.write(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getSum(String firstValue, String secondValue) {
        int maxLength = Math.max(firstValue.length(), secondValue.length());
        int remainder = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= maxLength; i++) {
            int first = firstValue.length() - i >= 0 ? getCharAsInt(firstValue.charAt(firstValue.length() - i)) : 0;
            int second = secondValue.length() - i >= 0 ? getCharAsInt(secondValue.charAt(secondValue.length() - i)) : 0;

            if (first + second == 2) {
                result.insert(0, remainder);
                remainder = 1;
            } else if (first + second == 1) {
                result.insert(0, remainder + first + second == 1 ? 1 : 0);
            } else {
                result.insert(0, remainder);
                remainder = 0;
            }
        }

        if (remainder > 0) {
            result.insert(0, remainder);
        }

        return result.toString();
    }

    private static int getCharAsInt(char c) {
        return Integer.parseInt(String.valueOf(c));
    }
}
