package algorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class HashMapTest {
	HashMap map=new HashMap();
	@Test
	public void test(){
		 map.put(1,1);
		 map.put(1,2);
		 System.out.println(map.toString());
	}
}
