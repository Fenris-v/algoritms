package sprint1.task11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Вася просил Аллу помочь решить задачу. На этот раз по информатике.
// Для неотрицательного целого числа X списочная форма –— это массив его цифр слева направо. К примеру, для 1231
// списочная форма будет [1,2,3,1]. На вход подается количество цифр числа Х, списочная форма неотрицательного числа Х
// и неотрицательное число K. Число К не превосходят 10000. Длина числа Х не превосходит 1000.
// Нужно вернуть списочную форму числа X + K.
//
// Формат ввода
// В первой строке — длина списочной формы числа X. На следующей строке — сама списочная форма с цифрами записанными
// через пробел.
// В последней строке записано число K, 0 ≤ K ≤ 10000.
//
// Формат вывода
// Выведите списочную форму числа X+K.
public class ListForm {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int length = Integer.parseInt(reader.readLine());
            int[] listForm = getListForm(reader.readLine(), length);
            String k = reader.readLine();
            List<String> result = getSum(listForm, length, k);
            writer.write(String.join(" ", result));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getListForm(String line, int length) {
        StringTokenizer stringTokenizer = new StringTokenizer(line);
        int[] listForm = new int[length];
        for (int i = 0; i < length; i++) {
            listForm[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return listForm;
    }

    private static List<String> getSum(int[] listForm, int length, String k) {
        List<String> result = new ArrayList<>();
        int remainder = 0;
        for (int i = 0; i < Math.max(length, k.length()); i++) {
            int value = listForm.length - i - 1 >= 0 ? listForm[listForm.length - i - 1] : 0;
            int kValue = k.length() - i - 1 >= 0 ? k.charAt(k.length() - i - 1) - '0' : 0;
            int sum = value + kValue + remainder;
            if (sum > 9) {
                sum -= 10;
                remainder = 1;
            } else {
                remainder = 0;
            }

            result.add(0, String.valueOf(sum));
        }

        if (remainder > 0) {
            result.add(0, "1");
        }

        return result;
    }
}
