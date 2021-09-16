package com.tyrantqiao.algorithms.leetcode;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class RomanToInteger {
	/**
	 * 这种做法的核心在于，减的情况是只有一个，比如说IV是只会出现一次的，毕竟两个两个IV（4）=VIII（8）了
	 * 通过用String.indexOf()函数查询是否存在，若不存在返回-1
	 * 对于其他情况正常+每个字母对应的数字即可
	 *
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		int sum = 0;
		if (s.indexOf("IV") != -1) {sum -= 2;}
		if (s.indexOf("IX") != -1) {sum -= 2;}
		if (s.indexOf("XL") != -1) {sum -= 20;}
		if (s.indexOf("XC") != -1) {sum -= 20;}
		if (s.indexOf("CD") != -1) {sum -= 200;}
		if (s.indexOf("CM") != -1) {sum -= 200;}

		char[] romanChars = s.toCharArray();
		int count = 0;

		for (; count <= s.length() - 1; count++) {
			if (romanChars[count] == 'M') {
				sum += 1000;
			}
			if (romanChars[count] == 'D') {
				sum += 500;
			}
			if (romanChars[count] == 'C') {
				sum += 100;
			}
			if (romanChars[count] == 'L') {
				sum += 50;
			}
			if (romanChars[count] == 'X') {
				sum += 10;
			}
			if (romanChars[count] == 'V') {
				sum += 5;
			}
			if (romanChars[count] == 'I') {
				sum += 1;
			}

		}

		return sum;
	}

	/**
	 * 用两个数组进行存储，一个用于检索当前字符是什么，另一个用来存储每一个字母代表什么
	 * 核心在于，当后者大于当前数字时，当前数字就*-1,变为负的
	 *
	 * @param s
	 * @return
	 */
	public int romanToIntFastest(String s) {
		char[] romanChars = s.toCharArray();
		int[] romanInts = new int[s.length()];
		int i = 0;
		while (i < s.length()) {
			if (romanChars[i] == 'M') {
				romanInts[i] = 1000;
			}
			if (romanChars[i] == 'D') {
				romanInts[i] = 500;
			}
			if (romanChars[i] == 'C') {
				romanInts[i] = 100;
			}
			if (romanChars[i] == 'L') {
				romanInts[i] = 50;
			}
			if (romanChars[i] == 'X') {
				romanInts[i] = 10;
			}
			if (romanChars[i] == 'V') {
				romanInts[i] = 5;
			}
			if (romanChars[i] == 'I') {
				romanInts[i] = 1;
			}
			i++;
		}
		int result = 0;
		i = 0;
		while (i < s.length()) {
			if (i + 1 < s.length() && romanInts[i + 1] > romanInts[i]) {
				romanInts[i] *= -1;
			}
			result += romanInts[i];
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		RomanToInteger romanToInteger = new RomanToInteger();
		String test = "VIII";
		System.out.print(romanToInteger.romanToIntFastest(test));
	}
}
