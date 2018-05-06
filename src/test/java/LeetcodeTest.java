import org.junit.jupiter.api.Test;

import static leetcode.LongestCommonPrefix.longestCommonPrefix;


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

		String[] strings = {"abcdef", "bcdef", "cde", "de", "e"};
		System.out.println(longestCommonPrefix(strings));
	}
}
