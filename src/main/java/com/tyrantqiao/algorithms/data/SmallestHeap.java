package com.tyrantqiao.algorithms.data;

/**
 * Description:
 *
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class SmallestHeap {
	int stackSize;
	int containElements = 0;
	int[] stack;

	SmallestHeap(int stackSize) {
		this.stackSize = stackSize + 1;
		stack = new int[this.stackSize];
		stack[0] = -1;
	}

	private int deleteMin() {
		int min = stack[1];
		exch(1, containElements--);
		stack[containElements + 1] = -1;
		sink(1);
		return min;
	}

	private void sink(int index) {
		int sinkMagnification = 2;
		while (sinkMagnification * index <= containElements) {
			int compareIndex = sinkMagnification * index;
			if (less(compareIndex, compareIndex - 1)) {
				compareIndex--;
			}
			exch(compareIndex, index);
			index = index * sinkMagnification;
		}
	}

	private void put(int number) {
		if (number < 0) {
			return;
		}
		stack[++containElements] = number;
		swim(containElements);
	}

	private void swim(int containElements) {
		while (containElements > 1 && less(stack[containElements], stack[containElements / 2])) {
			exch(containElements, containElements / 2);
			containElements = containElements / 2;
		}
	}

	private void exch(int left, int right) {
		int temp = stack[left];
		stack[left] = stack[right];
		stack[right] = temp;
	}

	private boolean less(int left, int right) {
		return left < right;
	}

}
