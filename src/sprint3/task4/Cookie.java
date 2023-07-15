package sprint3.task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// К Васе в гости пришли одноклассники. Его мама решила угостить ребят печеньем.
// Но не всё так просто. Печенья могут быть разного размера. А у каждого ребёнка есть фактор жадности — минимальный
// размер печенья, которое он возьмёт. Нужно выяснить, сколько ребят останутся довольными в лучшем случае, когда они
// действуют оптимально.
// Каждый ребёнок может взять не больше одного печенья.
//
// Формат ввода
// В первой строке записано n — количество детей.
// Во второй — n чисел, разделённых пробелом, каждое из которых — фактор жадности ребёнка. Это натуральные числа,
// не превосходящие 1000.
// В следующей строке записано число m –— количество печенек.
// Далее — m натуральных чисел, разделённых пробелом — размеры печенек. Размеры печенек не превосходят 1000.
// Оба числа n и m не превосходят 10000.
//
// Формат вывода
// Нужно вывести одно число –— количество детей, которые останутся довольными
public class Cookie {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int[] children = getValues(Integer.parseInt(reader.readLine()), reader.readLine());
            int[] cookie = getValues(Integer.parseInt(reader.readLine()), reader.readLine());
            Arrays.sort(children);
            Arrays.sort(cookie);
            int countHappyChild = countHappyChild(children, cookie);
            writer.write(String.valueOf(countHappyChild));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getValues(int size, String str) {
        int[] values = new int[size];
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        for (int i = 0; i < size; i++) {
            values[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return values;
    }

    private static int countHappyChild(int[] children, int[] cookie) {
        int cookieIndex = 0;
        int count = 0;
        for (int child : children) {
            while (true) {
                if (cookieIndex == cookie.length - 1) {
                    return child <= cookie[cookieIndex] ? count + 1 : count;
                }

                if (child <= cookie[cookieIndex++]) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
