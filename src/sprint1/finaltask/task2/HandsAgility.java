package sprint1.finaltask.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * id: 88583307
 */
// Игра «Тренажёр для скоростной печати» представляет собой поле из клавиш 4x4. В нём на каждом раунде появляется
// конфигурация цифр и точек. На клавише написана либо точка, либо цифра от 1 до 9.
// В момент времени t игрок должен одновременно нажать на все клавиши, на которых написана цифра t. Гоша и Тимофей
// могут нажать в один момент времени на k клавиш каждый. Если в момент времени t нажаты все нужные клавиши, то игроки
// получают 1 балл.
// Найдите число баллов, которое смогут заработать Гоша и Тимофей, если будут нажимать на клавиши вдвоём.
//
// Формат ввода
// В первой строке дано целое число k (1 ≤ k ≤ 5).
// В четырёх следующих строках задан вид тренажёра -— по 4 символа в каждой строке. Каждый символ – либо точка, либо
// цифра от 1 до 9. Символы одной строки идут подряд и не разделены пробелами.
//
// Формат вывода
// Выведите единственное число -— максимальное количество баллов, которое смогут набрать Гоша и Тимофей.
public class HandsAgility {
    private static int maxSameTimePressedKeys;
    private static int[] sameValuesArray;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            sameValuesArray = new int[9];
            initValueData(reader);
            writer.write(String.valueOf(countPossiblePoints()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initValueData(BufferedReader reader) throws IOException {
        maxSameTimePressedKeys = Integer.parseInt(reader.readLine()) * 2;

        String row;
        for (int i = 0; i < 4; i++) {
            row = reader.readLine();
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '.') {
                    continue;
                }

                int value = Character.digit(row.charAt(j), 10);
                sameValuesArray[value - 1]++;
            }
        }
    }

    private static int countPossiblePoints() {
        int possiblePoints = 0;
        for (int t = 0; t < 9; t++) {
            if (sameValuesArray[t] == 0) {
                continue;
            }

            if (sameValuesArray[t] <= maxSameTimePressedKeys) {
                possiblePoints++;
            }
        }

        return possiblePoints;
    }
}
