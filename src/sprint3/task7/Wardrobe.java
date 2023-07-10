package sprint3.task7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// Рита решила оставить у себя одежду только трёх цветов: розового, жёлтого и малинового. После того как вещи других
// расцветок были убраны, Рита захотела отсортировать свой новый гардероб по цветам. Сначала должны идти вещи розового
// цвета, потом — жёлтого, и в конце — малинового. Помогите Рите справиться с этой задачей.
// Примечание: попробуйте решить задачу за один проход по массиву!
//
// Формат ввода
// В первой строке задано количество предметов в гардеробе: n – оно не превосходит 1000000. Во второй строке даётся
// массив, в котором указан цвет для каждого предмета. Розовый цвет обозначен 0, жёлтый — 1, малиновый – 2.
//
// Формат вывода
// Нужно вывести в строку через пробел цвета предметов в правильном порядке.
public class Wardrobe {
    private static int[] colors;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            colors = new int[3];
            int[] values = getValues(reader);
            countingSort(values);
            writer.write(Arrays.stream(values).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getValues(BufferedReader reader) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        int[] values = new int[length];
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < length; i++) {
            values[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return values;
    }

    private static void countingSort(int[] values) {
        for (int value : values) {
            colors[value]++;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < colors.length; i++) {
            end += colors[i];
            Arrays.fill(values, start, end, i);
            start = end;
        }
    }
}
