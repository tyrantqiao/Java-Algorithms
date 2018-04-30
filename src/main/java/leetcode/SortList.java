package leetcode;

/**
 * @author tyrantqiao
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null) {
			return head;
		}
		if (head.next == null) {
			return head;
		}
		//int size=getListNodeSize(head);
		ListNode index, prev, half;
		index = head;
		prev = head;
		half = head;

		while (index != null && index.next != null) {
			prev = half;
			half = half.next;
			index = index.next.next;
		}

		prev.next = null;

		ListNode h1 = sortList(head);
		ListNode h2 = sortList(half);
		return mergeListNode(h1, h2);
	}

	public ListNode mergeListNode(ListNode nodeA, ListNode nodeB) {
		if (nodeA == null) {
			return nodeB;
		}
		if (nodeB == null) {
			return nodeA;
		}
		if (nodeA.val > nodeB.val) {
			nodeB.next = mergeListNode(nodeA, nodeB.next);
			return nodeB;
		} else {
			nodeA.next = mergeListNode(nodeA.next, nodeB);
			return nodeA;
		}
	}


	public int getListNodeSize(ListNode head) {
		int size = 0;
		while (head.next != null) {
			size++;
			head = head.next;
		}
		return size;
	}
}
