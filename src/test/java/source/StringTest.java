package source;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class StringTest {
	@Test
	public void test() throws IOException {
		String a = "ahha";
		Integer i = 1;
		FileOutputStream fileOutputStream = new FileOutputStream(".");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.write(Integer.parseInt(a));
	}
}
