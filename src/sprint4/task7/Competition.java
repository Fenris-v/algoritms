package sprint4.task7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Жители Алгосов любят устраивать турниры по спортивному программированию. Все участники разбиваются на пары и
// соревнуются друг с другом. А потом два самых сильных программиста встречаются в финальной схватке, которая состоит
// из нескольких раундов. Если в очередном раунде выигрывает первый участник, в таблицу с результатами записывается 0,
// если второй, то 1. Ничьей в раунде быть не может.
//
// Нужно определить наибольший по длине непрерывный отрезок раундов, по результатам которого суммарно получается
// ничья. Например, если дана последовательность 0 0 1 0 1 1 1 0 0 0, то раунды с 2-го по 9-й
// (нумерация начинается с единицы) дают ничью.
//
// Формат ввода
// В первой строке задаётся n (0 ≤ n ≤ 105) –— количество раундов. Во второй строке через пробел записано n чисел –—
// результаты раундов. Каждое число равно либо 0, либо 1.
//
// Формат вывода
// Выведите длину найденного отрезка.
public class Competition {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            Map<Integer, int[]> values = getValues(reader);
            int maxLength = findMaxLength(values);
            writer.write(String.valueOf(maxLength));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<Integer, int[]> getValues(BufferedReader reader) throws IOException {
        int sum = 0;
        int length = Integer.parseInt(reader.readLine());
        Map<Integer, int[]> map = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < length; i++) {
            sum += stringTokenizer.nextToken().equals("0") ? -1 : 1;
            if (!map.containsKey(sum)) {
                map.put(sum, new int[]{i, -1});
            } else {
                map.get(sum)[1] = i;
            }
        }

        return map;
    }

    private static int findMaxLength(Map<Integer, int[]> values) {
        int maxLength = 0;
        int[] value;
        for (Map.Entry<Integer, int[]> entry : values.entrySet()) {
            value = entry.getValue();
            if (entry.getKey() == 0) {
                maxLength = Math.max(maxLength, value[value[1] == -1 ? 0 : 1] + 1);
            } else if (entry.getValue()[1] != -1) {
                maxLength = Math.max(maxLength, value[1] - value[0]);
            }
        }

        return maxLength;
    }
}
