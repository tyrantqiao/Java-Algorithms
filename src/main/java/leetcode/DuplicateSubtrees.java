package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tyrantqiao
 */
public class DuplicateSubtrees {
	private final static int DISTINCT = 1;
	private final static int DUPLICATE = 2;

	/***
	 *  通过递归来获得最终答案.
	 * @param root
	 * @return result
	 */
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<String, Integer>(16);
		postTreeNode(root, map, result);
		return result;
	}

	/**
	 * 核心在于生成每一条支树的序列号,而这个东西只需要最基本的数据即可,其他的东西都可以不加(耗时,但为了美化时可加)
	 * 然后在存储时,把值设为1,1才是判断的基本,因为这是第一次,而在下一次的遍历时也可能重复了,所以要进行判断,避免重复了.
	 *
	 * @param root   节点
	 * @param map    用于存放每一节的东西
	 * @param result 结果
	 * @return 每一次的值
	 */
	private String postTreeNode(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
		if (root == null) {
			return "$";
		}
		String serial = root.val + postTreeNode(root.left, map, result) + postTreeNode(root.right, map, result);
		if (!map.containsKey(serial)) {
			map.put(serial, DISTINCT);
		} else {
			if (map.get(serial) < DUPLICATE) {
				map.put(serial, DUPLICATE);
				result.add(root);
			}
		}
		return serial;
	}

}
