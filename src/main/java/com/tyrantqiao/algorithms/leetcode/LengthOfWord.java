package com.tyrantqiao.algorithms.leetcode;

/**
 * @author tyrantqiao
 * date: 2018/11/14
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class LengthOfWord {
    final String STR_EMPTY="";
    final String STR_SPACE=" ";

    /**
     * split函数分开拿最后的
     * 在使用equals，要注意用字符串调用对象，eg："".equals(object)，避免object为null时产生错误，而不返回想要的false
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (STR_EMPTY.equals(s) || STR_SPACE.equals(s)) {
            return 0;
        }

        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }

    public static void main(String[] args) {
        LengthOfWord lengthOfWord = new LengthOfWord();
        System.out.println(lengthOfWord.lengthOfLastWord("ddwd feegrg"));
    }
}
