package sprint5.task2;

// Гоше очень понравилось слушать рассказ Тимофея про деревья. Особенно часть про сбалансированные деревья. Он решил
// написать функцию, которая определяет, сбалансировано ли дерево.
// Дерево считается сбалансированным, если левое и правое поддеревья каждой вершины отличаются по высоте не больше,
// чем на единицу.
public class Solution {
    public static boolean treeSolution(Node head) {
        if (head == null) {
            return true;
        }

        int minHeight = getMinHeight(head);
        int maxHeight = getMaxHeight(head);

        return maxHeight - minHeight < 2;
    }

    private static int getMinHeight(Node head) {
        if (head.left == null || head.right == null) {
            return 1;
        }

        return Math.min(getMinHeight(head.left), getMinHeight(head.right)) + 1;
    }

    private static int getMaxHeight(Node head) {
        if (head == null) {
            return 0;
        } else if (head.left == null && head.right == null) {
            return 1;
        }

        return Math.max(getMaxHeight(head.left), getMaxHeight(head.right)) + 1;
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
