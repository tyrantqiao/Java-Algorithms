package data;


import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;


    private Node rotateLeft(Node x) {
        Node temp = x.right;
        x.right = temp.left;
        temp.left = x;
        temp.color = x.color;
        x.color = BLACK;
        temp.size = x.size;
        x.size = size(x.left) + size(x.right) + 1;
        return temp;
    }

    private Node rotateRight(Node x) {
        Node temp = x.left;
        x.left = temp.right;
        temp.right = x;
        temp.color = x.color;
        x.color = BLACK;
        temp.size = x.size;
        x.size = size(x.left) + size(x.right) + 1;
        return temp;
    }

    private void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = RED;
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1, RED);

        int cmp = key.compareTo(node.key);
        if (cmp > 0) node.left = put(node.left, key, value);
        else if (cmp < 0) node.right = put(node.right, key, value);
        else node.val = value;

        if (isRed(node.right) && isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColor(node);

        node.size = node.size + 1;
        return node;
    }

    private void flipColor(Node node) {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;

    }

    private int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    private boolean isRed(Node x) {
        return x.color == RED;
    }

    private class Node {
        Key key;
        Value val;
        Node left;
        Node right;
        int size;
        boolean color;

        public Node(Key key, Value val, int size, boolean color) {
            this.key = key;
            this.val = val;
            this.size = size;
            this.color = color;
        }
    }
}
