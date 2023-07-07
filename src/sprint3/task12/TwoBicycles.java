package sprint3.task12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Вася решил накопить денег на два одинаковых велосипеда — себе и сестре. У Васи есть копилка, в которую каждый день
// он может добавлять деньги (если, конечно, у него есть такая финансовая возможность). В процессе накопления Вася не
// вынимает деньги из копилки.
// У вас есть информация о росте Васиных накоплений — сколько у Васи в копилке было денег в каждый из дней.
// Ваша задача — по заданной стоимости велосипеда определить первый день, в которой Вася смог бы купить один велосипед,
// и первый день, в который Вася смог бы купить два велосипеда.
// Подсказка: решение должно работать за O(log n).
//
// Формат ввода
// В первой строке дано число дней n, по которым велись наблюдения за Васиными накоплениями. 1 ≤ n ≤ 106.
// В следующей строке записаны n целых неотрицательных чисел. Числа идут в порядке неубывания. Каждое из чисел не
// превосходит 106.
// В третьей строке записано целое положительное число s — стоимость велосипеда. Это число не превосходит 106.
//
// Формат вывода
// Нужно вывести два числа — номера дней по условию задачи.
// Если необходимой суммы в копилке не нашлось, нужно вернуть -1 вместо номера дня.
public class TwoBicycles {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int arraySize = Integer.parseInt(reader.readLine());
            int[] values = getValues(reader.readLine(), arraySize);
            int price = Integer.parseInt(reader.readLine());
            int day = values[arraySize - 1] >= price ? getDayByBinarySearch(price, values, 0, values.length) : -1;

            int day2;
            price *= 2;
            day2 = values[arraySize - 1] >= price
                   ? getDayByBinarySearch(price, values, day - 1, values.length)
                   : -1;

            writer.write(day + " " + day2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getDayByBinarySearch(int price, int[] values, int left, int right) {
        if (left >= right) {
            return right + 1;
        }

        int middle = (right + left) / 2;
        if (values[middle] < price) {
            return getDayByBinarySearch(price, values, middle + 1, right);
        }

        return getDayByBinarySearch(price, values, left, middle);
    }

    private static int[] getValues(String str, int arraySize) {
        int[] values = new int[arraySize];
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        for (int i = 0; i < arraySize; i++) {
            values[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return values;
    }
}
