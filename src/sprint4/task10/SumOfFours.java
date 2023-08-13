package sprint4.task10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// У Гоши есть любимое число S. Помогите ему найти все уникальные четвёрки чисел в массиве, которые в сумме дают
// заданное число S.
//
// Формат ввода
// В первой строке дано общее количество элементов массива n (0 ≤ n ≤ 1000).
// Во второй строке дано целое число S.
// В третьей строке задан сам массив. Каждое число является целым и не превосходит по модулю 10^9.
//
// Формат вывода
// В первой строке выведите количество найденных четвёрок чисел.
// В последующих строках выведите найденные четвёрки. Числа внутри одной четверки должны быть упорядочены по
// возрастанию. Между собой четвёрки упорядочены лексикографически.
public class SumOfFours {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int length = Integer.parseInt(reader.readLine());
            int number = Integer.parseInt(reader.readLine());
            int[] values = new int[length];
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < length; i++) {
                values[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            Set<Fours> results = getSumOfFours(number, values);
            writer.write(results.size() + "\n");
            for (Fours result : results) {
                writer.write(
                        Arrays.stream(result.getValues()).mapToObj(String::valueOf).collect(Collectors.joining(" ")) +
                                "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Set<Fours> getSumOfFours(int number, int[] values) {
        Set<Fours> results = new LinkedHashSet<>();
        int n = values.length;
        Arrays.sort(values);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int m = k + 1; m < n; m++) {
                        if (values[m] + values[k] + values[j] + values[i] == number) {
                            results.add(new Fours(values[i], values[j], values[k], values[m]));
                        }
                    }
                }
            }
        }

        return results;
    }
}

class Fours {
    private final int[] values;

    public Fours(int i, int j, int k, int m) {
        values = new int[]{i, j, k, m};
    }

    public int[] getValues() {
        return values;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Fours && Arrays.equals(values, ((Fours) obj).getValues());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
}
