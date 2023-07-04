package sprint2.finaltask.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * id: 88784753
 */
/*
-- ПРИНЦИП РАБОТЫ --
В качестве стека было принято решение использовать ArrayList, чтобы не нужно было следить за размером стека
самостоятельно. Возможно здесь это лишняя трата памяти и оверинжиниринг, но зато упрощает жизнь. При чтении строки
(токенов) вызывается метод Calculator.execute(String s). Этот метод при помощи регулярного выражения определяет,
является ли переданная строка числом и в зависимости от этого либо добавляет число после конвертации в стек, либо
выполняет математическую операцию.

При выполнении математической операции берутся 2 последних числа из стека, выполняется математическая операция, а
затем последний элемент стека удаляется, а предпоследний заменяется новым значением.

После окончания парсинга строки, вызывается метод Calculator.getResult(), который возвращает последнее число из стека.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Временная сложность линейно зависит от количества переданных аргументов. Получается, время выполнения алгоритма O(n).

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Если учитывать, что на вход обязательно принимается валидная строка (польская нотация) затраты по памяти будут
O(n/2 + 1), соответственно, опуская константы остаётся O(n).
 */
public class Solution {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            Calculator calculator = new Calculator();
            while (stringTokenizer.hasMoreTokens()) {
                calculator.execute(stringTokenizer.nextToken());
            }

            writer.write(String.valueOf(calculator.getResult()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Calculator {
    private final Stack<Integer> stack = new Stack<>();

    public int getResult() {
        return stack.get(stack.size() - 1);
    }

    public void execute(String str) {
        switch (str) {
            case "+":
                plus();
                break;
            case "-":
                minus();
                break;
            case "/":
                divide();
                break;
            case "*":
                multiply();
                break;
            default:
                stack.push(Integer.parseInt(str));
        }
    }

    private void plus() {
        stack.push(stack.pop() + stack.pop());
    }

    private void minus() {
        int value = stack.pop();
        stack.push(stack.pop() - value);
    }

    private void multiply() {
        stack.push(stack.pop() * stack.pop());
    }

    private void divide() {
        int value = stack.pop();
        stack.push(Math.floorDiv(stack.pop(), value));
    }
}
