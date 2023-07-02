package sprint2.task12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// У Тимофея было очень много стажёров, целых N (0 ≤ N ≤ 106) человек. Каждый стажёр хотел быть лучше своих
// предшественников, поэтому i-й стажёр делал столько коммитов, сколько делали два предыдущих стажёра в сумме. Два
// первых стажёра были менее инициативными — они сделали по одному коммиту.
// Пусть Fi —– число коммитов, сделанных i-м стажёром (стажёры нумеруются с нуля). Первые два стажёра сделали по
// одному коммиту: F0=F1=1. Для всех i≥ 2 выполнено Fi = Fi − 1 + Fi − 2.
// Определите, сколько кода напишет следующий стажёр –— найдите последние k цифр числа Fn.
//
// Как найти k последних цифр
// Чтобы вычислить k последних цифр некоторого числа x, достаточно взять остаток от его деления на число 10k. Эта
// операция обозначается как x mod 10k. Узнайте, как записывается операция взятия остатка по модулю в вашем языке
// программирования.
// Также обратите внимание на возможное переполнение целочисленных типов, если в вашем языке такое случается.
//
// Формат ввода
// В первой строке записаны через пробел два целых числа n (0 ≤ n ≤ 106) и k (1 ≤ k ≤ 8).
//
// Формат вывода
// Выведите единственное число – последние k цифр числа Fn.
// Если в искомом числе меньше k цифр, то выведите само число без ведущих нулей.
public class FibonacciByModule {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int count = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            int fibonacci = getFibonacciByModule(count, k);
            writer.write(String.valueOf(fibonacci));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getFibonacciByModule(int count, int k) {
        int divider = (int) Math.pow(10, k);
        int value = 1;
        int prev = 1;
        int temp;
        for (int i = 2; i <= count; i++) {
            temp = value;
            value = (value + prev) % divider;
            prev = temp;
        }

        return value;
    }
}
