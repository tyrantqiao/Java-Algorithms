package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tyrantqiao
 * date: 2019/1/15
 * blog: tyrantqiao.com
 * contact: tyrantqiao@icloud.com
 */
public class ListNodeQuestions {
    /**
     * HashSet，不过如果要返回index下标的话，就换成map来装，当发生重复时则返回下标回去
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<>();
        while (head.next != null) {
            if (listNodeSet.contains(head.next)) {
                return true;
            } else {
                listNodeSet.add(head.next);
                head = head.next;
            }
        }
        return false;
    }

    /**
     * 答案做法O(1)的空间消耗量，时间上O(n)，双节点快速遍历，左节点负责遍历完整一周，右节点快速排查且尽量与左节点见面
     * @param head
     * @return
     */
    public boolean hasCycleTwoNode(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode left = head;
        ListNode right = head.next;
        while (left != right) {
            if (right == null || right.next == null) {
                return false;
            }
            left = left.next;
            right = right.next.next;
        }
        return true;
    }
}
