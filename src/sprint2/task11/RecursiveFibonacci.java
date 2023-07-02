package sprint2.task11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// У Тимофея было n (0 ≤ n ≤ 32) стажёров. Каждый стажёр хотел быть лучше своих предшественников, поэтому i-й стажёр
// делал столько коммитов, сколько делали два предыдущих стажёра в сумме. Два первых стажёра были менее
// инициативными —– они сделали по одному коммиту.
// Пусть Fi —– число коммитов, сделанных i-м стажёром (стажёры нумеруются с нуля). Тогда выполняется следующее:
// F0 = F1 = 1. Для всех i ≥ 2 выполнено Fi = Fi − 1 + Fi − 2.
// Определите, сколько кода напишет следующий стажёр –— найдите Fn.
// Решение должно быть реализовано рекурсивно.
//
// Формат ввода
// На вход подаётся n — целое число в диапазоне от 0 до 32.
//
// Формат вывода
// Нужно вывести Fn.
public class RecursiveFibonacci {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int count = Integer.parseInt(reader.readLine());
            int fibonacci = getFibonacci(count);
            writer.write(String.valueOf(fibonacci));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getFibonacci(int count) {
        if (count < 2) {
            return 1;
        }

        return getFibonacci(count - 1) + getFibonacci(count - 2);
    }
}
