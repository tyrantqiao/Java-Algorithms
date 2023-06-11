package com.tyrantqiao.algorithms.find;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 找到数组中等于数字的两个数的下标
 */
public class FindSumNums {
    public int[] twoSums(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right && numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{left, right};
    }

    /**
     * @param numbers
     * @param target
     * @return
     */
    public List<List<Integer>> threeSums(int[] numbers, int target) {
        List<List<Integer>> result = Lists.newArrayList();
        if (numbers.length >= 3) {
            Arrays.sort(numbers);

            int start = 0;
            while (start < numbers.length - 2) {
                twoSums(numbers, start, result, target);

                int temp = numbers[start];
                // 跳过重复的内容
                while (numbers[start] == temp) {
                    start++;
                }
            }
        }
        return result;
    }

    private void twoSums(int[] numbers, int start, List<List<Integer>> result, int target) {
        int left = start + 1;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] + numbers[start] == target) {
                result.add(Lists.newArrayList(numbers[left], numbers[right], numbers[start]));

                int temp = numbers[left];
                while (left < right && numbers[left] == temp) {
                    left++;
                }
            } else if (numbers[left] + numbers[right] + numbers[start] < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    /**
     * 最小和集合
     * @param numbers
     * @param target
     * @return
     */
    public List<Integer> minSumArray(int[] numbers, int target) {
        int left = 0;
        int sum = 0;
        List<Integer> numbersList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        List<Integer> result = Lists.newArrayList();
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < numbers.length; right++) {
            sum += numbers[right];
            while (left < right && sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                result = numbersList.subList(left, right + 1);
                sum -= numbers[left++];
            }
        }
        return result;
    }

//    public List<Integer> minProductArray(int[] numbers, int target){
//        int left=0;
//        int sum=1;
//        List<Integer> numbersList=Arrays.stream(numbers).boxed().collect(Collectors.toList());
//        List<Integer> result=Lists.newArrayList();
//        int minLength=Integer.MAX_VALUE;
//        for(int right=0;right<numbers.length;right++){
//            sum*=numbers[right];
//            while(left<right && sum>=target){
//                minLength=Math.min(right-left+1);
//
//            }
//        }
//    }
}
