package com.tyrantqiao.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class CopyListWithRandomNode {
    /**
     * 当Map/Set的key为自定义对象时，必须重写hashcode和equals，避免哈希冲突,影响性能
     */
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }

        @Override
        public int hashCode() {
            int result = Integer.hashCode(label);
            result += next.hashCode();
            result += random.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof RandomListNode)) {
                return false;
            }
            RandomListNode randomListNode = (RandomListNode) o;
            return randomListNode.label == label && randomListNode.next == next && randomListNode.random == random;
        }
    }

    /**
     * 通过双指针，一个负责存结果【root】，一个负责迭代即【head】
     *
     * @param head
     * @return
     */
    public RandomListNode copyRandomListFastest(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode root = new RandomListNode(head.label);
        RandomListNode result = root;
        while (head != null) {
            if (head.random != null) {
                root.random = new RandomListNode(head.random.label);
            } else {
                root.random = null;
            }

            if (head.next != null) {
                root.next = new RandomListNode(head.next.label);
            } else {
                root.next = null;
            }
            root = root.next;
            head = head.next;
        }
        return result;
    }

    /**
     * 通过map来实现栈的put和get，再依次的放入相应的值
     *
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        // loop 1. copy all the nodes
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}
