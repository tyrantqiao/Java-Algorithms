package algorithms;

import com.tyrantqiao.algorithms.data.PriorQueue;
import org.junit.jupiter.api.Test;


/**
 * Created By TyrantQiao on 2018/4/27
 *
 * @version 0.0.1
 * Description: Prior Queue
 * blog https://tyrantqiao.github.io/Blog
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class TestPQ {
	PriorQueue<Integer> priorQueue=new PriorQueue<>(10);

	@Test
	public void test(){
		priorQueue.insert(5,6,8,3,3,6,7,2);
//		assert priorQueue.deleteMax()==8;
	}
}
