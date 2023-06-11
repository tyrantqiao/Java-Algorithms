package com.tyrantqiao.algorithms.find;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindSumNumsTest {

    FindSumNums findSumNums;
    @BeforeEach
    void setUp() {
        findSumNums=new FindSumNums();
    }

    @Test
    void twoSums() {
        int[] testResult=new int[]{1,2,4,6,10};
        int[] result = findSumNums.twoSums(testResult, 8);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(new int[]{1,3} , result);
    }

    @Test
    void threeSums() {
        int[] testInputs=new int[]{1,2,3,4,5,6,10};
        List<List<Integer>> result=findSumNums.threeSums(testInputs,8);
        System.out.println(result);
        assertTrue(result.stream().allMatch(arr->arr.stream().reduce(Integer::sum).orElse(0).equals(8)));
    }

    @Test
    void minSubArray() {
        int[] testInputs = new int[]{5,9,4,3,7,6,1,2};
        List<Integer> result = findSumNums.minSumArray(testInputs, 20);
        System.out.println(result);
        assertTrue(result.containsAll(Lists.newArrayList(4,3,7,6)));
    }
}