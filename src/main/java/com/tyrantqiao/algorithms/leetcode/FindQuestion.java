package com.tyrantqiao.algorithms.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author tyrantqiao
 * date: 2019/5/25
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class FindQuestion {
    /**
     * 这道题我觉得设置的有问题，题目要求的是不在合适位置的数字数量，而实际上要的是  变成递增数列所需移动的数字次数。
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int result = 0;
        int[] check = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != check[i]) {
                result++;
            }
        }
        return result;
    }

    /**
     * 这个其实也就找重复的元素，而其他元素都是不重复的，所以只要返回map里面存在的key就可以了，所以其实就不用记录出现次数
     *
     * @param A
     * @return
     */
    public int repeatedNTimes2(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : A) {
            if (!map.containsKey(ele)) {
                map.put(ele, 0);
            } else {
                return ele;
            }
        }
        return 0;
    }

    /**
     * 借用hashMap和getOrDefault实现出现次数的记录
     *
     * @param A
     * @return
     */
    public int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : A) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                return key;
            }
        }

        return 0;
    }
}
