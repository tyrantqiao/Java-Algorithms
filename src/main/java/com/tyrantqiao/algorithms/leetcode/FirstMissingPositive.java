package com.tyrantqiao.algorithms.leetcode;

/**
 * Description:
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <a href="https://leetcode.com/problems/first-missing-positive/description/"></a>
 * <p>
 * {@link Math#round(float)}四舍五入 {@link Math#floor(double)}最小 {@link Math#ceil(double)}最大
 * {@code ^=}异或 相反为1  {@code ^}同样是异或
 * <p>
 * 交换用了异或
 * 解题思路在于维护一个下标index，确保数组排为i+1或者{@code <0}或者{@code >array.length}的形式
 * 然后再遍历一次数组，只要index+1的值和array(index)相等就index++；
 * （因为题目要求的是正数，所以下标为0的地方理应放的是1，以此类推）
 *
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class FirstMissingPositive {
	public static int firstMissingPositive(int[] array) {
		int index = 0;
		while (index < array.length) {
			if (array[index] == index + 1 || array[index] <= 0 || array[index] > array.length) {
				index++;
			} else if (array[array[index] - 1] != array[index]) {
				swap(array, array[index] - 1, index);
			} else {
				index++;
			}
		}
		index = 0;
		while (index < array.length && array[index] == index + 1) {
			index++;
		}
		return index + 1;
	}

	private static void swap(int[] array, int i, int j) {
		array[i] ^= array[j];
		array[j] ^= array[i];
		array[i] ^= array[j];
	}
}

