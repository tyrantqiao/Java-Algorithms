package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tyrant
 */
public class FourSum {
    /**
     * 本质是在three sum以及two sum的基础上做了迭代
     * 不过在一些判断条件上学习了其他人方法
     * 预先判断最大值，第index位以及后几位判断是否大于target，若大于则没必要继续比，因为数组排序的了
     * 同理取前面几位判断大小，决定是否需要continue
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int minFourSumSize = 4;
        if (nums.length < minFourSumSize) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        var results = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            } else if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                } else if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) {
                    continue;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    int tempSum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (tempSum == target) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    }
                    if (tempSum > target) {
                        high--;
                    } else if (tempSum < target) {
                        low++;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] testNums = {1, -1, 2, -2, 0, 0, 1, 2, 4, -4, -3, 2, 1};
        int target = 0;
        System.out.print(fourSum(testNums, target));
    }
}
