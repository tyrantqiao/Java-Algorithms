package com.tyrantqiao.algorithms.leetcode;

/**
 * 程序员面试金典学习
 */
public class InterviewProblem {
    public boolean isUnique(String astr) {
        int[] lowerChars = new int[26];
        for (int i = 0; i < 26; i++) {
            lowerChars[i] = 0;
        }

        int index = 0;
        while (index <= astr.length() - 1) {
            int charLocation = astr.charAt(index) - 'a';
            if (lowerChars[charLocation] != 0) {
                return false;
            }
            lowerChars[charLocation] = lowerChars[charLocation] + 1;
            index++;
        }
        return true;
    }
}
