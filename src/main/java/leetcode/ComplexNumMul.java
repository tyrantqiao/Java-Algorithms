package leetcode;

/**
 * description: <a href="https://leetcode.com/problems/complex-number-multiplication/description"/></a>
 * Given two strings representing two complex numbers.
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * (复数相乘）
 * <p>
 * 每个复数的形式是a+bi or a+-bi
 * 先对+进行split("+") 得到String[] 左边为实数，右边为虚数
 * 再对虚数部分进行split("i")得到String[] 左边为虚数的大小，也就是我们所需要的
 * 接下来就是按照复数相乘规则了。
 *
 * @author tyrantqiao
 */
public class ComplexNumMul {
	public String complexNumberMultiply(String a, String b) {
		String[] left = a.split("[+]");
		String[] right = b.split("[+]");
		StringBuffer result = new StringBuffer("");
		int x1 = Integer.parseInt(left[0]);
		int x2 = Integer.parseInt(left[1].split("[i]")[0]);
		int y1 = Integer.parseInt(right[0]);
		int y2 = Integer.parseInt(right[1].split("[i]")[0]);
		result.append(x1 * y1 - x2 * y2);
		result.append('+');
		result.append(x1 * y2 + x2 * y1);
		result.append('i');
		return result.toString();
	}
}
