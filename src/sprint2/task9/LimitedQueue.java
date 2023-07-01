package sprint2.task9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Астрологи объявили день очередей ограниченного размера. Тимофею нужно написать класс MyQueueSized, который
// принимает параметр max_size, означающий максимально допустимое количество элементов в очереди.
// Помогите ему —– реализуйте программу, которая будет эмулировать работу такой очереди. Функции, которые надо
// поддержать, описаны в формате ввода.
//
// Формат ввода
// В первой строке записано одно число — количество команд, оно не превосходит 5000.
// Во второй строке задан максимально допустимый размер очереди, он не превосходит 5000.
// Далее идут команды по одной на строке. Команды могут быть следующих видов:
// - push(x) — добавить число x в очередь;
// - pop() — удалить число из очереди и вывести на печать;
// - peek() — напечатать первое число в очереди;
// - size() — вернуть размер очереди;
// При превышении допустимого размера очереди нужно вывести «error». При вызове операций pop() или peek() для пустой
// очереди нужно вывести «None».
//
// Формат вывода
// Напечатайте результаты выполнения нужных команд, по одному на строке.
public class LimitedQueue {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int commandCount = Integer.parseInt(reader.readLine());
            int queueSize = Integer.parseInt(reader.readLine());
            QueueSized queue = new QueueSized(queueSize);
            StringTokenizer stringTokenizer;
            for (int i = 0; i < commandCount; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                try {
                    switch (stringTokenizer.nextToken()) {
                        case "push":
                            queue.push(Integer.parseInt(stringTokenizer.nextToken()));
                            break;
                        case "pop":
                            writer.write(queue.pop() + "\n");
                            break;
                        case "peek":
                            writer.write(queue.peek() + "\n");
                            break;
                        case "size":
                            writer.write(queue.size() + "\n");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    writer.write(e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class QueueSized {
    private final int[] queue;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public QueueSized(int queueSize) {
        queue = new int[queueSize];
    }

    public void push(int x) {
        if (size == queue.length) {
            throw new ArrayIndexOutOfBoundsException("error\n");
        }

        queue[tail] = x;
        tail = tail + 1 == queue.length ? 0 : tail + 1;
        size++;
    }

    public int size() {
        return size;
    }

    public int pop() {
        int value = peek();
        head = head + 1 == queue.length ? 0 : head + 1;
        size--;

        return value;
    }

    public int peek() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("None\n");
        }

        return queue[head];
    }
}
