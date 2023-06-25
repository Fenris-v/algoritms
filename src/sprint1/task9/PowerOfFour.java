package sprint1.task9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Напишите программу, которая определяет, будет ли положительное целое число степенью четвёрки.
// Подсказка: степенью четвёрки будут все числа вида 4n, где n – целое неотрицательное число.
//
// Формат ввода
// На вход подаётся целое число в диапазоне от 1 до 10000.
//
// Формат вывода
// Выведите «True», если число является степенью четырёх, «False» –— в обратном случае.
public class PowerOfFour {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int value = Integer.parseInt(reader.readLine());
            writer.write(isPowerOfFour(value) ? "True" : "False");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isPowerOfFour(int value) {
        if (value == 1) {
            return true;
        }

        while (value >= 4) {
            if (value == 4) {
                return true;
            }

            if (value % 4 != 0) {
                return false;
            }

            value = value / 4;
        }

        return false;
    }
}
