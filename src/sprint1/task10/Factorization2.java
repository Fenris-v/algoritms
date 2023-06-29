package sprint1.task10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Основная теорема арифметики говорит: любое число раскладывается на произведение простых множителей единственным
// образом, с точностью до их перестановки. Например:
// Число 8 можно представить как 2 × 2 × 2.
// Число 50 –— как 2 × 5 × 5 (или 5 × 5 × 2, или 5 × 2 × 5). Три варианта отличаются лишь порядком следования
// множителей.
// Разложение числа на простые множители называется факторизацией числа.
// Напишите программу, которая производит факторизацию переданного числа.
//
// Формат ввода
// В единственной строке дано число n (2 ≤ n ≤ 109), которое нужно факторизовать.
//
// Формат вывода
// Выведите в порядке неубывания простые множители, на которые раскладывается число n.
public class Factorization2 {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int innerValue = Integer.parseInt(reader.readLine());
            String result = getFactors(innerValue);
            writer.write(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFactors(int innerValue) {
        while ((innerValue & 1) == 0 && (innerValue >> 1 & 1) == 0) {
            innerValue >>= 2;
        }

        return innerValue == 1 ? "True" : "False";
    }
}
