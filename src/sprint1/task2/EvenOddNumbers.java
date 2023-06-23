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
public class EvenOddNumbers {
    public final static String WIN = "WIN";
    public final static String FAIL = "FAIL";

    public static void main(String[] args) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            checkNumbers(bufferedWriter, stringTokenizer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void checkNumbers(BufferedWriter bufferedWriter, StringTokenizer stringTokenizer)
            throws IOException {
        boolean isEven = isEven(Integer.parseInt(stringTokenizer.nextToken()));
        for (int i = 0; i < 2; i++) {
            if (isEven != isEven(Integer.parseInt(stringTokenizer.nextToken()))) {
                bufferedWriter.write(FAIL);
                return;
            }
        }

        bufferedWriter.write(WIN);
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }
}
