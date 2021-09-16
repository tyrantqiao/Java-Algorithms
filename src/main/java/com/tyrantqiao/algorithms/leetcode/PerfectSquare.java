package com.tyrantqiao.algorithms.leetcode;

import java.util.Arrays;

/**
 * @author TyrantQiao
 * date: 2018/4/29
 * @version 0.0.1
 * Description: return how many square can sum to target
 * blog https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class PerfectSquare {
	/**
	 * 运用动态的思想，通过将每一个小值储存起来，dp[0]=0,dp[1]=1````然后我们可以通过dp[k-j*j]+1取得对应的相加个数
	 *
	 * @param n
	 * @return
	 */
	public static int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			int j = 1;
			while (i - j * j >= 0) {
				min = Math.min(min, dp[i - j * j] + 1);
				++j;
			}
			dp[i] = min;
		}
		return dp[n];
	}

}
