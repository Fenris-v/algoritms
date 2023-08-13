package sprint4.task9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// Гоша увлёкся хоккеем и часто смотрит трансляции матчей. Чтобы более-менее разумно оценивать силы команд, он
// сравнивает очки, набранные во всех матчах каждой командой.
// Гоша попросил вас написать программу, которая по результатам игр двух выбранных команд найдёт наибольший по длине
// отрезок матчей, когда эти команды зарабатывали одинаковые очки.
//
// Рассмотрим первый пример:
// Результаты первой команды: [1 2 3 2 1].
// Результаты второй команды: [3 2 1 5 6].
// Наиболее продолжительный общий отрезок этих массивов имеет длину 3 –— это [3 2 1].
//
// Формат ввода
// В первой строке находится число n (1 ≤ n ≤ 105) –— количество матчей, которые были сыграны первой командой.
// Во второй строке записано n целых чисел –— очки в этих играх.
// В третьей строке дано число m (1 ≤ m ≤ 105) —– количество матчей, которые сыграла вторая команда.
// В четвертой строке заданы m целых чисел —– результаты второй команды.
// Число очков, заработанных в одной игре, лежит в диапазоне от 0 до 255.
//
// Формат вывода
// Выведите целое неотрицательное число —– максимальное количество матчей подряд, в которых команды зарабатывали
// одинаковые очки.
public class GeneralSubarray {
    private static int[] arr1;
    private static int[] arr2;
    private static Map<Integer, List<Integer>> arr1Indexes;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            initValues(reader);
            writer.write(getMaxGeneralSubarray() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initValues(BufferedReader reader) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        arr1 = new int[length];
        arr1Indexes = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < length; i++) {
            arr1[i] = Integer.parseInt(stringTokenizer.nextToken());
            if (!arr1Indexes.containsKey(arr1[i])) {
                arr1Indexes.put(arr1[i], new ArrayList<>());
            }

            arr1Indexes.get(arr1[i]).add(i);
        }

        length = Integer.parseInt(reader.readLine());
        arr2 = new int[length];
        stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < length; i++) {
            arr2[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static int getMaxGeneralSubarray() throws IOException {
        int currentLength;
        int currentValue;
        int currentIndex1;
        int currentIndex2;
        int maxLength = 0;
        for (int i = 0; i < arr2.length; i++) {
            currentValue = arr2[i];
            if (!arr1Indexes.containsKey(currentValue)) {
                continue;
            }

            for (int value : arr1Indexes.get(currentValue)) {
                currentLength = 0;
                currentIndex1 = value;
                currentIndex2 = i;
                while (arr1[currentIndex1] == arr2[currentIndex2]) {
                    currentIndex1++;
                    currentIndex2++;
                    currentLength++;

                    if (currentIndex1 == arr1.length || currentIndex2 == arr2.length) {
                        break;
                    } else if (i + 1 == currentIndex2 && arr2[i] == arr2[currentIndex2]) {
                        i++;
                    }
                }

                maxLength = Math.max(currentLength, maxLength);
            }
        }

        return maxLength;
    }
}
