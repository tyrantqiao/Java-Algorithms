package leetcode;

/**
 * @author tyrantqiao
 */
public class FindSingle {
    /**
     * 找出数组中单独存在的数字
     * 因为一堆数字里面仅一个是单数存在的
     * eg: 11 22 33 44 55 6 77 88 99 00
     * 当这个单身数不在自己的队列里面时，nums[2*n]==nums[2*n+1]，每次判断时可以使得start+=2
     * 而若在自己队列时，即比如11 2 33的数列，2与3不相等，本来是应该相等的，现在不等就是因为112的队列
     * 中存在了一个单身数，导致了不相等，所以再让end=mid即可.
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int start = 0, end = len - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            // 若为奇数，则往前推一位进行判断，1->0
            if (mid % 2 == 1) {
                mid--;
            }
            // 进行判断，若相等，则
            if (nums[mid] != nums[mid + 1]) {
                end = mid;
            } else {
                start += 2;
            }
        }
        return nums[start];
    }

    /**
     * 异或做法，1^1=0  1^0=1相同的为0，不同的为不同的数字
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        FindSingle findSingle = new FindSingle();
        int[] testNums = {1, 1, 4, 5, 5};
        System.out.println(findSingle.singleNumber(testNums));
    }
}
