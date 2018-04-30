package leetcode;

import java.util.HashMap;

/**
 * @author TyrantQiao
 * 2018/4/24
 * @version 0.0.1
 * Description: two number sum
 * blog https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>(16);
		for (int i = 0; i < nums.length; i++) {
			int supplement = target - nums[i];
			if (map.containsKey(supplement) && map.get(supplement) != i) {
				return new int[]{i, map.get(supplement)};
			}
			map.put(nums[i], i);
		}
		return null;
	}
}
