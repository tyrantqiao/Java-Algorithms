import leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static leetcode.RevertListNode.reverseListByRecursive;


/**
 * Created By TyrantQiao on 2018/4/27
 *
 * @version 0.0.1
 * Description:
 * blog https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class LeetcodeTest {
	@Test
	public void test() {
		ListNode test = new ListNode(1);
		ListNode test2 = new ListNode(2);
		ListNode test3 = new ListNode(3);
		ListNode test4 = new ListNode(4);
		test.next = test2;
		test2.next = test3;
		test3.next = test4;
		ListNode res=reverseListByRecursive(test);
		System.out.println(res.val);
	}
}
