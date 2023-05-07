package part1.task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Вам дана статистика по числу запросов в секунду к вашему любимому рекомендательному сервису.
// Измерения велись n секунд.
// В секунду i поступает qi запросов.
// Примените метод скользящего среднего с длиной окна k к этим данным и выведите результат.
//
// Формат ввода.
// В первой строке передаётся натуральное число n, количество секунд, в течение которых велись измерения. 1 ≤ n ≤ 105
// Во второй строке через пробел записаны n целых неотрицательных чисел qi, каждое лежит в диапазоне от 0 до 10^3.
// В третьей строке записано натуральное число k (1 ≤ k ≤ n) — окно сглаживания.
//
// Формат вывода.
// Выведите через пробел результат применения метода скользящего среднего к серии измерений. Должно быть выведено
// n - k + 1 элементов, каждый элемент — вещественное (дробное) число.
public class MovingAverage {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int n = Integer.parseInt(reader.readLine());
            List<Integer> data = readList(reader);
            int windowSize = readInt(reader);
            printList(movingAverage(n, data, windowSize), writer);
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static void printList(List<Float> list, Writer writer) {
        list.forEach(elem -> {
            try {
                writer.write(String.valueOf(elem));
                writer.write(" ");
            } catch (IOException ignored) {
            }
        });
    }

    private static List<Float> movingAverage(int n, List<Integer> data, int windowSize) {
        List<Float> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n - windowSize + 1; i++) {
            if (i == 0) {
                for (int z = 0; z < windowSize; z++) {
                    sum += data.get(z);
                }
            } else {
                sum -= data.get(i - 1);
                sum += data.get(i + windowSize - 1);
            }

            result.add((float) sum / windowSize);
        }

        return result;
    }
}
