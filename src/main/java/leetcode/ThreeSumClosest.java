package leetcode;

import java.util.Arrays;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class ThreeSumClosest {
    /**
     * 与threeSum类似，通过双指针寻找最小值，这里应注意的是比较时用每次的和tempSum进行比较
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        int tempSum = 0;
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                tempSum = nums[i] + nums[lo] + nums[hi];

                if (tempSum > target) {
                    hi--;
                } else if (tempSum < target) {
                    lo++;
                } else {
                    return target;
                }
                if (Math.abs(tempSum - target) < Math.abs(result - target)) {
                    result = tempSum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {1, 1, 1, 0};
        System.out.print(threeSumClosest.threeSumClosest(nums, 5));
    }
}
