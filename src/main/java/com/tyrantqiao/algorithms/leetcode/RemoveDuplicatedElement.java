package com.tyrantqiao.algorithms.leetcode;

/**
 * @author tyrantqiao
 * date: 2018/10/26
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class RemoveDuplicatedElement {
    /**
     * 答案：两个指针，一个为按从小到大顺序走，另外一个按不等于这个数字的指针走，后者负责遍历全部
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        int left = 0, right = 1;

        while (right < size) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }

    public int removeDuplicateElement(int[] nums){
        return 0;
    }

    public static void main(String[] args) {
        RemoveDuplicatedElement removeDuplicatedElement = new RemoveDuplicatedElement();
        System.out.println(removeDuplicatedElement.removeDuplicates(new int[]{2, 3, 3, 4}));
    }
}
