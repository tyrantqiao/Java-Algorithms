package leetcode;

import org.junit.jupiter.api.Test;

/**
 * cannot use brute(time limit) need Cache to make it.
 */
public class NumMatrix {
	private int[][] cacheArr;

	public NumMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return;
		cacheArr = new int[matrix.length][matrix[0].length + 1];
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				cacheArr[row][col+1] = matrix[row][col] + cacheArr[row][col];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		for (int row = row1; row <= row2; row++) {
			sum += cacheArr[row][col2 + 1] - cacheArr[row][col1];
		}
		return sum;
	}

	/**
	 *
	 *   private int[][] dp;

		 public NumMatrix(int[][] matrix) {
		 if (matrix.length == 0 || matrix[0].length == 0) return;
		 dp = new int[matrix.length + 1][matrix[0].length + 1];
		 for (int r = 0; r < matrix.length; r++) {
		 for (int c = 0; c < matrix[0].length; c++) {
		 dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
		 }
		 }
		 }

		 public int sumRegion(int row1, int col1, int row2, int col2) {
		 return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
		 }
	 */


	/**
	 * double dimension array use {{}}
	 */
	@Test
	void test() {
		int [][] nums={{1,2,7},{2,3,1},{3,6,4},{4,6,2}};
		NumMatrix obj=new NumMatrix(nums);
		int param1=obj.sumRegion(1,1,2,2);
		System.out.println(param1);
	}
}
