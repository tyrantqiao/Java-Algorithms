package leetcode;

/**
 * 学习ListNode$
 * <p>
 * 创建时间： 2021/3/31 20:34
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
public class LearnListNodeService {
    /**
     * 反向链表【递归版】
     * <p>
     * 这么理解：
     * 1️⃣ 当头节点调用reverse(head.next)时，本质是为了拿到最后的last节点，而这个last节点是反转之后的头节点！
     * PS: 此处要搞懂一件事情，原本链表的流向是 head -> B -> C -> last，当执行完后会变成head <- B <- C <- last
     * 2️⃣ head.next.next=head 的目的在于为了将链表反向
     * 本来head.next 的 .next是指向null的，就比如last节点的next肯定是null的，现在我们要做的就是反向，把last的next变成它的上一节点
     * 于是有了 c <- last
     * 3️⃣ head.next = null 这一步也是核心，在于把原本正向的连接改成了null，方便后面进行反向
     * 比如说C原本的next节点是last
     * 未执行3️⃣时，流程图是这样子的：   C < - > last
     * c.next.next [last] = c
     * c.next = last
     * 但这明显不是我们想要的结果，我们要的是反向且单向的链表，而不是双向链表，所以我们要把c.next=last的正向链表拆断，于是有了下面结果
     * null <- c <- last
     *
     * @param head 头节点
     * @return 反向
     */
    public ListNode reverseRecursion(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode last = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    /**
     * 翻转链表【迭代版本】
     * 区间为 [a,b)
     *
     * @param head 头节点
     * @param n    指定节点
     * @return 翻转链表
     */
    public ListNode reverseIteration(ListNode head, ListNode n) {
        ListNode pre, cur, next;
        pre = null;
        cur = head;

        while (cur != n) {
            //    暂存cur的后续节点
            next = cur.next;

            //    开始翻转
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * N+1的节点，即无需反向的链表节点
     * <p>
     * 比如说1->2->3->4->5 只需要前三个时
     * 那successor就为4->5
     */
    ListNode successor = null;

    /**
     * 将前n个节点进行翻转
     * <p>
     * successor主要就是场外用于永久存储后驱节点，主要是递归里面没办法保存这个信息
     * <p>
     * 重点解释下head.next.next=head 和head.next =successor
     * 1️⃣ head.next.next=head  这个就不解释了，只是为了翻转，和上面解释的一样
     * 2️⃣ 重点在这里，把所有翻转链表时的节点都指向后驱节点，但因为在递归时，第一步会把第二步的next指向successor的干掉
     * 所以最终只会有N个节点的开头会指向successor
     * <p>
     * 比如说 1-> 2->3 ->4 ->5 翻转3个
     * 第一个找到3的next即4->5 存储为successor
     * 然后进行翻转
     * successor <- 2 < - 3
     * 这一步无疑不是我们想要的，但是别急，下一步递归时就会清除
     * successor <- 1 <- 2 <- 3
     * 成功只有1才指向了successor
     *
     * @param head 头节点
     * @param n    需要翻转的数量
     * @return 翻转链表
     */
    public ListNode reversePreN(ListNode head, int n) {
        if (n == 0) {
            successor = head.next;
            return head;
        }

        ListNode last = reversePreN(head.next, --n);
        head.next.next = head;
        head.next = successor;

        return last;
    }

    /**
     * 翻转区间内的值
     *
     * @param head  头节点
     * @param begin 开始
     * @param end   结尾
     * @return 翻转后结果
     */
    public ListNode reverseRange(ListNode head, int begin, int end) {
        if (begin == 1) {
            return reversePreN(head, end);
        }

        head.next = reverseRange(head.next, begin - 1, end - 1);
        return head;
    }

    //public ListNode reverseKGroup(ListNode head, int groupSize) {
    //    if (groupSize == 0) {
    //        return reverseRange(head, 0, groupSize - 1);
    //    }
    //
    //    head.next = reverseKGroup(head.next, groupSize--);
    //}


    /**
     * 产生列表node
     *
     * @param size 大小
     * @return 链表
     */
    public ListNode generateListNode(int size) {
        ListNode head = new ListNode(0);
        for (int i = 1; i <= size; i++) {
            add(head, i);
        }
        return head;
    }

    /**
     * 添加节点
     *
     * @param listNode 根
     * @param data     数据
     */
    public void add(ListNode listNode, int data) {
        while (true) {
            if (listNode.next == null) {
                listNode.next = new ListNode(data);
                break;
            }
            listNode = listNode.next;
        }
    }
}
