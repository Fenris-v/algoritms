package sprint5.task3;

// Гоша и Алла играют в игру «Удивительные деревья». Помогите ребятам определить, является ли дерево, которое им
// встретилось, деревом-анаграммой?
// Дерево называется анаграммой, если оно симметрично относительно своего центра.

public class Solution {
    public static boolean treeSolution(Node head) {
        return isEqualSubtrees(head.left, head.right);
    }

    private static boolean isEqualSubtrees(Node left, Node right) {
        if (left == null || right == null) {
            return left == right;
        } else if (left.value != right.value) {
            return false;
        } else if (!isEqualSubtrees(left.left, right.right)) {
            return false;
        } else {
            return isEqualSubtrees(left.right, right.left);
        }
    }

    private static void test() {
        Node node1 = new Node(3, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(4, null, null);
        Node node4 = new Node(3, null, null);
        Node node5 = new Node(2, node1, node2);
        Node node6 = new Node(2, node3, node4);
        Node node7 = new Node(1, node5, node6);
        assert treeSolution(node7);
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
