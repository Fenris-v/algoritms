package sprint1.task6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Помогите Васе понять, будет ли фраза палиндромом‎. Учитываются только буквы и цифры, заглавные и строчные буквы
// считаются одинаковыми.
// Решение должно работать за O(N), где N — длина строки на входе.
//
// Формат ввода
// В единственной строке записана фраза или слово. Буквы могут быть только латинские. Длина текста не превосходит
// 20000 символов.
// Фраза может состоять из строчных и прописных латинских букв, цифр, знаков препинания.
//
// Формат вывода
// Выведите «True», если фраза является палиндромом, и «False», если не является.
public class Palindrome {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String sentence = reader.readLine();
            boolean isPalindrome = isPalindrome(sentence);
            writer.write(isPalindrome ? "True" : "False");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isPalindrome(String sentence) {
        sentence = sentence.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reversedSentence = new StringBuilder(sentence).reverse().toString();

        return sentence.equals(reversedSentence);
    }
}
