package sprint2.task4;

// Мама Васи хочет знать, что сын планирует делать и когда. Помогите ей: напишите функцию solution, определяющую
// индекс первого вхождения передаваемого ей на вход значения в связном списке, если значение присутствует.
// Внимание: в этой задаче не нужно считывать входные данные. Нужно написать только функцию, которая принимает на
// вход голову списка и искомый элемент, а возвращает целое число — индекс найденного элемента или -1.
//
// Решение надо отправлять только в виде файла с расширением, которое соответствует вашему языку. Иначе даже
// корректно написанное решение не пройдет тесты.
//
// Формат ввода
// Функция на вход принимает голову односвязного списка и элемент, который нужно найти. Длина списка не превосходит
// 10000 элементов. Список не бывает пустым.
// Следуйте следующим правилам при отправке решений:
// По умолчанию выбран компилятор Make, выбор компилятора в данной задаче недоступен.
//
// Формат вывода
// Функция возвращает индекс первого вхождения искомого элемента в список(индексация начинается с нуля). Если элемент
// не найден, нужно вернуть -1.
class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}

public class Solution {
    public static int solution(Node<String> head, String elem) {
        if (head.value.equals(elem)) {
            return 0;
        }

        Node<String> node = head;
        int index = 0;
        while (node.next != null) {
            node = node.next;
            index++;
            if (node.value.equals(elem)) {
                return index;
            }
        }

        return -1;
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        int idx = solution(node0, "node2");
        assert idx == 2;
    }
}
