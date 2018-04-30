package find;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * @author tyrantqiao
 * date: 2018/4/26
 * @version 0.0.1
 * Description: Search
 * blog https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class Search {
	/**
	 * 不断地向下取半，通过lo和hi进行取半，再简单地判断大小即可。
	 * lo+(hi-lo)/2 本质上也就是 (lo+hi)/2 那么就可以(lo+hi)>>>1
	 * 此外就是我们可以预先用midVal装载，然后再进行比较，时间为PT0.0005004S
	 * 而{@link Arrays#binarySearch(int[], int)} 是 PT0.0005005S
	 *
	 * @param array  144（测试数组数量）
	 * @param target 需要查找的目标
	 * @return
	 */
	public static int binarySearch(@NotNull int[] array, int target) {
		int n = array.length;
		int lo = 0, hi = n - 1;
		while (lo <= hi) {
			int mid = (lo + hi) >>> 1;
			int midVal = array[mid];
			if (midVal == target) {
				return mid;
			} else if (midVal > target) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 需要对数组进行检测，主动抛出错误，而不是等运行时才发生错误。
	 *
	 * @param arrayLength
	 * @param fromIndex
	 * @param toIndex
	 * @throws IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
		if (fromIndex > toIndex) {
			throw new IllegalArgumentException("out of bound cause by fromIndex:" + fromIndex + " > toIndex:" + toIndex);
		} else if (toIndex > arrayLength - 1) {
			throw new ArrayIndexOutOfBoundsException(toIndex);
		} else if (fromIndex < 0) {
			throw new ArrayIndexOutOfBoundsException(fromIndex);
		}
	}
}
