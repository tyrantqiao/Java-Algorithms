package leetcode;

import java.util.Arrays;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 * https://leetcode.com/problems/maximum-gap/description/
 */
public class MaximumGap {
	public int maximumGap(int[] nums) {
		if(nums.length<2){
			return 0;
		}

		Arrays.sort(nums);
		int result=0;
		for(int i=1;i<nums.length;i++){
			result=Integer.max(result,Math.abs(nums[i]-nums[i-1]));
		}
		return result;
	}
}
