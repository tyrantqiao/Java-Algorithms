package testFind;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created By TyrantQiao on 2018/4/26
 *
 * @version 0.0.1 Description: test find method blog
 *          https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class TestFind {
	private int[] testArray = { 2, 45, 23, 5, 1, 54, 65, 34, 75, 34, 234, 54, 65, 46, 1, 35, 75, 0, 24, 6, 868, 456,
			345, 3454, 5, 7, 8, 5, 34, 757, 452, 1, 24, 657, 86, 465, 34, 174, 2623, 25, 626, 266426, 4643, 484, 156,
			4897, 4648, 46848, 1484, 18648, 46841, 78, 15638, 13548, 18461, 86481, 318, 486, 16, 841, 384, 354, 861,
			861, 861, 818512, 15, 6213, 8843, 13, 543, 15, 3154, 51, 34, 21, 381, 5385, 431, 8, 1, 3, 513, 183845, 31,
			534861321, 124, 86, 13, 1, 531, 5, 31, 831, 813, 1, 31, 831, 5, 83, 1, 38, 13183, 1, 318, 3152, 1531, 35131,
			2315317, 61, 38, 43, 1231, 531, 321, 53, 132, 1, 53, 21, 5, 13, 15, 31, 31, 5132, 15, 31, 23153481, 31, 31,
			23, 5, 1, 21, 351313, 13, 13, 21, 513, 13, 13, 1, 32 };

	@Test
	public void test() {
		Arrays.sort(testArray);
		System.out.println(testArray.length);
		System.out.println(Arrays.toString(testArray));
		System.out.println(Arrays.binarySearch(testArray, 45));
	}
}
