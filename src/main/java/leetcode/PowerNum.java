package leetcode;


import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author tyrantqiao
 */
public class PowerNum {
	/**
	 * 若是2的倍数，则为1000，减一时为0111，则二者&操作时为0，而当这个数也是正数时，则为2的幂数
	 *
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwo(int n) {
		return ((n & (n - 1)) == 0 && n > 0);
	}

	public static void main(String[] args) {
		Stream<Boolean> result = IntStream.rangeClosed(0, 12)
				.mapToObj(PowerNum::isPowerOfTwo);
		System.out.println("result:" + result.collect(toList()));
	}
}
