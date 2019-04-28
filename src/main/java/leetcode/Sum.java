package leetcode;

import java.util.*;

/**
 * @author tyrant
 */
public class Sum {
    /**
     * 注意HashMap的put(Key,Value)是可以替换旧值的，所以当我们遇到测试数据中包含重复数值时可以无视它。
     * 所以其实判断条件里面的map.get(supplement)!=i其实也是可以无视的，因为我们的value已经更新为后面的值了
     *
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
