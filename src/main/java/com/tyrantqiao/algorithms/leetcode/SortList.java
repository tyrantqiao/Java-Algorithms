package com.tyrantqiao.algorithms.leetcode;

/**
 * @author tyrantqiao
 */
public class SortList {
    /**
     * 排序链表：要求O（nlogn）
     * 先用指针做出个从一半开始的指针half，再去掉head的后半部分
     * 将二者排序后融合，实现O（nlogn）的需求
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        //int size=getListNodeSize(head);
        ListNode allIndex, prev, half;
        allIndex = head;
        prev = head;
        half = head;

        while (allIndex != null && allIndex.next != null) {
            prev = half;
            half = half.next;
            allIndex = allIndex.next.next;
        }
        //使得head只剩下前半部分了
        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(half);
        return mergeListNode(left, right);
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
