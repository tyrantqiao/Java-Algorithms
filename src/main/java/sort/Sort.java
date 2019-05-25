package sort;

import java.util.Arrays;

/**
 * @author tyrantqiao
 * date: 2019/5/13
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class Sort {
    public int[] quickSort(int[] nums, int left, int right) {
        getKeySort(nums, left, right);
        return nums;
    }

    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public void getKeySort(int[] nums, int left, int right) {
        if (left >= right || nums == null || nums.length <= 1) {
            return;
        }
        int temp = nums[left];
        int head = left, tail = right;
//        每次都将left作为temp值进行比较，分出小于堆和大于堆
        while (left <= right) {
            while (nums[left] < temp) {
                left++;
            }
            while (nums[right] > temp) {
                right--;
            }
            if (left < right) {
                swap(nums, right, left);
                left++;
                right--;
//                当相等时，让left++
            } else if (left == right) {
                ++left;
            }
        }
        getKeySort(nums, head, right);
        getKeySort(nums, left, tail);
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        System.out.println(Arrays.toString(new Sort().quickSort(nums, 0, nums.length - 1)));
    }
}
