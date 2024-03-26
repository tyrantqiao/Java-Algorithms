package com.tyrantqiao.algorithms.lesson;

import com.tyrantqiao.algorithms.find.FindSumNums;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringProblemTest {

    private StringProblem stringProblem;
    @BeforeEach
    void setUp() {
        stringProblem=new StringProblem();
    }


    @Test
    void checkInclusion() {
        boolean result= stringProblem.checkInclusion("ac","dbca");
        System.out.println(result);
        assertTrue(result);
    }

    @Test
    void lengthOfLongestSubString() {
        int result= stringProblem.lengthOfLongestSubString("abcdabcefg");
        System.out.println(result);
        assertEquals(result,7);
    }

    @Test
    void findLongestSubstring() {
        String result=stringProblem.findLongestSubstring("abdabc");
        System.out.println(result);
        assertEquals(result,"abd");
    }
}