package com.tyrantqiao.algorithms.lesson;

public class StringProblem {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] counts = new int[26];
        for (int index = 0; index < s1.length(); index++) {
            // 把s1字符串的字母出现都记录了
            counts[s1.charAt(index) - 'a']++;

            // 把s2字符串的字母出现都去掉了 【只去掉了s1的长度】
            counts[s2.charAt(index) - 'a']--;
        }

        if (areAllZero(counts)) {
            return true;
        }

        // ac
        // dca
        // 遍历c
        for (int index = s1.length(); index < s2.length(); index++) {
            // 尝试把s1-s2长度部分都给去掉
            counts[s2.charAt(index) - 'a']--;

            // 这时相当于在s2中遍历的字串右移一位了，所以之前-1的部分可以加回来了
            counts[s2.charAt(index - s1.length()) - 'a']++;

            if (areAllZero(counts)) {
                return true;
            }
        }
        return false;
    }

    private static boolean areAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }


    public int lengthOfLongestSubString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] counts = new int[256];
        int i = 0, j = -1, longest = 1;
        int countDuplicate = 0;
        for (; i < s.length(); i++) {
            // 从第一个字符开始累加
            counts[s.charAt(i)]++;
            if (counts[s.charAt(i)] == 2) {
                countDuplicate++;
            }

            // 如果识别到有大于1的数组
//            while(hasGreaterThan1(counts)){
            while (countDuplicate > 0) {
                // 开始右移字符串，从0下标开始把累计过的字符给去掉
                j++;
                counts[s.charAt(j)]--;
                if (counts[s.charAt(j)] == 1) {
                    countDuplicate--;
                }
            }

            longest = Math.max(i - j, longest);
        }
        return longest;
    }

    private boolean hasGreaterThan1(int[] counts) {
        for (int count : counts) {
            if (count > 1) {
                return true;
            }
        }

        return false;
    }

    public String findLongestSubstring(String text){
        if(text==null||text.length()==1){
            return text;
        }

        int[] counts=new int[256];
        int findDuplicate=-1;
        int subStringBeginIndex=-1;
        int maxLength=Integer.MIN_VALUE;

        String result=text;
        for(int index=0;index<text.length();index++){
            counts[text.charAt(index)]++;

            if(counts[text.charAt(index)]>1){
                findDuplicate=1;
            }

            if(findDuplicate>0){
                if(maxLength<index-subStringBeginIndex){
                    maxLength=index-subStringBeginIndex;
                    subStringBeginIndex++;
                    result=text.substring(subStringBeginIndex,index);
                }
                findDuplicate--;
            }

        }
        return result;
    }
}
