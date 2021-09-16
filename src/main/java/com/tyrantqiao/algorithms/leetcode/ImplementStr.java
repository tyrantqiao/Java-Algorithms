package com.tyrantqiao.algorithms.leetcode;

/**
 * @author tyrantqiao
 * date: 2018/10/29
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class ImplementStr {
    /**
     * 骚的要死的答案，两个for，第一个做index，第二个用来遍历needle，还能通过两个指针相加判断是否超长了？
     * 通过第二个指针判断是否超长了
     * 通过两个指针的比较，判断是否相等，完美啊。。。
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        for (int index = 0; ; index++) {
            for (int needleIndex = 0; ; needleIndex++) {
                if (needleIndex == needle.length()) {
                    return index;
                }
                if (needleIndex + index == haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(index+needleIndex) != needle.charAt(needleIndex)) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        ImplementStr implementStr = new ImplementStr();
        System.out.println(implementStr.strStr("dsss", "ds"));
    }
}
