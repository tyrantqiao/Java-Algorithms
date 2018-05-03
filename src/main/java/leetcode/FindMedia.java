package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author tyrantqiao
 */
public class FindMedia {
	private Queue<Long> small = new PriorityQueue();
	private Queue<Long> big = new PriorityQueue();

	public void addNum(int num) {
		big.add((long) num);
		small.add(-big.poll());
		if (big.size() < small.size()) {
			big.add(-small.poll());
		}
	}

	public double findMedian() {
		return big.size() > small.size()
				? big.peek()
				: (big.peek() - small.peek()) / 2.0;
	}
}
