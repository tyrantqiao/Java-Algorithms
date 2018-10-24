package leetcode;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 * 最基本的链表结构，用于给leetcode链表题目做垫底用，当需要空结点时new ListNode(0)，再用这个结点.next()连接到数据即可
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        ListNode tempNode = this;
        while (tempNode != null) {
            stringBuffer.append(tempNode.val);
            stringBuffer.append("->");
            tempNode = tempNode.next;
        }
        stringBuffer.append("null");
        return stringBuffer.toString();
    }
}
