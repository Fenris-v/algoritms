package sprint1.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Представьте себе онлайн-игру для поездки в метро: игрок нажимает на кнопку, и на экране появляются три случайных
// числа. Если все три числа оказываются одной чётности, игрок выигрывает.
// Напишите программу, которая по трём числам определяет, выиграл игрок или нет.
//
// Формат ввода
// В первой строке записаны три случайных целых числа a, b и c. Числа не превосходят 109 по модулю.
//
// Формат вывода
// Выведите «WIN», если игрок выиграл, и «FAIL» в противном случае.
public class EvenOddNumbers2 {
    public final static String WIN = "WIN";
    public final static String FAIL = "FAIL";

    public static void main(String[] args) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            boolean isWin = checkNumbers(a, b, c);
            bufferedWriter.write(isWin ? WIN : FAIL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean checkNumbers(int a, int b, int c) {
        int y = Math.abs(a % 2) + Math.abs(b % 2) + Math.abs(c % 2);
        return y == 0 || y == 3;
    }
}
