package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

//TODO another method need self-finishing
public class TrappingRain {
	public int trap(int[] height) {
		if (height == null || height.length == 0)
			return 0;

		int len = height.length;
		int left  = 0;
		int right = len-1;
		int result = 0;
		// 用两个指针从两端往中间扫，在当前窗口下，如果哪一侧的高度是小的，那么从这里开始继续扫，如果比它还小的，肯定装水的瓶颈就是它了，可以把装水量加入            结果，如果遇到比它大的，立即停止，重新判断左右窗口的大小情况，重复上面的步骤
		while (left < right) {
			int min = Math.min(height[left], height[right]);
			if (height[left] == min) {
				left++;
				while (height[left] < min) {
					result += (min-height[left]);
					left++;
				}
			} else {
				right--;
				while (height[right] < min) {
					result += (min-height[right]);
					right--;
				}
			}
		}
		return result;
	}
}
