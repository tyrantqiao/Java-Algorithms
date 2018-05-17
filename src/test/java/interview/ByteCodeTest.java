package interview;

import org.junit.jupiter.api.Test;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class ByteCodeTest {
	@Test
	public void test(){
		byte left=Byte.parseByte("01111111",2);
		byte right=Byte.parseByte("1",2);
		byte result= (byte) (left+right);
		System.out.println(result);
	}
}
