package leetcode;


import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author tyrantqiao
 */
public class PowerNum {
	public static boolean isPowerOfTwo(int n) {
		return ((n & (n - 1)) == 0 && n > 0);
	}

	public static void main(String[] args) {
		Stream<Boolean> result = IntStream.rangeClosed(0, 12)
				.mapToObj(PowerNum::isPowerOfTwo);
		System.out.println("result:" + result.collect(toList()));
	}

}
