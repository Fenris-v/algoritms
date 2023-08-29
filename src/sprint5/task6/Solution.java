package sprint5.task6;

// Алла хочет побывать на разных островах архипелага Алгосы. Она составила карту. Карта представлена в виде дерева:
// корень обозначает центр архипелага, узлы –— другие острова. А листья —– это дальние острова, на которые Алла хочет
// попасть.
//
// Помогите Алле определить максимальное число островов, через которые ей нужно пройти для совершения одной поездки от
// стартового острова до места назначения, включая начальный и конечный пункты.
public class Solution {
    public static void main(String[] args) {
        test();
    }

    public static int treeSolution(Node head) {
        if (head == null) {
            return 0;
        }

        return getMaxHeight(head, 0);
    }

    private static int getMaxHeight(Node node, int height) {
        if (node == null) {
            return height;
        }

        int leftHeight = getMaxHeight(node.left, height + 1);
        int rightHeight = getMaxHeight(node.right, height + 1);

        return Math.max(leftHeight, rightHeight);
    }

    private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        assert treeSolution(node5) == 3;
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
