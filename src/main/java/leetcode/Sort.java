package leetcode;

import java.util.Arrays;

/**
 * @author tyrantqiao
 * date: 2019/5/23
 * blog: tyrantqiao.com
 * contact: tyrantqiao@icloud.com
 */
public class Sort {
    /**
     * 主要是做两个指针，左边负责排查是否为偶数，右边排查奇数，当卡住时，则二者交替，若left等于right了，说明已经检查完了
     * 没有继续检查的必要，left自加就跳出了循环。换成break也是一样的效果
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            while (left < right && A[left] % 2 == 0) {
                left++;
            }
            while (left < right && A[right] % 2 == 1) {
                right--;
            }
            if (left < right) {
                swap(A, left, right);
                left++;
                right--;
            } else if (left == right) {
                left++;
            }
        }
        return A;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        System.out.println(Arrays.toString(sort.sortArrayByParity(new int[]{0, 2, 4})));
    }
}
