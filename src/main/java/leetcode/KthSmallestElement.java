package leetcode;

import org.junit.jupiter.api.Test;

/**
 * Created By TyrantQiao on 2018/4/24
 *
 * @version 0.0.1
 * Description: Kth Smallest Element in a Sorted Matrix
 * blog https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class KthSmallestElement {
	/**
	 * 1ms answer from jiangbowei2010
	 * use binary algorithms to search whole matrix. from matrix[0][0] to matrix[n-1][n-1]
	 *
	 * @param matrix testMatrix
	 * @param k      kth
	 * @return matrix's kth num
	 */
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
		while (lo <= hi) {
			//when low equal to high, mid=low, then no change.
			int mid = lo + (hi - lo) / 2;
			int count = getLessEqual(matrix, mid);
			if (count < k)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return lo;
	}

	/**
	 * To get the nearest index which is the index of the mid number.
	 *
	 * @param matrix testMatrix
	 * @param val    mid
	 * @return index
	 */
	private int getLessEqual(int[][] matrix, int val) {
		int res = 0;
		int n = matrix.length;
		for (int i = n - 1, j = 0; i >= 0 && j < n; ) {
			if (matrix[i][j] > val)
				i--;
			else {
				res += i + 1;
				j++;
			}
		}
		return res;
	}

//	public int kthSmallest(int[][] matrix, int k) {
//		List<Integer> list = new ArrayList<>();
//		for (int[] row : matrix)
//			for (int num : row)
//				list.add(num);
//		list.sort(Comparator.naturalOrder());
//		return list.get(k - 1);
//	}

	@Test
	public void test() {
		int[][] test = {{1, 2}, {1, 5}};
		System.out.println(kthSmallest(test, 4));
	}
}
