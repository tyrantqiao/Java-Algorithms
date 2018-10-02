package leetcode;

import java.util.Stack;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class Calculator {
	/**
	 * 栈：先进后出
	 * 对于括号运算，使用栈，遇到'('时，将数字和sign【代表了是+还是-  +为1  -为-1】存进去，当遇到')'将stack存的
	 * pop()出来，再进行运算。
	 * <p>
	 * 对于一个数的计算，当遇到数字时向后迭代，将非符号前的所有数字拼起来。
	 *
	 * @param s
	 * @return
	 */
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		int sign = 1;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int entireNum = s.charAt(i) - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					entireNum = entireNum * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				result += entireNum * sign;
			} else if (s.charAt(i) == '+') {
				sign = 1;
			} else if (s.charAt(i) == '-') {
				sign = -1;
			} else if (s.charAt(i) == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				result = stack.pop() * result + stack.pop();
			}
		}
		return result;
	}

	private int k = 0;

	/**
	 * 同样来自于排名榜最快的，写下自己的一点理解
	 * 主动判断大小，不用包，不转数组
	 * 核心点在于设置一个全局变量，用于记录计算进度'k'，遇到'('则通过递归的形式跳过这一个点。
	 *
	 * @param S
	 * @return
	 */
	public int calculateFastest(String S) {
		int result = 0;
		int sign = 1;
		int entireNum = 0;
		while (k < S.length()) {
			char c = S.charAt(k);
			k++;
			if ('0' <= c && c <= '9') {
				entireNum = entireNum * 10 + c - '0';
			} else if (c == '+') {
				result += entireNum * sign;
				sign = 1;
				entireNum = 0;
			} else if (c == '-') {
				result += entireNum * sign;
				sign = -1;
				entireNum = 0;
			} else if (c == '(') {
				entireNum = calculateFastest(S);
			} else if (c == ')') {
				result += sign * entireNum;
				return result;
			}
		}
		result += sign * entireNum;
		return result;
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		String test = "1+2+(3-2)";
		System.out.print(calculator.calculateFastest(test));
	}
}
