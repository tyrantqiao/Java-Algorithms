package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class CopyListWithRandomNode {
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) { this.label = x; }
	}

	/**
	 * 通过双指针，一个负责存结果【root】，一个负责迭代即【head】
	 *
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomListFastest(RandomListNode head) {
		if (head == null) {
			return null;
		}
		RandomListNode root = new RandomListNode(head.label);
		RandomListNode result = root;
		while (head != null) {
			if (head.random != null) {
				root.random = new RandomListNode(head.random.label);
			} else {
				root.random = null;
			}

			if (head.next != null) {
				root.next = new RandomListNode(head.next.label);
			} else {
				root.next = null;
			}
			root = root.next;
			head = head.next;
		}
		return result;
	}

	/**
	 * 通过map来实现栈的put和get，再依次的放入相应的值
	 *
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		// loop 1. copy all the nodes
		RandomListNode node = head;
		while (node != null) {
			map.put(node, new RandomListNode(node.label));
			node = node.next;
		}

		// loop 2. assign next and random pointers
		node = head;
		while (node != null) {
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}

		return map.get(head);
	}
}
