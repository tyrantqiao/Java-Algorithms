package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TyrantQiao
 *
 * @version 0.0.1
 * Description: Three number sum = 0
 * blog https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class ThreeSum {
	/**
	 * 思路大概是我们通过i，将数组划分为一个个小的two sum查找，同时也对重复元素进行处理。o(n^2)
	 *
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		Arrays.sort(nums);
		int n = nums.length;
		int notIterate = 2;
		for (int i = 0; i + notIterate < n; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int lo = i + 1, hi = n - 1;
			int target = nums[i];
			while (lo < hi) {
				if (nums[lo] + nums[hi] + target == 0) {
					result.add(Arrays.asList(nums[lo], nums[hi], target));

					while (lo < hi && nums[lo] == nums[lo + 1]) { lo++;}
					while (lo < hi && nums[hi] == nums[hi - 1]) { hi--;}
					lo++;
					hi--;
				} else if (nums[lo] + nums[hi] + target > 0) {hi--;} else {lo++;}
			}

		}
		return result;
	}
}
