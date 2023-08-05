package sprint4.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Гоша написал программу, которая сравнивает строки исключительно по их хешам. Если хеш равен, то и строки равны.
// Тимофей увидел это безобразие и поручил вам сломать программу Гоши, чтобы остальным неповадно было.
// В этой задаче вам надо будет лишь найти две различные строки, которые для заданной хеш-функции будут давать
// одинаковое значение.
//
// Гоша использует следующую хеш-функцию со значениями a = 1000 и m = 123 987 123.
//
// В данной задаче необходимо использовать в качестве значений отдельных символов их коды в таблице ASCII.
//
// Формат ввода
// В задаче единственный тест без ввода
//
// Формат вывода
// Отправьте две строки, по одной в строке. Строки могут состоять только из маленьких латинских букв и не должны
// превышать в длину 1000 знаков каждая. Код отправлять не требуется. Строки из примера использовать нельзя.
// Пример вывода:
// ezhgeljkablzwnvuwqvp
// gbpdcvkumyfxillgnqrv
public class BreakMe {
    private static final long BASIS = 1000;
    private static final long MODULE = 123987123;

    public static void main(String[] args) {
        String str;
        long hash;
        Map<Long, String> hashes = new HashMap<>();
        while (true) {
            str = generateString(20);
            hash = hash(str);
            if (hashes.containsKey(hash)) {
                System.out.println(str);
                System.out.println(hashes.get(hash));
                break;
            }

            hashes.put(hash, str);
        }
    }

    public static String generateString(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = 'a' + (int) (random.nextFloat() * ('z' - 'a' + 1));
            stringBuilder.append((char) randomLimitedInt);
        }

        return stringBuilder.toString();
    }

    private static long hash(String str) {
        int strLength = str.length();
        if (strLength == 0) {
            return 0;
        }

        long hash = (long) str.charAt(0) * BASIS % MODULE;
        for (int i = 1; i < strLength - 1; i++) {
            hash = (hash + str.charAt(i)) * BASIS % MODULE;
        }

        return (hash + str.charAt(strLength - 1)) % MODULE;
    }
}
