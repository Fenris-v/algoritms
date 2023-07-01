package sprint2.task7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Реализуйте класс StackMaxEffective, поддерживающий операцию определения максимума среди элементов в стеке.
// Сложность операции должна быть O(1). Для пустого стека операция должна возвращать None. При этом push(x) и pop()
// также должны выполняться за константное время.
//
// Формат ввода
// В первой строке записано одно число — количество команд, оно не превосходит 100000. Далее идут команды по одной в
// строке. Команды могут быть следующих видов:
// push(x) — добавить число x в стек;
// pop() — удалить число с вершины стека;
// get_max() — напечатать максимальное число в стеке;
// Если стек пуст, при вызове команды get_max нужно напечатать «None», для команды pop — «error».
//
// Формат вывода
// Для каждой команды get_max() напечатайте результат её выполнения. Если стек пустой, для команды get_max()
// напечатайте «None». Если происходит удаление из пустого стека — напечатайте «error».
public class StackMaxEffectiveApplication {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StackMaxEffective stack = new StackMaxEffective();
            int commandCount = Integer.parseInt(reader.readLine());
            for (int i = 0; i < commandCount; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
                Integer value;
                switch (stringTokenizer.nextToken()) {
                    case "get_max":
                        value = stack.getMax();
                        writer.write(value != null ? value + "\n" : "None\n");
                        break;
                    case "pop":
                        value = stack.pop();
                        if (value == null) {
                            writer.write("error\n");
                        }
                        break;
                    case "push":
                        stack.push(Integer.parseInt(stringTokenizer.nextToken()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class StackMaxEffective {
    private final List<Integer> stack = new ArrayList<>();
    private final List<Integer> stackMax = new ArrayList<>();

    public void push(int x) {
        if (stackMax.isEmpty()) {
            stackMax.add(x);
        } else if (stackMax.get(stackMax.size() - 1) > x) {
            stackMax.add(stackMax.get(stackMax.size() - 1));
        } else {
            stackMax.add(x);
        }

        stack.add(x);
    }

    public Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }

        stack.remove(stack.size() - 1);
        return stackMax.remove(stackMax.size() - 1);
    }

    public Integer getMax() {
        if (stackMax.isEmpty()) {
            return null;
        }

        return stackMax.get(stackMax.size() - 1);
    }
}
