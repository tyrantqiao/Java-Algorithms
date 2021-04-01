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

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(val);
        result += next.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ListNode)) {
            return false;
        }
        ListNode randomListNode = (ListNode) o;
        return randomListNode.val == val && randomListNode.next == next;
    }

    /**
     * 做一个toString()，方便检查答案是否正确，通过迭代形式迭代出全部节点
     *
     * @return toString
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode tempNode = this;
        while (tempNode != null) {
            stringBuilder.append(tempNode.val);
            stringBuilder.append("->");
            tempNode = tempNode.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }
}
