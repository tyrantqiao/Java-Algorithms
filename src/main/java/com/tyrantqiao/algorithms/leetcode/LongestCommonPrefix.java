package com.tyrantqiao.algorithms.leetcode;

/**
 * Description: <a href="https://leetcode.com/problems/longest-common-prefix/description/"></a>
 *
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class LongestCommonPrefix {
	/**
	 * indexOf() 返回首个相等元素的index
	 * 因为题意只是要求了最大的前缀，所以我们每次找到时，去掉末尾元素即可。当遍历完就知道答案了
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String commonPrefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(commonPrefix) != 0) {
				commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
				if (commonPrefix.isEmpty()) {
					return "";
				}
			}
		}
		return commonPrefix;
	}
}
