package leetcode;

import org.junit.jupiter.api.Test;

public class MaxXORNumbers {
	/**
	 * ^异或  ~非 
	 * @param nums
	 * @return
	 */
	public int findMaximumXOR(int[] nums) {
		int max=0,min=nums[0];

		return max^min;
	}

	@Test
	public void test(){
		int[] test={1,2,5,2,5,6,7,8};
	}
}
