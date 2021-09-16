package com.tyrantqiao.algorithms.leetcode;

/**
 * @author tyrantqiao
 * date: 2018/11/7
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class SearchInsert {
    /**
     * 二分法查找插入位置
     *
     * @param nums   数组
     * @param target 插入值
     * @return 该插入的位置
     */
    private int searchInsert(int[] nums, int target) {
        int high = nums.length - 1, low = 0;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(new int[]{1, 2, 3, 6, 8}, 4));
    }
}
