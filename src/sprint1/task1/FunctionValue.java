package sprint1.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Вася делает тест по математике: вычисляет значение функций в различных точках. Стоит отличная погода, и друзья
// зовут Васю гулять. Но мальчик решил сначала закончить тест и только после этого идти к друзьям. К сожалению, Вася
// пока не умеет программировать. Зато вы умеете. Помогите Васе написать код функции, вычисляющей y = ax2 + bx + c.
// Напишите программу, которая будет по коэффициентам a, b, c и числу x выводить значение функции в точке x.
//
// Формат ввода
// На вход через пробел подаются целые числа a, x, b, c. В конце ввода находится перенос строки.
//
// Формат вывода
// Выведите одно число — значение функции в точке x.
public class FunctionValue {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            int result = calculate(a, x, b, c);
            writer.write(String.valueOf(result));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(int a, int x, int b, int c) {
        return a * x * x + b * x + c;
    }
}
