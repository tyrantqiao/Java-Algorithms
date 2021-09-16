package leetcode;

import com.tyrantqiao.algorithms.leetcode.LearnListNodeService;
import com.tyrantqiao.algorithms.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author tyrantqiao
 */
class LearnListNodeServiceTest {
    LearnListNodeService learnListNodeService = new LearnListNodeService();

    @Test
    void testReverseKGroup_2() {
        ListNode testListNode = learnListNodeService.generateListNode(5);
        ListNode result = learnListNodeService.reverseKGroup(testListNode, 2);
        System.out.println(result);
        assertEquals(1, result.val);
    }

    @Test
    void testReverseIteration_to3() {
        ListNode testListNode = learnListNodeService.generateListNode(5);

        ListNode endNode = testListNode;
        for (int i = 0; i < 3; i++) {
            endNode = endNode.next;
        }

        ListNode reverseNode = learnListNodeService.reverseIteration(testListNode, endNode);
        System.out.println(reverseNode);
        assertEquals(2, reverseNode.val);
    }

    @Test
    void testReverseIteration_all() {
        ListNode testListNode = learnListNodeService.generateListNode(5);
        ListNode reverseNode = learnListNodeService.reverseIteration(testListNode, null);
        System.out.println(reverseNode);
        assertEquals(5, reverseNode.val);
    }

    @Test
    public void testReverseRange() {
        ListNode testListNode = learnListNodeService.generateListNode(5);
        System.out.println(learnListNodeService.reverseRange(testListNode, 2, 1));
    }

    @Test
    public void testReversePreN() {
        ListNode testListNode = learnListNodeService.generateListNode(10);
        System.out.println(learnListNodeService.reversePreN(testListNode, 3));
    }

    @Test
    public void testReverse() {
        ListNode testListNode = learnListNodeService.generateListNode(10);
        System.out.println(learnListNodeService.reverseRecursion(testListNode));
    }

    @Test
    void testReverse_empty() {
        ListNode result = learnListNodeService.reverseRecursion(new ListNode(0, null));
        assertEquals(new ListNode(0, null), result);
    }

    @Test
    public void testGenerateListNode() {
        ListNode result = learnListNodeService.generateListNode(5);
        System.out.println(result);
    }

    @Test
    void testGenerateListNode_empty() {
        ListNode result = learnListNodeService.generateListNode(0);
        assertEquals(new ListNode(0, null), result);
    }

    @Test
    void testAdd() {
        learnListNodeService.add(new ListNode(0, null), 0);
    }
}
