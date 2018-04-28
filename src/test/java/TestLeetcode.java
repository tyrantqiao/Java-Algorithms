import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static leetcode.ThreeSum.threeSum;

/**
 * Created By TyrantQiao on 2018/4/27
 *
 * @version 0.0.1
 * Description:
 * blog https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class TestLeetcode {
	@Test
	public void test() {
//		int[] testArr = new Random().ints(15, -5, 5).toArray();
//		Arrays.stream(testArr).forEach(System.out::println);
		int[] leetcodeTest = {1, -1, -1, 0};
		List<List<Integer>> result = threeSum(leetcodeTest);
		System.out.println(result);
	}
}
