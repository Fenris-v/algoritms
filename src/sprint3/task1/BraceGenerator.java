package sprint3.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Рита по поручению Тимофея наводит порядок в правильных скобочных последовательностях (ПСП), состоящих только из
// круглых скобок (). Для этого ей надо сгенерировать все ПСП длины 2n в алфавитном порядке —– алфавит состоит из ( и )
// и открывающая скобка идёт раньше закрывающей.
// Помогите Рите —– напишите программу, которая по заданному n выведет все ПСП в нужном порядке.
// Рассмотрим второй пример. Надо вывести ПСП из четырёх символов. Таких всего две:
// (())
// ()()
// (()) идёт раньше ()(), так как первый символ у них одинаковый, а на второй позиции у первой ПСП стоит (, который
// идёт раньше ).
//
// Формат ввода
// На вход функция принимает n — целое число от 0 до 10.
//
// Формат вывода
// Функция должна напечатать все возможные скобочные последовательности заданной длины в алфавитном
// (лексикографическом) порядке.
public class BraceGenerator {
    private static StringBuilder stringBuilder;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int limit = Integer.parseInt(reader.readLine());
            stringBuilder = new StringBuilder();
            generate(limit, "", 0, 0);
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void generate(int n, String string, int left, int right) {
        if (left == n && right == n) {
            stringBuilder.append(string).append("\n");
            return;
        }

        if (left < n) {
            generate(n, string + "(", left + 1, right);
        }

        if (right < left) {
            generate(n, string + ")", left, right + 1);
        }
    }
}
