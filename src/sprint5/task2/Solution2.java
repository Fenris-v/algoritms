package sprint5.task2;

public class Solution2 {
    public static boolean treeSolution(Node head) {
        return isBalancedTree(head).isBalanced;
    }

    private static BalanceInfo isBalancedTree(Node node) {
        if (node == null) {
            return new BalanceInfo(true, 0);
        }

        BalanceInfo left = isBalancedTree(node.left);
        BalanceInfo right = isBalancedTree(node.right);

        boolean isCurrentBalanced = Math.abs(left.height - right.height) < 2;
        boolean isSubtreeBalanced = left.isBalanced && right.isBalanced;

        return new BalanceInfo(isCurrentBalanced && isSubtreeBalanced, Math.max(left.height, right.height) + 1);
    }
}

class BalanceInfo {
    boolean isBalanced;
    int height;

    BalanceInfo(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}

//class Node {
//    int value;
//    Node left;
//    Node right;
//
//    Node(int value) {
//        this.value = value;
//        this.left = null;
//        this.right = null;
//    }
//}
