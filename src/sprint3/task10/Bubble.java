package sprint3.task10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// Чтобы выбрать самый лучший алгоритм для решения задачи, Гоша продолжил изучать разные сортировки. На очереди
// сортировка пузырьком — https://ru.wikipedia.org/wiki/Сортировка_пузырьком
// Её алгоритм следующий (сортируем по неубыванию):
// 1. На каждой итерации проходим по массиву, поочередно сравнивая пары соседних элементов. Если элемент на позиции i
// больше элемента на позиции i + 1, меняем их местами. После первой итерации самый большой элемент всплывёт в конце
// массива.
// 2. Проходим по массиву, выполняя указанные действия до тех пор, пока на очередной итерации не окажется, что обмены
// больше не нужны, то есть массив уже отсортирован.
// 3. После не более чем n – 1 итераций выполнение алгоритма заканчивается, так как на каждой итерации хотя бы один
// элемент оказывается на правильной позиции.
// Помогите Гоше написать код алгоритма.
//
// Формат ввода
// В первой строке на вход подаётся натуральное число n — длина массива, 2 ≤ n ≤ 1000.
// Во второй строке через пробел записано n целых чисел.
// Каждое из чисел по модулю не превосходит 1000.
// Обратите внимание, что считывать нужно только 2 строки: значение n и входной массив.
//
// Формат вывода
// После каждого прохода по массиву, на котором какие-то элементы меняются местами, выводите его промежуточное
// состояние.
// Таким образом, если сортировка завершена за k меняющих массив итераций, то надо вывести k строк по n чисел в
// каждой — элементы массива после каждой из итераций.
// Если массив был изначально отсортирован, то просто выведите его.
public class Bubble {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int length = Integer.parseInt(reader.readLine());
            int[] numbers = getNumbers(reader.readLine(), length);
            bubbleSort(numbers, numbers.length - 1, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getNumbers(String str, int length) {
        int[] numbers = new int[length];
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return numbers;
    }

    private static void bubbleSort(int[] numbers, int lastIndex, BufferedWriter writer) throws IOException {
        int temp;
        boolean isSorted = true;
        for (int i = 0; i < lastIndex; i++) {
            if (numbers[i] > numbers[i + 1]) {
                isSorted = false;
                temp = numbers[i + 1];
                numbers[i + 1] = numbers[i];
                numbers[i] = temp;
            }
        }

        if (!isSorted) {
            writer.write(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(" ")) + "\n");
            bubbleSort(numbers, lastIndex - 1, writer);
        } else if (lastIndex == numbers.length - 1) {
            writer.write(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(" ")) + "\n");
        }
    }
}
