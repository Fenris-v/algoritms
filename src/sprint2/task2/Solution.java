package sprint2.task2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// Васе нужно распечатать свой список дел на сегодня. Помогите ему: напишите функцию, которая печатает все его дела.
// Известно, что дел у Васи не больше 5000.
// Внимание: в этой задаче не нужно считывать входные данные. Нужно написать только функцию, которая принимает на
// вход голову списка и печатает его элементы. Ниже дано описание структуры, которая задаёт узел списка.
//
// Решение надо отправлять только в виде файла с расширением, которое соответствует вашему языку. Иначе даже
// корректно написанное решение не пройдет тесты.
//
// Формат ввода
// В качестве ответа сдайте только код функции, которая печатает элементы списка. Длина списка не превосходит
// 5000 элементов. Список не бывает пустым.
//
// Формат вывода
// Функция должна напечатать элементы списка по одному в строке.
class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}

public class Solution {
    public static void solution(Node<String> head) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            Node<String> node = head;
            do {
                writer.write(node.value);
                writer.newLine();
                node = node.next;
            } while (node != null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        solution(node0);
    }
}
