package sprint3.task14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// Алла захотела, чтобы у неё под окном были узкие клумбы с тюльпанам. На схеме земельного участка клумбы обозначаются
// просто горизонтальными отрезками, лежащими на одной прямой. Для ландшафтных работ было нанято n садовников. Каждый
// из них обрабатывал какой-то отрезок на схеме. Процесс был организован не очень хорошо, иногда один и тот же отрезок
// или его часть могли быть обработаны сразу несколькими садовниками. Таким образом, отрезки, обрабатываемые двумя
// разными садовниками, сливаются в один. Непрерывный обработанный отрезок затем станет клумбой. Нужно определить
// границы будущих клумб.
//
// Рассмотрим примеры.
//
// Пример 1:
// Даны 4 отрезка:
// [7, 8], [7, 8], [2, 3], [6, 10]. Два одинаковых отрезка [7, 8] и [7, 8] сливаются в один, но потом их накрывает
// отрезок[6, 10]. Таким образом, имеем две клумбы с координатами [2, 3] и [6, 10].
//
// Пример 2
// Во втором сэмпле опять 4 отрезка:
// [2, 3], [3, 4], [3, 4], [5, 6]. Отрезки[2, 3], [3, 4] и [3, 4] сольются в один отрезок [2, 4]. Отрезок[5, 6] ни с кем
// не объединяется, добавляем его в ответ.
//
// Формат ввода
// В первой строке задано количество садовников n. Число садовников не превосходит 100000. В следующих n строках через
// пробел записаны координаты клумб в формате: start end, где start — координата начала, end — координата конца. Оба
// числа целые, неотрицательные и не превосходят10^7. start строго меньше, чем end.
//
// Формат вывода
// Нужно вывести координаты каждой из получившихся клумб в отдельных строках. Данные должны выводиться в
// отсортированном порядке — сначала клумбы с меньшими координатами, затем — с бОльшими.
public class Flowerbeds {
    private static List<Integer[]> flowerbeds;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int length = Integer.parseInt(reader.readLine());
            Integer[][] values = new Integer[length][2];
            StringTokenizer stringTokenizer;
            for (int i = 0; i < length; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < 2; j++) {
                    values[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            flowerbeds = new ArrayList<>();
            getFlowerbeds(values);
            flowerbeds.forEach(flowerbed -> print(writer, flowerbed));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getFlowerbeds(Integer[][] values) {
        flowerbeds.add(values[0]);
        for (int i = 1; i < values.length; i++) {
            wrapFlowerbeds(values[i]);
        }
    }

    private static void wrapFlowerbeds(Integer[] values) {
        Integer[] flowerbed;
        for (int i = 0; i < flowerbeds.size(); i++) {
            flowerbed = flowerbeds.get(i);
            if (values[1] < flowerbed[0]) {
                flowerbeds.add(i, values);
                return;
            }

            if (values[0] > flowerbed[1]) {
                if (i == flowerbeds.size() - 1) {
                    flowerbeds.add(values);
                    return;
                }

                continue;
            }

            flowerbed[0] = Math.min(flowerbed[0], values[0]);
            int max = Math.max(flowerbed[1], values[1]);
            for (int j = i + 1; j < flowerbeds.size(); j++) {
                if (max < flowerbeds.get(j)[0]) {
                    break;
                }

                max = Math.max(flowerbeds.get(j)[1], max);
                flowerbeds.remove(j--);
            }

            flowerbed[1] = max;
            return;
        }
    }

    private static void print(BufferedWriter writer, Integer[] flowerbed) {
        try {
            writer.write(Arrays.stream(flowerbed).map(String::valueOf).collect(Collectors.joining(" ")) + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
