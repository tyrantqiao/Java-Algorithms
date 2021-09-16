package com.tyrantqiao.algorithms.leetcode;

/**
 * @author tyrantqiao
 * date: 2018/10/18
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 **/
public class RemoveNthFromEnd {
    /**
     * 首先容易混淆的一点是head=head.next，会将head这个对象变为了head.next对象
     * 打个比方a->b->c->d->e，执行head=head.next，只是head本来装着a，现在变成了装b，若没有备份或则像向前的指针，那么a就没了
     * O(2L-n)=O(L)
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //创建指向head的dummyHead指针，由于我们通过判断.next等不等于null来计算，则最后一个数无法记录，所以这里创建
        //一个无作用的数0的头部，加入计算长度
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        //遍历一遍，记录链表长度
        int length = 0;
        ListNode currentNode = dummyHead;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            length++;
        }
        //取0头的原因见如下
        currentNode = dummyHead;

        //与nth相减，得出要移开的元素位置，通过currentNode.next=currentNode.next.next删除那个结点
        //与计算长度同理，若按照length与0的计算，由于先进行.next的递进，会导致多挪了一位，所以这里一样要加入无用的0头
        length -= n;
        while (length > 0) {
            currentNode = currentNode.next;
            length--;
        }
        currentNode.next = currentNode.next.next;

        //从dummyHead还原结果
        return dummyHead.next;
    }

    /**
     * 真正的OnePass，O(L) 核心在于我们通过打一个时间n差的两个结点，当第一个结点为null时，则第二个结点可设置为
     * 要remove掉的结点前一位，则执行next=.next.next即可完成操作，然后输出dummyHead.next结果即可
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndOnePass(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode second = dummyHead;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummyHead.next;
    }
}
