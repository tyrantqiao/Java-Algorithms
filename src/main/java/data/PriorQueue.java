package data;


import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author TyrantQiao
 * date: 2018/4/27
 * @version 0.0.1
 * Description: 优先队列
 * blog https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 * <p>
 * Iterable 实现数据结构的迭代。 Iterator是它的具体实现类。
 */
public class PriorQueue<Key extends Comparable<Key>> implements Iterable<Key> {
	private int n = 0;
	private Key[] pq;

	public PriorQueue(int size) {
		pq = (Key[]) new Comparable[size + 1];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * 置于最后，再调用swim上移{@link #sink(int)}
	 *
	 * @param key
	 */
	public void insert(Key key) {
		pq[++n] = key;
		swim(n);
	}

	@SafeVarargs
	public final void insert(Key... keys) {
		for (Key key : keys) {
			pq[++n] = key;
			swim(n);
		}
	}

	/**
	 * 先取最大值1，然后交换第一个和最后一个值，再将最后一个变为null，防止对象游离，紧接着使用{@link #sink(int)}下沉1
	 *
	 * @return max
	 */
	public Key deleteMax() {
		Key max = pq[1];
		exch(1, n--);
		pq[n + 1] = null;
		sink(1);
		return max;
	}

	/**
	 * 核心是下沉较大的元素，首先是判断是否有子节点，然后是比较子节点中较大的值，紧接着比较父子间大小，进行交换{@code k=j}，进行下一轮
	 *
	 * @param k
	 */
	private void sink(int k) {
		int sonNode = 2;
		while (sonNode * k <= n) {
			int j = sonNode * k;
			if (j < n && less(j, j + 1)) { j++;}
			if (!less(j, k)) { break;}
			exch(j, k);
			k = j;
		}
	}

	/**
	 * 核心是上移，通过判断是否有子节点以及是否比子节点大，{@code k=k/2}进行下一轮变换
	 *
	 * @param k
	 */
	private void swim(int k) {
		int parentNode = 2;
		while (k > 1 && less(k / parentNode, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	private void exch(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	public int size() {
		return n;
	}

	/**
	 * 告诉如何迭代。
	 *
	 * @return iterator
	 */
	@NotNull
	@Override
	public Iterator<Key> iterator() {
		return new PriorQueueIterator<Key>();
	}

	private class PriorQueueIterator<Key extends Comparable<Key>> implements Iterator<Key> {
		private PriorQueue<Key> copy;

		PriorQueueIterator() {
			copy = new PriorQueue<Key>(size());
		}

		@Override
		public boolean hasNext() {
			return !copy.isEmpty();
		}

		@Override
		public Key next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return copy.deleteMax();
		}
	}
}
