package sprint1.finaltask.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * id: 88506397
 */
// Тимофей ищет место, чтобы построить себе дом. Улица, на которой он хочет жить, имеет длину n, то есть состоит из n
// одинаковых идущих подряд участков. Каждый участок либо пустой, либо на нём уже построен дом.
// Общительный Тимофей не хочет жить далеко от других людей на этой улице. Поэтому ему важно для каждого участка
// знать расстояние до ближайшего пустого участка. Если участок пустой, эта величина будет равна нулю — расстояние до
// самого себя.
// Помогите Тимофею посчитать искомые расстояния. Для этого у вас есть карта улицы. Дома в городе Тимофея
// нумеровались в том порядке, в котором строились, поэтому их номера на карте никак не упорядочены. Пустые участки
// обозначены нулями.
//
// Формат ввода
// В первой строке дана длина улицы —– n (1 ≤ n ≤ 10^6). В следующей строке записаны n целых неотрицательных чисел —
// номера домов и обозначения пустых участков на карте (нули). Гарантируется, что в последовательности есть хотя бы
// один ноль. Номера домов (положительные числа) уникальны и не превосходят 10^9.
//
// Формат вывода
// Для каждого из участков выведите расстояние до ближайшего нуля. Числа выводите в одну строку, разделяя их пробелами.
public class NearestZero {
    public static void main(String[] args) {
        calculateDistance();
    }

    private static void calculateDistance() {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int[] addresses = getInputData(reader);
            int[] map = buildMap(addresses);
            writer.write(Arrays.stream(map).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInputData(BufferedReader reader) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

        int[] addresses = new int[length];
        for (int i = 0; i < length; i++) {
            addresses[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return addresses;
    }

    private static int[] buildMap(int[] addresses) {
        int[] map = new int[addresses.length];
        int zeroIndex = -addresses.length;
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == 0) {
                map[i] = 0;
                zeroIndex = i;
            } else {
                map[i] = i - zeroIndex;
            }
        }

        zeroIndex = addresses.length * 2;
        for (int i = addresses.length - 1; i >= 0; i--) {
            if (addresses[i] == 0) {
                zeroIndex = i;
            } else {
                map[i] = Math.min(zeroIndex - i, map[i]);
            }
        }

        return map;
    }
}
