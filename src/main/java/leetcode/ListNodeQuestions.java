package leetcode;

import java.util.*;

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
     *
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null) {
            return result;
        }

        // 将root作为tail节点加入，若为首时则加做首first
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            // DFS
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            result.add(0, subList);
        }
        return result;
    }
}
