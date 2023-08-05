package sprint4.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Алле очень понравился алгоритм вычисления полиномиального хеша. Помогите ей написать функцию, вычисляющую хеш
// строки s. В данной задаче необходимо использовать в качестве значений отдельных символов их коды в таблице ASCII.
//
// Формат ввода
// В первой строке дано число a (1 ≤ a ≤ 1000) –— основание, по которому считается хеш.
// Во второй строке дано число m (1 ≤ m ≤ 109) –— модуль.
// В третьей строке дана строка s (0 ≤ |s| ≤ 106), состоящая из больших и маленьких латинских букв.
//
// Формат вывода
// Выведите целое неотрицательное число –— хеш заданной строки.
public class PolynomialHash {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int basis = Integer.parseInt(reader.readLine());
            int module = Integer.parseInt(reader.readLine());
            String str = reader.readLine();
            long hash = hash(str, basis, module);
            writer.write(hash + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long hash(String str, int basis, int module) {
        int strLength = str.length();
        if (strLength == 0) {
            return 0;
        }

        long hash = strLength > 1 ? (long) str.charAt(0) * basis % module : 0;
        for (int i = 1; i < strLength - 1; i++) {
            hash = (hash + str.charAt(i)) * basis % module;
        }

        return (hash + str.charAt(strLength - 1)) % module;
    }
}
