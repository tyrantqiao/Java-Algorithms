package leetcode;

/**
 * @author tyrantqiao
 */
public class RevertInt {
	private static final int DECIMAL_CARRY = 10;

	public static int revertIntVersionOne(int x) {
		StringBuffer sBuffer = new StringBuffer();
		if (x > 0) {
			String s = String.valueOf(x);
			sBuffer.append(s);

			sBuffer.reverse();
		} else {
			String s = String.valueOf(-x);
			sBuffer.append(s);
			sBuffer.reverse();
			sBuffer.insert(0, '-');
		}
		return Integer.parseInt(sBuffer.toString());
	}

	public static int revertInt(int x) {
		int result = 0;
		for (; x != 0; x /= DECIMAL_CARRY) {
			int base = x % DECIMAL_CARRY;
			int test = result * DECIMAL_CARRY + base;
			if ((test - base) / DECIMAL_CARRY != result) {
				return 0;
			}
			result = test;
		}
		return result;
	}

	public static void main(String[] args) {
		int b = revertInt(-2147483412);
//        int c=946455555;
		System.out.print(b);
	}

}
