package interview;

/**
 * 小数点默认double先，加上f标记的为float，byte不能超过127，不然需要强制转换。
 *
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class BasicDataType {
	public void print(int num){
		System.out.println("I'm int");
	}

	public void print(long num){
		System.out.println("I'm long");
	}

	public void print(double num){
		System.out.println("I'm double");
	}

	public void print(float num){
		System.out.println("I'm float");
	}

	public void print(byte num){
		System.out.println("I'm num");
	}
}
