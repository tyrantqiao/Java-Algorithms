package Concurrency;

import javafx.event.Event;

import java.util.EventListener;
import java.util.HashMap;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class PreventThis {
	private final EventListener eventListener;
	/**
	 * 避免在构造器中启动线程，会导致this引用被新创建的线程共享【在构造器未完成前，其他线程是可以看见的】
	 */
	public PreventThis(){
		eventListener=new EventListener() {
			public void onEvent(Event e){
				System.out.println("hello");
			}
		};
	}

	public static PreventThis newInstance(){
		PreventThis safe=new PreventThis();
		return safe;
	}
}
