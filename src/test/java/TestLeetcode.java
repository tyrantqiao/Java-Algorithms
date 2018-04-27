import leetcode.PlusOne;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

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
	public void test(){
		int[] result=PlusOne.plusOne(new int[]{9});
		for(int i:result)
			System.out.println(i);
	}
}
