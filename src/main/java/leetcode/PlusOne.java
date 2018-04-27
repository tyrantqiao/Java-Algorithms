package leetcode;

/**
 * Created By TyrantQiao on 2018/4/27
 *
 * @version 0.0.1
 * Description: int[] plus one
 * blog https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class PlusOne {
	/**
	 * 核心是通过判断加起来是否为十，是否到末位了？是否需要扩增？
	 * @param digits
	 * @return
	 */
	public static int[] plusOne(int[] digits) {
		int N = digits.length;
		int i = N;
		while (i > 0 && (digits[--i] = digits[i] + 1) == 10) {
			digits[i] = 0;
			if (i == 0) {
				int[] resizeArray = new int[N + 1];
				for (int j = 0; j < N; j++) {
					resizeArray[j + 1] = digits[j];
				}
				resizeArray[0] = 1;
				return resizeArray;
			}
		}
		return digits;
	}
}
