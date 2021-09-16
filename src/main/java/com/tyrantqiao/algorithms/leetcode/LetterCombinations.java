package com.tyrantqiao.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tyrant
 */
public class LetterCombinations {
    /**
     * 首先惯例的判断空集等，避免递归或者什么操作报错，浪费资源【虽然自己经常忘】
     * 建立相应的手机按键表【九宫格】下标即为相应的按键eg：0-0
     * 然后我们代入合成数字的方法，通过递归来实现
     *
     * @param digits
     * @return
     */
    private static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        String[] lettersDict = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        var results = new ArrayList<String>();
        combineLetters(new StringBuilder(), results, lettersDict, digits, 0);

        return results;
    }

    /**
     * 首先递归要解决如何退出，九宫格输入法，按多少位，形成的字符串就有多少位
     * eg：23-"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
     * 由于顺序无所谓，那么我们就以先打的字符为首位，然后向后添加
     * 首先迭代digits的每一位，比如23，先取2
     * 然后迭代字符表中的字符串，lettersDict[2]即"abc"
     * 用tempCombinedString添加字符，进行下一次递归，添加其他字符
     * eg：a添加d后导致length==2，所以results添加此次结果，并return结束递归
     * 因为这时tempCombinedString是ad，我们只需要它的a，并进行下一次迭代，所以我们删除掉尾字符d
     *
     * @param tempCombinedString
     * @param results
     * @param lettersDict
     * @param digits
     * @param currentCombinedIndex
     */
    private static void combineLetters(StringBuilder tempCombinedString, ArrayList<String> results,
                                       String[] lettersDict, String digits, int currentCombinedIndex) {
        if (currentCombinedIndex == digits.length()) {
            results.add(tempCombinedString.toString());
            return;
        }
        int currentDigit = digits.charAt(currentCombinedIndex) - '0';

        for (int index = 0; index < lettersDict[currentDigit].length(); index++) {
            tempCombinedString.append(lettersDict[currentDigit].charAt(index));
            combineLetters(tempCombinedString, results, lettersDict, digits, currentCombinedIndex + 1);
            tempCombinedString.deleteCharAt(tempCombinedString.length() - 1);
        }
    }

    public static void main(String[] args) {
        String testDigits = "23";
        System.out.print(letterCombinations(testDigits));
    }
}
