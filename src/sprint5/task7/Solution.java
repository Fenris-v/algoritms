package sprint5.task7;

public class Solution {
    public static int treeSolution(Node head) {
        if (head == null) {
            return 0;
        }

        int sumLeft = getMaxSum(head.left, 0);
        int sumRight = getMaxSum(head.right, 0);

        if (head.value + sumLeft < 0 || head.value + sumRight < 0) {
            return Math.max(sumLeft, sumRight);
        }

        return 0;
    }

    private static int getMaxSum(Node node, int sum) {

        return 0;
    }

    // <template>
    private static class Node {
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
    // <template>


    private static void test() {
        Node node1 = new Node(5, null, null);
        Node node2 = new Node(1, null, null);
        Node node3 = new Node(-3, node2, node1);
        Node node4 = new Node(2, null, null);
        Node node5 = new Node(2, node4, node3);
        assert treeSolution(node5) == 6;
    }
}
