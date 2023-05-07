package part1.task5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Обратите внимание на ограничения в этой задаче.
// Рита и Гоша играют в игру. У Риты есть n фишек, на каждой из которых написано количество очков. Фишки лежат на столе
// в порядке неубывания очков на них. Сначала Гоша называет число k, затем Рита должна выбрать две фишки, сумма очков на
// которых равна заданному числу.
//
// Рите надоело искать фишки самой, и она решила применить свои навыки программирования для решения этой задачи.
// Помогите ей написать программу для поиска нужных фишек.
//
// Формат ввода.
// В первой строке записано количество фишек n, 2 ≤ n ≤ 10^5.
// Во второй строке записано n целых чисел в порядке неубывания — очки на фишках Риты в диапазоне от -10^5 до 10^5.
// В третьей строке — загаданное Гошей целое число k, -10^5 ≤ k ≤ 10^5.
//
// Формат вывода.
// Нужно вывести два числа — очки на двух фишках, в сумме дающие k.
// Если таких пар несколько, то можно вывести любуюиз них.
// Если таких пар не существует, то вывести «None».

/**
 * Решение через сортировку
 */
public class TwoSum1 {
    private static int targetSum;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int n = Integer.parseInt(reader.readLine());
            List<Integer> values = readList(reader);
            Collections.sort(values);
            targetSum = Integer.parseInt(reader.readLine());
            List<Integer> result = twoSum(values);

            if (result == null) {
                System.out.println("None");
            } else {
                printList(result, writer);
            }
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void printList(List<Integer> list, Writer writer) {
        list.forEach(elem -> {
            try {
                writer.write(String.valueOf(elem));
                writer.write(" ");
            } catch (IOException ignored) {
            }
        });
    }

    private static List<Integer> twoSum(List<Integer> values) {
        return twoSum(values, 0, values.size() - 1);
    }

    private static List<Integer> twoSum(List<Integer> values, int left, int right) {
        if (left == right) {
            return null;
        }

        int currentSum = values.get(left) + values.get(right);
        if (currentSum == targetSum) {
            List<Integer> result = new ArrayList<>();
            result.add(values.get(left));
            result.add(values.get(right));

            return result;
        }

        if (currentSum < targetSum) {
            left++;
        } else {
            right--;
        }

        return twoSum(values, left, right);
    }
}
