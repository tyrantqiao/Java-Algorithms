import org.junit.jupiter.api.Test;

import static leetcode.WordSearch.findWords;

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
		char[][] test = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
		String[] words = {"oath", "pea", "eat", "rain"};

		System.out.println(findWords(test, words));
	}
}
