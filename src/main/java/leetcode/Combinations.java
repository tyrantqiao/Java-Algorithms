package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tyrantqiao
 */
public class Combinations {
    /**
     * 用1到n组成k个数字的组合【这个不看先后顺序！】
     *
     * 就是从n个数中挑出k个，Ck-n=Ak-n/n!
     * 当k==n或者k==0时意味着只剩最后一种结果，直接添加元素或者输出列表出去即可。
     * 然后通过递归，实现添加k数字，然后再通过n的缩减进行添加。
     * 其实分为两部分，k的小部分，以及n的大头。
     *
     * @param n
     * @param k
     * @return
     */
	public List<List<Integer>> combine(int n, int k) {
		if (k == n || k == 0) {
			List<Integer> element = new ArrayList<>();
			for (int i = 1; i <= k; i++) {
				element.add(i);
			}
			return new LinkedList<>(Arrays.asList(element));
		}
		List<List<Integer>> result = this.combine(n - 1, k - 1);
		result.forEach(e -> e.add(n));
		result.addAll(this.combine(n - 1, k));
		return result;
	}

	public static void main(String[] args){
        Combinations combinations=new Combinations();
        System.out.println(combinations.combine(4,2));
	}
}
