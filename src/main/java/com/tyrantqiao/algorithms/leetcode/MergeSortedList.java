package com.tyrantqiao.algorithms.leetcode;

/**
 * @author tyrantqiao
 * date: 2018/10/24
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class MergeSortedList {
    /**
     * 递归，通过l1=mergeTwoLists(l1.next,l2)往下递归
     * 当l1走到头时直接返回l2即可，以此类推。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListFastest(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode left = l1;
        ListNode right = l2;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if (left != null) {
            temp.next = left;
        } else if (right != null) {
            temp.next = right;
        }
        return result.next;
    }

    public static void main(String[] args) {
        MergeSortedList mergeSortedList = new MergeSortedList();
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        System.out.println(mergeSortedList.mergeTwoListFastest(l1, l2));
    }

}
