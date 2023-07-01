package sprint2.task6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Нужно реализовать класс StackMax, который поддерживает операцию определения максимума среди всех элементов в стеке.
// Класс должен поддерживать операции push(x), где x – целое число, pop() и get_max().
//
// Формат ввода
// В первой строке записано одно число n — количество команд, которое не превосходит 10000. В следующих n строках
// идут команды. Команды могут быть следующих видов:
// push(x) — добавить число x в стек;
// pop() — удалить число с вершины стека;
// get_max() — напечатать максимальное число в стеке;
// Если стек пуст, при вызове команды get_max() нужно напечатать «None», для команды pop() — «error».
//
// Формат вывода
// Для каждой команды get_max() напечатайте результат её выполнения. Если стек пустой, для команды get_max()
// напечатайте «None». Если происходит удаление из пустого стека — напечатайте «error».
public class StackMaxApplication {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StackMax stack = new StackMax();
            int commandCount = Integer.parseInt(reader.readLine());
            StringTokenizer stringTokenizer;
            for (int i = 0; i < commandCount; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                Integer value;
                switch (stringTokenizer.nextToken()) {
                    case "get_max":
                        value = stack.getMax();
                        writer.write(value != null ? value + "\n" : "None\n");
                        break;
                    case "push":
                        stack.push(Integer.parseInt(stringTokenizer.nextToken()));
                        break;
                    case "pop":
                        value = stack.pop();
                        if (value == null) {
                            writer.write("error\n");
                        }
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class StackMax {
    private final List<Integer> stack = new ArrayList<>();

    public void push(int x) {
        stack.add(x);
    }

    public Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }

        return stack.remove(stack.size() - 1);
    }

    public Integer getMax() {
        if (stack.isEmpty()) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        for (int value : stack) {
            max = Math.max(max, value);
        }

        return max;
    }
}
