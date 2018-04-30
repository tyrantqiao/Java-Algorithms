package leetcode;


/**
 * @author tyrantqiao
 */
public class StringToInt {
	public static int myAtoi(String str) {
		char space = ' ';
		char minNum = '0', maxNum = '9';
		char minus = '-', add = '+';
		if (str.isEmpty()) {
			return 0;
		}
		int i = 0;
		char[] arr = str.toCharArray();
		while (arr[i] == space) {
			i++;
		}
		boolean charValid = !(arr[i] >= minNum && arr[i] <= maxNum || arr[i] == minus || arr[i] == add);
		if (charValid) {
			return 0;
		}

		int result = 0;
		int signal = 0;
		if (arr[i] == add) {
			signal = 1;
			i++;
		} else if (arr[i] == minus) {
			signal = -1;
			i++;
		} else {
			signal = 1;
		}

		while (i < arr.length && Character.isDigit(arr[i])) {
			//when char is used to calculate, it use the unicode index.
			if (result >= Integer.MAX_VALUE / 10 && arr[i] > 7) {
				return signal == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + arr[i++] - minNum;
		}
		return result * signal;
	}

	public static boolean notOperand(char c) {
		return !Character.isDigit(c) && c != '+' && c != '-';
	}

	private static int getInterruptPoint(char[] arr) {
		int tag = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '+' || arr[i] == '-') {
				tag++;
			}
			boolean charIsOperand = (arr[i] == '-' || arr[i] == '+') && tag == 2 || notOperand(arr[i]);
			if (charIsOperand) {
				return i;
			}
			System.out.print(arr[i]);
		}
		return arr.length;
	}

	private static boolean testOverflow(int num, int base) {
//        int test = num * 10 + base;
		int b = (Integer.MAX_VALUE - base) / 10;
		System.out.println("calculate:" + b);
		return num > (Integer.MAX_VALUE - base) / 10;
	}

	public static void main(String[] args) {
		int a = myAtoi("-2147483647");
		System.out.println(a);
	}
}
