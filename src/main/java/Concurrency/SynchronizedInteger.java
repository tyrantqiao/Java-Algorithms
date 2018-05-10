package Concurrency;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class SynchronizedInteger {
	/**
	 * 需要同时对二者上锁，防止出现错误。
	 */
	private int value;

	public synchronized int getValue(){
		return value;
	}
	public synchronized void setValue(int value){
		this.value=value;
	}
}
