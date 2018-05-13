package leetcode;

/**
 * <a href="https://leetcode.com/problems/symmetric-tree/description/">question</a>
 *
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return compareByRecurse(root, root);
	}

	/**
	 * 通过将一个树变为两个树，再逐一判断左右节点即可，核心在于：compare(root,root)
	 * @param left
	 * @param right
	 * @return
	 */
	private boolean compareByRecurse(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		return left.val == right.val && compareByRecurse(left.left, right.right) && compareByRecurse(left.right, right.left);
	}
}
