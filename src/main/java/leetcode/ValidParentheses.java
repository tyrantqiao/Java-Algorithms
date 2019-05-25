package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author tyrantqiao
 * date: 2018/10/24
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */

public class ValidParentheses {
    /**
     * 答案做法：通过存反的括号，然后再通过设置好的map来获取char，通过判断当前char与获取的值比较，若一样则返回true
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }

        var parenthesesMap = new HashMap<Character, Character>(4);
        parenthesesMap.put('[', ']');
        parenthesesMap.put('(', ')');
        parenthesesMap.put('{', '}');

        var reverseParenthesesStack = new Stack<Character>();
        for (var currentChar : s.toCharArray()) {
            if (parenthesesMap.containsValue(currentChar)) {
                char popChar = reverseParenthesesStack.empty() ? '!' : reverseParenthesesStack.pop();
                if (currentChar != parenthesesMap.getOrDefault(popChar, '!')) {
                    return false;
                }
            } else {
                reverseParenthesesStack.push(currentChar);
            }
        }
        return reverseParenthesesStack.isEmpty();
    }

    /**
     * 最快答案
     * 用switch的形式来做，O（n）通过数组以及计数值巧妙地实现栈的能力，且对空间消耗仅O(n)
     *
     * @param s
     * @return
     */
    public boolean isValidFastest(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }

        char[] chars = new char[length];
        int postParentheses = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '[':
                case '{':
                case '(':
                    chars[++postParentheses] = c;
                    break;
                case ')':
                    if (chars[--postParentheses] != '(' || postParentheses == 0) {
                        return false;
                    }
                    break;
                case '}':
                    if (chars[--postParentheses] != '{' || postParentheses == 0) {
                        return false;
                    }
                    break;
                case ']':
                    if (chars[--postParentheses] != '[' || postParentheses == 0) {
                        return false;
                    }
                    break;
                default:
            }
        }
        return postParentheses == 0;
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.print(validParentheses.isValid("(())"));
    }
}
