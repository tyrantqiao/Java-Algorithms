package leetcode;

import java.util.HashMap;

/**
 * @author TyrantQiao
 * 2018/4/24
 * @version 0.0.1
 * Description: two number sum
 * blog https://tyrantqiao.com
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class TwoSum {
	/**
	 * 注意HashMap的put(Key,Value)是可以替换旧值的，所以当我们遇到测试数据中包含重复数值时可以无视它。
	 * 所以其实判断条件里面的map.get(supplement)!=i其实也是可以无视的，因为我们的value已经更新为后面的值了
	 * @param nums
	 * @param target
	 * @return
	 */
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
