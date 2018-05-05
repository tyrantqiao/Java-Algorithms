import org.junit.jupiter.api.Test;

import static leetcode.FirstMissingPositive.firstMissingPositive;


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
		int[] test = {7, 6, 2, 1, 5};

		int result = firstMissingPositive(test);
		System.out.println(result);
	}
}
