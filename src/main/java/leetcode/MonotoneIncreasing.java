package leetcode;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class MonotoneIncreasing {
	/**
	 * 典型测试数据，10，1234【10是如何产生9，1234则是如何递增起来】
	 * 方法一：O(n^2)迭代每一个数字，查询abc与aaa，bbb，ccc的大小比较，若小于，则为比较数字-1,若到了999都比不出来，
	 * 那么就讲字符串添加一个9上去。
	 * 【性能差还有使用string转化的缘故】
	 *
	 * @param N
	 * @return
	 */
	public int monotoneIncreasingDigitsByString(int N) {
		if (N < 10) {
			return N;
		}
		String s = String.valueOf(N);
		String res = "";
		int size = s.length();
		keep:
		for (int i = 0; i < size; i++) {
			for (char c = '1'; c <= '9'; c++) {
				if (s.compareTo(res + findMax(c, size - i)) < 0) {
					res += (char) (c - 1);
					continue keep;
				}
			}
			res += '9';
		}
		return Integer.parseInt(res);
	}

	/**
	 * 造出aaa，bb，c的重复字符串进行比较
	 *
	 * @param c
	 * @param length
	 * @return
	 */
	public String findMax(char c, int length) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < length; i++) {
			result.append(c);
		}
		return result.toString();
	}

	/**
	 * 遇到悬崖时勒马，并进行循环降一打击，直到保证单调性质为主，最后将后面都设为9。
	 * @param N
	 * @return
	 */
	public int monotoneIncreasingDigitsByCliff(int N) {
		int i = 1;
		char[] chars = String.valueOf(N).toCharArray();
		while (i < chars.length && chars[i - 1] <= chars[i]) {
			i++;
		}
		while (i > 0 && i < chars.length && chars[i - 1] > chars[i]) {
			chars[--i] -= 1;
		}
		for (int j = i + 1; j < chars.length; j++) {
			chars[j] = '9';
		}
		return Integer.parseInt(String.valueOf(chars));
	}

	public static void main(String[] args) {
		int testNum = 1234;
		MonotoneIncreasing monotoneIncreasing = new MonotoneIncreasing();
		System.out.print(monotoneIncreasing.monotoneIncreasingDigitsByCliff(testNum));
	}
}
