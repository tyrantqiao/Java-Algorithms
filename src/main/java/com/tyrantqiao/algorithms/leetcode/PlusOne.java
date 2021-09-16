package com.tyrantqiao.algorithms.leetcode;

/**
 * @author TyrantQiao
 * @version 0.0.1
 * Description: int[] plus one
 * blog https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class PlusOne {
	private static final int DECIMAL_CARRY = 10;

	/**
	 * 核心是通过判断加起来是否为十，是否到末位了？是否需要扩增？
	 *
	 * @param digits
	 * @return
	 */
	public static int[] plusOne(int[] digits) {
		int n = digits.length;
		int i = n;
		while (i > 0 && (digits[--i] = digits[i] + 1) == DECIMAL_CARRY) {
			digits[i] = 0;
			if (i == 0) {
				int[] resizeArray = new int[n + 1];
				System.arraycopy(digits, 0, resizeArray, 1, n);
				resizeArray[0] = 1;
				return resizeArray;
			}
		}
		return digits;
	}
}
