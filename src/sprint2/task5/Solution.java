package sprint2.task5;

// Вася решил запутать маму —– делать дела в обратном порядке. Список его дел теперь хранится в двусвязном списке.
// Напишите функцию, которая вернёт список в обратном порядке.
// Внимание: в этой задаче не нужно считывать входные данные. Нужно написать только функцию, которая принимает на
// вход голову двусвязного списка и возвращает голову перевёрнутого списка. Ниже дано описание структуры, которая задаёт
// вершину списка.
//
// Решение надо отправлять только в виде файла с расширением, которое соответствует вашему языку. Иначе даже
// корректно написанное решение не пройдёт тесты.
//
// Формат ввода
// Функция принимает на вход единственный аргумент — голову двусвязного списка.
// Длина списка не превосходит 1000 элементов. Список не бывает пустым.
//
// Формат вывода
// Функция должна вернуть голову развернутого списка.
class Node<V> {
    public V value;
    public Node<V> next;
    public Node<V> prev;

    public Node(V value, Node<V> next, Node<V> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}

public class Solution {
    public static Node<String> solution(Node<String> head) {
        Node<String> nextNode = head;
        Node<String> temp;
        while (nextNode.next != null) {
            temp = nextNode.prev;
            nextNode.prev = nextNode.next;
            nextNode.next = temp;
            nextNode = nextNode.prev;
        }

        nextNode.next = nextNode.prev;
        nextNode.prev = null;

        return nextNode;
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null, null);
        Node<String> node2 = new Node<>("node2", node3, null);
        Node<String> node1 = new Node<>("node1", node2, null);
        Node<String> node0 = new Node<>("node0", node1, null);
        node1.prev = node0;
        node2.prev = node1;
        node3.prev = node2;
        Node<String> newNode = solution(node0);
        assert newNode == node3;
        assert node3.next == node2;
        assert node2.next == node1;
        assert node2.prev == node3;
        assert node1.next == node0;
        assert node1.prev == node2;
        assert node0.prev == node1;
    }
}
