package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tyrantqiao
 */
class LearnListNodeTest {
    LearnListNode learnListNode = new LearnListNode();

    @Test
    public void testReverseRange() {
        ListNode testListNode = learnListNode.generateListNode(10);
        System.out.println(learnListNode.reverseRange(testListNode,2,3));
    }

    @Test
    public void testReversePreN() {
        ListNode testListNode = learnListNode.generateListNode(10);
        System.out.println(learnListNode.reversePreN(testListNode,3));
    }

    @Test
    public void testReverse() {
        ListNode testListNode = learnListNode.generateListNode(10);
        System.out.println(learnListNode.reverse(testListNode));
    }

    @Test
    void testReverse_empty() {
        ListNode result = learnListNode.reverse(new ListNode(0, null));
        Assertions.assertEquals(new ListNode(0, null), result);
    }

    @Test
    public void testGenerateListNode() {
        ListNode result = learnListNode.generateListNode(5);
        System.out.println(result);
    }

    @Test
    void testGenerateListNode_empty() {
        ListNode result = learnListNode.generateListNode(0);
        Assertions.assertEquals(new ListNode(0, null), result);
    }

    @Test
    void testAdd() {
        learnListNode.add(new ListNode(0, null), 0);
    }
}
