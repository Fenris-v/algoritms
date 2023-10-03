package sprint7.finaltask.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * id: 91876654
 */
/*
-- ПРИНЦИП РАБОТЫ --
При парсинге строки в массив чисел также подсчитывается общая сумма чисел в массиве.

Массив и его сумма передаётся в метод проверки возможности разделения массива на две части с равным количеством очков.
Если общая сумма всех чисел массива является нечётным числом, значит массив разделить невозможно и работу метода можно
сразу прервать.

В ином случае создаётся 2 дополнительных массива, равных по длине половине суммы чисел массива +1. Далее идёт 2 цикла,
при помощи которых вычисляется можно ли составить комбинацию из чисел, дающую в сумме половину от общей суммы.

В итоге, если есть такая комбинация существует, значит разделение возможно.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Построение массива и вычисление его суммы займёт O(n) времени.

Вычисление возможности разделения массива на равные части займёт O(n * m / 2), где m - сумма всех чисел массива.

Итоговая сложность алгоритма будет O(n + n * m / 2), что можно упростить до O(n * m / 2).

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Хранение массива чисел займёт O(n) памяти.

Для работы метода создаются 2 вспомогательных массива, равных половине суммы всех чисел +1, т.е. O(m + 2),
где m - сумма всех чисел массива. Можно упростить до O(m).

Итоговая сложность алгоритма O(n + m). Расчёт опускает то, что на каждом "числе" создаётся новый массив, т.к.
память занимаемая старым массивом будет очищена сборщиком мусора при первой необходимости.
 */
public class SameSums {
    private static final String TRUE = "True";
    private static final String FALSE = "False";

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int length = Integer.parseInt(reader.readLine());
            int[] points = new int[length];
            int sum = 0;
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < length; i++) {
                points[i] = Integer.parseInt(stringTokenizer.nextToken());
                sum += points[i];
            }

            writer.write(hasSameSums(points, sum) ? TRUE : FALSE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean hasSameSums(int[] points, int sum) {
        if (sum % 2 == 1) {
            return false;
        }

        int half = sum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;

        for (int point : points) {
            for (int i = half; i >= point; i--) {
                dp[i] = dp[i] || dp[i - point];
            }
        }

        return dp[half];
    }
}
