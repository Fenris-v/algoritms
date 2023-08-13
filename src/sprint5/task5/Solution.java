package sprint5.task5;

// Гоша понял, что такое дерево поиска, и захотел написать функцию, которая определяет, является ли заданное дерево
// деревом поиска. Значения в левом поддереве должны быть строго меньше, в правом — строго больше значения в узле.
// Помогите Гоше с реализацией этого алгоритма.
//
// Формат ввода
// На вход функции подается корень бинарного дерева.
//
// Формат вывода
// Функция должна вернуть True, если дерево является деревом поиска, иначе - False.
public class Solution {
    public static void main(String[] args) {
        test();
    }

    public static boolean treeSolution(Node head) {
        return isSearchTree(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isSearchTree(Node head, int min, int max) {
        if (head == null) {
            return true;
        } else if (min > Integer.MIN_VALUE && head.value <= min || max < Integer.MAX_VALUE && head.value >= max) {
            return false;
        } else if (!isSearchTree(head.left, min, head.value)) {
            return false;
        } else {
            return isSearchTree(head.right, head.value, max);
        }
    }

    private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        assert treeSolution(node5);
        node2.value = 5;
        assert !treeSolution(node5);
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
