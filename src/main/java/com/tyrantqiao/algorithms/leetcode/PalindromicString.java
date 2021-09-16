package com.tyrantqiao.algorithms.leetcode;

/**
 * @author tyrantqiao
 */
public class PalindromicString {
	private static int maxLen = 0;
	private static int base = 0;
	private static final int SINGLE = 2;

	/**
	 * 判断两种情况，一是回文从正中间开始，而是左右一样然后向两遍发展。
	 *
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		if (s.length() < SINGLE) {
			return s;
		}
		for (int i = 0; i < s.length(); i++) {
			testPalindromic(s, i, i);
			testPalindromic(s, i, i + 1);
		}
		return s.substring(base, base + maxLen);

	}

	private static void testPalindromic(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
			if (right - left - 1 > maxLen) {
				base = left + 1;
				maxLen = right - left - 1;
			}
//            System.out.println("base:" + base);
//            System.out.println("len:" + maxLen);
		}
	}

	public static void main(String[] args) {
		String result = longestPalindrome("asbbbdbsa");
		System.out.println(result);
	}
}
