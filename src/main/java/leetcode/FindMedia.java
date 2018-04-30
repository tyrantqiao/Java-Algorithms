package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author tyrantqiao
 */
public class FindMedia {
	private Queue<Long> small=new PriorityQueue();
	private Queue<Long> big=new PriorityQueue();

	public void addNum(int num) {
		big.add((long)num);
		small.add(-big.poll());
		if(big.size()<small.size()) {
			big.add(-small.poll());
		}
	}

	public double findMedian() {
		return big.size() > small.size()
				? big.peek()
				: (big.peek() - small.peek()) / 2.0;
	}
}
