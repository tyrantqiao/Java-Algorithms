package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TyrantQiao
 * @version 0.0.1
 * Description: Three number sum = 0
 * blog https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class ThreeSum {
    /**
     * 思路大概是我们通过i，将数组划分为一个个小的two sum查找，同时也对重复元素进行处理。o(n^2)
     * 同时由于我们对数组排序了，所以当我们迭代时，发现结果大于0时，可以通过降低hi来逼近0值，反之升高lo值
     * a b c d e
     * 迭代时通过lo和hi指针进行，lo=target+1,hi=size-1所以当target到倒数第三个元素时就迭代结束了【notIterate=2】
     * 新增：同时通过判断最大组合决定是否继续迭代，最小组合决定有无必要继续迭代
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        int size = nums.length;
        int notIterate = 2;
        for (int i = 0; i + notIterate < size; i++) {
            //判断index位以及最后两个门神的和与0的比较，若小于0，则当前位的最大sum都比不过，换下一个index+1了
            if (nums[i] + nums[size - 1] + nums[size - 2] < 0) {
                continue;
            }
            //若当前index的前三位最小组合都大于0，那就没必要继续迭代了，直接break即可
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }

            //若元素一样，则通过continue使得i往后迭代
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //两个指针，注意此处lo=i+1
            int lo = i + 1, hi = size - 1;
            int target = nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] + target == 0) {
                    result.add(Arrays.asList(nums[lo], nums[hi], target));

                    //若元素相等，指针移动
                    while (lo < hi && nums[lo] == nums[lo + 1]) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == nums[hi - 1]) {
                        hi--;
                    }
                    //而因为添加了结果，所以指针得移动
                    lo++;
                    hi--;
                    //此处为！！核心处！！当加的结果为正值时，hi下降，反之lo上升
                } else if (nums[lo] + nums[hi] + target > 0) {
                    hi--;
                } else {
                    lo++;
                }
            }

        }
        return result;
    }
}
