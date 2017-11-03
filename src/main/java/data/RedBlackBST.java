package data;


public class RedBlackBST<Key extends Comparable<Key>, Value> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;

	public RedBlackBST() {
	}

	/**
	 * @param x higher to lower
	 * @return Node
	 */
	private Node rotateLeft(Node x) {
		Node h = x.right;
		x.right = h.left;
		h.left = x;
		h.color = x.color;
		x.color = RED;
		h.size = x.size;
		x.size = size(x.left) + size(x.right) + 1;
		return h;
	}

	/**
	 * @param x higher to lower
	 * @return node
	 */
	private Node rotateRight(Node x) {
		Node temp = x.left;
		x.left = temp.right;
		temp.right = x;
		temp.color = x.color;
		x.color = RED;
		temp.size = x.size;
		x.size = size(x.left) + size(x.right) + 1;
		return temp;
	}

	/**
	 * @param key   index
	 * @param value data(value) save to tree's index
	 */
	public void put(Key key, Value value) {
		root = put(root, key, value);
		root.color = BLACK;
	}

	/**
	 * @param node tree-root
	 * @return update-tree
	 */
	public Node put(Node node, Key key, Value value) {
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

	/**
	 * @param node make the left-and-right color to black, and the root's color converting.
	 */
	private void flipColor(Node node) {
		node.color = !node.color;
		node.left.color = !node.left.color;
		node.right.color = !node.right.color;

	}

	/**
	 * @param index index(use the next is true) this can help hide the true code.
	 */
	public void getKey(int index) {
		if (index < 0 || index > root.size)
			throw new IllegalArgumentException("index is out of range:" + root.size);
		getKey(root, index);
	}

	/**
	 * @param x     node
	 * @param index index (not sure why when index<current we need to minus index and 1 to current
	 * @return key
	 */
	public Key getKey(Node x, int index) {
		int current = size(x.left);
		if (index > current) return getKey(x.right, index);
		else if (index < current) return getKey(x.left, index - current - 1);
		else return x.key;
	}

	public Node getNode(int k) {
		if (k < 0 || k >= size()) {
			throw new IllegalArgumentException("argument to getNode() is invalid: " + k);
		}
		return getNode(root, k);
	}

	/**
	 * @param x     node
	 * @param index index(same as before code)
	 * @return node
	 */
	private Node getNode(Node x, int index) {
//        if (x == null) return null;
//        assert(index >= 0 && index < size(x));
		int current = size(x.left);
		if (index > current) return getNode(x.right, index - current - 1);
		else if (index < current) return getNode(x.left, index);
		else return x;
	}

	public void print() {
		print(root, "");
	}

	public void printTree() {
		System.out.print("root--" + root.key + " val:" + root.val);
		Node next = root;
		int tabs = 1;
		while (next.hasNext()) {
			System.out.println('\t');
			Node temp=next;

			while (next.left.hasNext()) {
				for (int i = 0; i < tabs; i++) {
					System.out.print('\t');
				}
				next = next.left;
				System.out.print("└── " + next.key + " val:" + next.val);
			}
		}
	}


	private void print(Node x, String prefix) {
		if (x == null) return;
		System.out.println("└── " + "key:" + x.key + " val:" + x.val);
		for (int i = 0; i < size(x) - 1; i++) {
			Node next = getNode(i);
			if (next == null) return;
			System.out.println("\t|──");
			while (size(next.right) > 1) System.out.print(" key:" + next.key + " value" + next.val);
			if (size(next) != 1) System.out.println("└── ");
			System.out.println(("├── ") + "key:" + next.key + " val:" + next.val);
		}
//            if (children.size() > 0) {
//                children.get(children.size() - 1)
//                        .print(prefix + (isTail ? "    " : "│   "), true);
//            }
	}

	private int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) return 0;
		return node.size;
	}

	private boolean isRed(Node x) {
		if (x == null) return false;
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

		private boolean hasNext() {
			return size > 1;
		}
	}


}
