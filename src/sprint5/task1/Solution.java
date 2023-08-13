package sprint5.task1;

// Гоша повесил на стену гирлянду в виде бинарного дерева, в узлах которого находятся лампочки. У каждой лампочки есть
// своя яркость. Уровень яркости лампочки соответствует числу, расположенному в узле дерева. Помогите Гоше найти самую
// яркую лампочку в гирлянде, то есть такую, у которой яркость наибольшая.
//
// Формат ввода
// На вход подается корень дерева.
//
// Формат вывода
// Функция должна вернуть максимальное значение яркости в узле дерева.
public class Solution {
    public static int treeSolution(Node head) {
        int max = head.value;
        if (head.left != null) {
            max = Math.max(treeSolution(head.left), max);
        }

        if (head.right != null) {
            max = Math.max(treeSolution(head.right), max);
        }

        return max;
    }

    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(2);
        node4.left = node3;
        assert treeSolution(node4) == 3;
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
}
