package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tyrantqiao
 * date: 2018/10/25
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class GenerateParentheses {
    /**
     * 通过深度优先的方式实现生成字符串，再通过判断这一串是否符合我们要的需求，(的数量要>=)的要求
     * 不过这个答案没做到及时止损，是生成了整个字符串再进行判断
     * TODO 需要优化
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();

        int currentIndex = 0;
        generateParenthesesString(result, currentIndex, new char[n * 2]);

        return result;
    }

    private void generateParenthesesString(List<String> result, int currentIndex, char[] chars) {
        if (currentIndex == chars.length) {
            if (isValid(chars)) {
                result.add(String.valueOf(chars));
            }
        } else {
            chars[currentIndex]='(';
            generateParenthesesString(result, currentIndex+1, chars);

            chars[currentIndex]=')';
            generateParenthesesString(result, currentIndex+1, chars);
        }
    }

    private boolean isValid(char[] chars) {
        int validFlag = 0;
        for (char c : chars) {
            if (c == '(') {
                validFlag++;
            } else {
                validFlag--;
            }
            if (validFlag < 0) {
                return false;
            }
        }
        return validFlag == 0;
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }
}
