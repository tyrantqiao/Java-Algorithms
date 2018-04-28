package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created By TyrantQiao on 2018/4/27
 *
 * @version 0.0.1
 * Description: Three number sum = 0
 * blog https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		Arrays.sort(nums);
		int N = nums.length;
		for (int i = 0; i + 2 < N; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int lo = i + 1, hi = N - 1;
			int target = nums[i];
			while (lo < hi) {
				if (nums[lo] + nums[hi] + target == 0) {
					result.add(Arrays.asList(nums[lo], nums[hi], target));

					while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
					while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
					lo++;
					hi--;
				} else if (nums[lo] + nums[hi] + target > 0) hi--;
				else lo++;
			}

		}
		return result;
	}
}
