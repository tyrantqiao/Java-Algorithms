package leetcode;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class RevertListNode {
    ListNode result;

    /**
     * 原理是我们不断递归到子元素，然后返回的是head.next
     * p=head.next
     * 紧接着我们让head.next.next实现revert
     * 但记得把head.next设为null，防止反复circle
     *
     * @param head
     * @return
     */
    public static ListNode reverseListByRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListByRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args){
        ListNode testNode=new ListNode(1);
        testNode.next=new ListNode(2);
        testNode.next.next=new ListNode(3);
        System.out.println(RevertListNode.reverseListByRecursive(testNode));
    }

    /**
     * 先做一次copy为temp，紧接着是next-temp
     * 然后将temp变单个元素，再将temp赋值给res，开始迭代。
     * 通过nextTemp创建新值，并将其.next连上之前的res，实现倒序
     *
     * @param head
     * @return
     */
    public ListNode reverseListByIterate(ListNode head) {
        ListNode res = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode nextTemp = temp.next;
            temp.next = res;
            res = temp;
            temp = nextTemp;
        }
        return res;
    }
}
