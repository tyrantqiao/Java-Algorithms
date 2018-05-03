package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description: tree traversal: preOrder, inorder, postOrder, WFS
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/description/"></a>
 *
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class BinaryTreeTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		getNodeByInorderIterative(root, result);
		return result;
	}

	/**
	 * use stack to save the last element, and then pop, we save left element first, the latest left element will
	 * pop first, then is the mid element, we would put the right element by {@code node=node.right}
	 * @param node
	 * @param res
	 */
	private void getNodeByInorderIterative(TreeNode node, List<Integer> res) {
		Stack<TreeNode> treeNodeStack = new Stack<>();
		do {
			while (node != null) {
				treeNodeStack.push(node);
				node = node.left;
			}
			if(!treeNodeStack.isEmpty()){
				node=treeNodeStack.pop();
				res.add(node.val);
				node=node.right;
			}
		}
		while (!treeNodeStack.isEmpty()||node!=null);
	}

	private void getNodeByInorderRecursive(TreeNode node, List<Integer> res) {
		if (node == null) {
			return;
		}
		getNodeByInorderRecursive(node.left, res);
		res.add(node.val);
		getNodeByInorderIterative(node.right, res);
	}
}
