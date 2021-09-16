package interview;

import com.tyrantqiao.algorithms.interview.BasicDataType;
import org.junit.jupiter.api.Test;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class InterviewTest {
	BasicDataType basicDataType=new BasicDataType();

	@Test
	public void test(){
		byte b= 127;
		System.out.println(b);
		basicDataType.print(1);
		basicDataType.print(1.0);
		basicDataType.print(1L);
		basicDataType.print(1f);
	}
}
