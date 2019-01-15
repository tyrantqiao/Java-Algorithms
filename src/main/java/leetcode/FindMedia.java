package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author tyrantqiao
 */
public class FindMedia {
    private Queue<Long> small = new PriorityQueue();
    private Queue<Long> big = new PriorityQueue();

    /**
     * 添加数字
     *
     * @param num
     */
    public void addNum(int num) {
        big.add((long) num);
        small.add(-big.poll());
        if (big.size() < small.size()) {
            big.add(-small.poll());
        }
    }

    /**
     * 查找中间数，获得队列的头部
     *
     * @return
     */
    public double findMedian() {
        return big.size() > small.size()
                ? big.peek()
                : (big.peek() - small.peek()) / 2.0;
    }
}
