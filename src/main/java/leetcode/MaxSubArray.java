package leetcode;

/**
 * @author tyrantqiao
 * date: 2018/11/14
 * blog: tyrantqiao.com
 * contact: tyrantqiao@icloud.com
 */
public class MaxSubArray {
    /**
     * 两个指针来迭代实现O(n)，subArrSum用来记录子数组大小与当前i所指的值大小比较
     * 比如若subArrSum此时为负数，导致subArrSum+nums[i]<nums[i]则此时可以更换为新的开头指针nums[i]了
     *
     * @param nums 数组
     * @return 返回最大子数组的和
     */
    private int maxSubArray(int[] nums) {
        int result = nums[0], subArrSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            subArrSum = Math.max(subArrSum + nums[i], nums[i]);
            result = Math.max(subArrSum, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testNums = {1, -1, 1, -1, 1, -1, -1, 1, 1, 1, 1};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(testNums));
    }
}
