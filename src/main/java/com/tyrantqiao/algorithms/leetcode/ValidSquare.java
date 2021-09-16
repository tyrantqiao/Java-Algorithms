package com.tyrantqiao.algorithms.leetcode;

import java.util.HashSet;

/**
 * @author tyrantqiao
 */
public class ValidSquare {
	/**
	 * description: <a href="https://leetcode.com/problems/valid-square/description/"></a>
	 * 数学思想，点不同，边同，通过set判断各点距离有无不同的，若有不同的则是不对的
	 * 而这个是边长一个值，对角线一个值，超过2则错误
	 *
	 * @author tyrantqiao [tyrantqiao@gmail.com]
	 * @param p1 point1
	 * @param p2 point2
	 * @param p3 point3
	 * @param p4 point4
	 * @return boolean
	 */
	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		HashSet<Integer> distanceSet = new HashSet<Integer>();
		distanceSet.add(getDistance(p1, p2));
		distanceSet.add(getDistance(p1, p3));
		distanceSet.add(getDistance(p1, p4));
		distanceSet.add(getDistance(p4, p2));
		distanceSet.add(getDistance(p4, p3));
		distanceSet.add(getDistance(p2, p3));
		System.out.println(distanceSet);
		return !distanceSet.contains(0) && distanceSet.size() == 2;

	}

	private static int getDistance(int[] left, int[] right) {
		return (left[0] - right[0]) * (left[0] - right[0]) + (left[1] - right[1]) * (left[1] - right[1]);
	}

	public static void main(String[] args) {
		int[] a = {1, -1};
		int[] b = {1, 1};
		int[] c = {0, 1};
		int[] d = {0, 0};
		boolean result = validSquare(a, b, c, d);
		System.out.println(result);
	}
}
