package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author tyrantqiao
 * date: 2019/5/23
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class Sort {
    /**
     * 先算，替换，再用插排走一次O(n^2)
     *
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
            int temp = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > temp) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = temp;
        }
        return A;
    }

    /**
     * 比较左右指针，依次插入新的int[]中，迭代一次，O(n)，空间O(n)
     *
     * @param A
     * @return
     */
    public int[] sortedSquares2(int[] A) {
        int left = 0, right = A.length - 1;
        int index = A.length - 1;
        int[] result = new int[A.length];
        while (left <= right) {
            if (Math.abs(A[left]) < Math.abs(A[right])) {
                result[index] = A[right] * A[right];
                right--;
            } else {
                result[index] = A[left] * A[left];
                left++;
            }
            index--;
        }
        return result;
    }

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
        System.out.println(Arrays.toString(sort.sortedSquares2(new int[]{-2, 0, 2, 4})));
    }
}
