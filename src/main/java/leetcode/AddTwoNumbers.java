package leetcode;

/**
 * 双指针迭代，当有一个仍有子节点时继续，而另外一个则让它使用默认值0来相加，若最后迭代完了但仍有进位，则应新建一个。
 *
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode current = result;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int x = (l1 == null) ? 0 : l1.val;
			int y = (l2 == null) ? 0 : l2.val;

			int sum = x + y + carry;
			carry = sum / 10;
			current.next = new ListNode(sum % 10);
			current = current.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry > 0) {
			current.next = new ListNode(carry);
		}
		return result.next;
	}
}
