package leetcode;

/**
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
