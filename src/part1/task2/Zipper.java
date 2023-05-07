package part1.task2;

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

// Даны два массива чисел длины n. Составьте из них один массив длины 2n, в котором числа из входных массивов чередуются
// (первый — второй — первый — второй — ...). При этом относительный порядок следования чисел из одного массива должен
// быть сохранён.
//
// Формат ввода.
// В первой строке записано целое число n –— длина каждого из массивов, 1 ≤ n ≤ 1000.
// Во второй строке записано n чисел из первого массива, через пробел.
// В третьей строке –— n чисел из второго массива.
// Значения всех чисел – натуральные и не превосходят 1000.
//
// Формат вывода.
// Выведите 2n чисел из объединённого массива через пробел.
public class Zipper {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int n = Integer.parseInt(reader.readLine());
            List<Integer> a = readList(reader);
            List<Integer> b = readList(reader);
            printList(zip(a, b), writer);
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

    private static List<Integer> zip(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            result.add(a.get(i));
            result.add(b.get(i));
        }

        return result;
    }
}
