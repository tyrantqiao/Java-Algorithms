package Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class CountingFactorizer {
	/**
	 * 通过将value设置为volatile然后再对值进行处理
	 */
	private final AtomicInteger count = new AtomicInteger();

	public long getCount() {
		return count.get();
	}

	/**
	 * pretend I am a servlet's service
	 */
	public void service() {
		count.incrementAndGet();
	}
}
