package sprint7.finaltask.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * id: 91873431
 */
/*
-- ПРИНЦИП РАБОТЫ --
Программа находит минимальное количество замен, чтобы получить одинаковые строки.

Решение использует алгоритм Вагнера - Фишера. Это алгоритм, использующий динамическое программирование. Метод
вычисления расстояния Левенштейна принимает на вход две строки. Проверяет не является ли одна из строк пустой.
Если такая строка существует, то расстояние по Левенштейну будет равно длине второй строки.

Следующим шагом алгоритм инициализирует массив для записи результатов динамического программирования.

На последнем шаге идёт вычисление минимального количества необходимых операций. Для этого сравниваются 3 числа:
1) dp[0][j] + 1
2) dp[1][j - 1] + 1
3) dp[0][j - 1] + k, где k - будет равно 0, если символы совпадают и 1, если символы разные.
Из этих трёх чисел выбирается минимальное и записывается в массив dp[1][j]. Ответом на задачу будет нижнее правое
значение массива.

Для сокращения затрат памяти массив имеет всего 2 ряда, т.к. остальные не используются во время работы алгоритма.
Для поддержания актуальности рядов, после того, как будет высчитано значение для dp[1][j], значение с dp[1][j - 1]
копируется на dp[0][j - 1], а на последней итерации вложенного массива также копируется dp[1][j] на dp[0][j]
и увеличивается на 1 значение dp[1][0];

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Инициализация массива dp займёт O(m + n) времени, т.к. при инициализации проходит два цикла, для заполнения стартовых
значений.

Вычисление значений массива займёт O(m * n), т.к. каждый символ первой строки будет проверен то количество раз, какой
длины вторая строка.

Итоговая сложность алгоритма будет O(m + m + m * n), что можно упростить до O(m * n).

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Для хранения строк потребуется O(m + n) памяти.

На хранение таблицы динамического программирования в массиве потребуется O(2k) памяти,
где k - более короткая строка из двух.

Итоговая пространственная сложность алгоритма будет такой же, как и временная, т.е. O(m + n + 2k).
 */
public class LevenshteinDistance {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String first = reader.readLine();
            String second = reader.readLine();
            int distance = first.length() > second.length() ? findDistance(first, second) : findDistance(second, first);
            writer.write(String.valueOf(distance));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findDistance(String longerStr, String shorterStr) {
        if (shorterStr.isEmpty()) {
            return longerStr.length();
        }

        int min;
        int k;
        int[][] dp = buildDp(shorterStr.length());
        for (int i = 1; i <= longerStr.length(); i++) {
            for (int j = 1; j <= shorterStr.length(); j++) {
                min = Math.min(dp[0][j] + 1, dp[1][j - 1] + 1);
                k = longerStr.charAt(i - 1) == shorterStr.charAt(j - 1) ? 0 : 1;
                dp[1][j] = Math.min(min, dp[0][j - 1] + k);

                dp[0][j - 1] = dp[1][j - 1];
                if (j == shorterStr.length()) {
                    dp[0][j] = dp[1][j];
                    dp[1][0] += 1;
                }
            }
        }

        return dp[1][shorterStr.length()];
    }

    private static int[][] buildDp(int length) {
        int[][] dp = new int[2][length + 1];
        dp[1][0] = 1;

        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = j;
        }

        return dp;
    }
}
