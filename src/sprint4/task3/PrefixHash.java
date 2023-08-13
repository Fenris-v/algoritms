package sprint4.task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Алла не остановилась на достигнутом – теперь она хочет научиться быстро вычислять хеши произвольных подстрок данной
// строки. Помогите ей!
// На вход поступают запросы на подсчёт хешей разных подстрок. Ответ на каждый запрос должен выполняться за O(1).
// Допустимо в начале работы программы сделать предподсчёт для дальнейшей работы со строкой.
// В данной задаче необходимо использовать в качестве значений отдельных символов их коды в таблице ASCII.
//
// Формат ввода
// В первой строке дано число a (1 ≤ a ≤ 1000) –— основание, по которому считается хеш. Во второй строке дано число
// m (1 ≤ m ≤ 107) –— модуль. В третьей строке дана строка s (0 ≤ |s| ≤ 106), состоящая из больших и маленьких
// латинских букв.
// В четвертой строке дано число запросов t –— натуральное число от 1 до 105. В каждой из следующих t строк записаны
// через пробел два числа l и r –— индексы начала и конца очередной подстроки. (1 ≤ l ≤ r ≤ |s|).
//
// Формат вывода
// Для каждого запроса выведите на отдельной строке хеш заданной в запросе подстроки.
public class PrefixHash {
    private static int basis;
    private static int module;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            basis = Integer.parseInt(reader.readLine());
            module = Integer.parseInt(reader.readLine());
            byte[] bytes = reader.readLine().getBytes();
            int commandCount = Integer.parseInt(reader.readLine());
            StringTokenizer stringTokenizer;
            long hash;
            for (int i = 0; i < commandCount; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                hash = hash(bytes,
                            Integer.parseInt(stringTokenizer.nextToken()) - 1,
                            Integer.parseInt(stringTokenizer.nextToken()));
                writer.write(hash + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long hash(byte[] bytes, int from, int to) {
        int length = from - to;
        long hash = length > 1 ? (long) bytes[from++] * basis % module : 0;
        while (from < to - 1) {
            hash = (hash + bytes[from]) * basis % module;
            from++;
        }

        return (hash + bytes[to - 1]) % module;
    }
}
