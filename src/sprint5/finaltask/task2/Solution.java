package sprint5.finaltask.task2;

/**
 * id: 89746931
 */
/*
-- ПРИНЦИП РАБОТЫ --
Метод удаления принимает на вход корень дерева и значение, узел с которым, необходимо удалить из дерева.
Сначала происходит поиск узла для удаления, где на каждом шаге сохраняется его родительский узел.

Когда удаляемый узел будет найден, будет произведен поиск замены для этого узла. Если у этого узла менее 2х дочерних
узлов, тогда искать новый узел нет необходимости, узел просто заменяется единственным существующим узлом или null'ом,
если у него нет дочерних узлов.

Если у удаляемого узла есть 2 дочерних, тогда для замены выбирается самый правый узел из левого поддерева. В случае,
если у самого правого узла левого поддерева есть дочерние узлы слева, они назначаются родителю этого узла, если нет,
то узел просто заменяется на null.

В конце значение найденного для замены узла записывается на место удаляемого узла.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Временная сложность удаления узла из дерева будет O(h) в худшем случае, где h - высота дерева.

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Пространственная сложность хранения дерева будет O(n), где n - количество элементов.

Пространственная сложность удаления узла будет константной O(1), т.к. метод создаёт несколько переменных для работы
метода, которые просто перезаписываются при каждом спуске по дереве.
 */
public class Solution {
    public static Node remove(Node root, int key) {
        if (root == null) {
            return null;
        }

        Node currentNode = root;
        Node prevNode = null;
        while (currentNode != null && currentNode.getValue() != key) {
            prevNode = currentNode;
            currentNode = currentNode.getValue() > key ? currentNode.getLeft() : currentNode.getRight();
        }

        if (currentNode == null) {
            return root;
        } else if (currentNode.getLeft() == null || currentNode.getRight() == null) {
            Node temp = currentNode.getLeft() == null ? currentNode.getRight() : currentNode.getLeft();
            if (prevNode == null) {
                return temp;
            } else if (key < prevNode.getValue()) {
                prevNode.setLeft(temp);
            } else {
                prevNode.setRight(temp);
            }

            return root;
        }

        Node parent = null;
        Node temp = currentNode.getLeft();
        while (temp.getRight() != null) {
            parent = temp;
            temp = temp.getRight();
        }

        if (parent != null) {
            parent.setRight(temp.getLeft());
        } else {
            currentNode.setLeft(temp.getLeft());
        }

        currentNode.setValue(temp.getValue());

        return root;
    }
}

class Node {
    private int value;
    private Node left;
    private Node right;

    Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
