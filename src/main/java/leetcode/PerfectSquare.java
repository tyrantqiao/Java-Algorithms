package leetcode;

/**
 * @author TyrantQiao
 * date: 2018/4/29
 *
 * @version 0.0.1
 * Description: return how many square can sum to target
 * blog https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class PerfectSquare {
	public static int numSquares(int n) {
		if (n <= 0) {
			return 0;
		}
		int maxBasic = (int) Math.sqrt(n) + 1;
//		if (maxBasic * maxBasic == n) return maxBasic;
		int res = 0, temp = n;
		while (temp > 0 && maxBasic > 0) {
			int square = maxBasic * maxBasic;
			int nums = temp / square;
			res += nums;
			temp = temp % square;
			maxBasic--;
		}
		return res;
	}
}
