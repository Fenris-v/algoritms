package sprint2.task10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Любимый вариант очереди Тимофея — очередь, написанная с использованием связного списка. Помогите ему с реализацией.
// Очередь должна поддерживать выполнение трёх команд:
// - get() — вывести элемент, находящийся в голове очереди, и удалить его. Если очередь пуста, то вывести «error».
// - put(x) — добавить число x в очередь
// - size() — вывести текущий размер очереди
//
// Формат ввода
// В первой строке записано количество команд n — целое число, не превосходящее 1000. В каждой из следующих n строк
// записаны команды по одной строке.
//
// Формат вывода
// Выведите ответ на каждый запрос по одному в строке.
public class LinkListQueueApplication {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int commandCount = Integer.parseInt(reader.readLine());
            StringTokenizer stringTokenizer;
            Node node;
            LinkListQueue queue = new LinkListQueue();
            for (int i = 0; i < commandCount; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                switch (stringTokenizer.nextToken()) {
                    case "get":
                        node = queue.get();
                        writer.write(node == null ? "error\n" : node.getValue() + "\n");
                        break;
                    case "put":
                        queue.put(new Node(Integer.parseInt(stringTokenizer.nextToken())));
                        break;
                    case "size":
                        writer.write(queue.size() + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class LinkListQueue {
    private Node head;
    private Node tail;
    private int size = 0;

    public Node get() {
        if (size == 0) {
            return null;
        }

        if (head.getNext() != null) {
            head.getNext().setPrev(null);
        }

        Node node = head;
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }

        return node;
    }

    public void put(Node node) {
        if (size == 0) {
            head = node;
        }

        if (tail != null) {
            tail.setNext(node);
        }

        node.setPrev(tail);
        tail = node;
        size++;
    }

    public int size() {
        return size;
    }
}

class Node {
    private int value;
    private Node prev;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
