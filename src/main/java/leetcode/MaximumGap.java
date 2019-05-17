package leetcode;

import java.util.Arrays;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 * https://leetcode.com/problems/maximum-gap/description/
 */
public class MaximumGap {
	/**
	 * 排序获得最大间隙
	 *
	 * @param nums
	 * @return
	 */
	public int maximumGap(int[] nums) {
		int singleNum=2;
		if(nums.length<singleNum){
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
