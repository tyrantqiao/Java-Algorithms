package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/"></a>
 * 先从左到右，再右到左，反复添加。
 *
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class BinaryTreeZigzag {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		travel(root, res, 0);
		return res;
	}

	private void travel(TreeNode node, List<List<Integer>> res, int level) {
		if (node == null) {
			return;
		}

		if (res.size() <= level) {
			List<Integer> newLevel = new LinkedList<>();
			res.add(newLevel);
		}

		List<Integer> collection = res.get(level);
		if (level % 2 == 0) {
			collection.add(node.val);
		} else {
			collection.add(0, node.val);
		}

		travel(node.left, res, level + 1);
		travel(node.right, res, level + 1);
	}
}
