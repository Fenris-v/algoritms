package sprint3.task6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Перед сном Рита решила поиграть в игру на телефоне. Дан массив целых чисел, в котором каждый элемент обозначает
// длину стороны треугольника. Нужно определить максимально возможный периметр треугольника, составленного из сторон с
// длинами из заданного массива. Помогите Рите скорее закончить игру и пойти спать.
// Напомним, что из трёх отрезков с длинами a ≤ b ≤ c можно составить треугольник, если выполнено неравенство
// треугольника: c < a + b
// Разберём пример:
// даны длины сторон 6, 3, 3, 2. Попробуем в качестве наибольшей стороны выбрать 6. Неравенство треугольника не может
// выполниться, так как остались 3, 3, 2 — максимальная сумма из них равна 6.
// Без шестёрки оставшиеся три отрезка уже образуют треугольник со сторонами 3, 3, 2. Неравенство выполняется: 3 < 3
// + 2. Периметр равен 3 + 3 + 2 = 8.
//
// Формат ввода
// В первой строке записано количество отрезков n, 3≤ n≤ 10000.
// Во второй строке записано n неотрицательных чисел, не превосходящих 10 000, – длины отрезков.
//
// Формат вывода
// Нужно вывести одно число — наибольший периметр треугольника.
// Гарантируется, что тройка чисел, которая может образовать треугольник, всегда есть.
public class TrianglePerimeter {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int[] lengths = getLengths(reader);
            int perimeter = getMaxAvailablePerimeter(lengths);
            writer.write(String.valueOf(perimeter));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getLengths(BufferedReader reader) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        int[] lengths = new int[length];
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < length; i++) {
            lengths[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(lengths);
        return lengths;
    }

    private static int getMaxAvailablePerimeter(int[] lengths) {
        int c = lengths.length - 1;
        while (lengths[c] >= lengths[c - 1] + lengths[c - 2]) {
            c--;
        }

        return lengths[c - 1] + lengths[c - 2] + lengths[c];
    }
}
