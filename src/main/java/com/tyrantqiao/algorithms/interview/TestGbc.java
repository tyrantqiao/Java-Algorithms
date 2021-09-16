package com.tyrantqiao.algorithms.interview;

/**
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class TestGbc {

	String str = "hello string";
	char[] chars = {'c', 'h', 'a', 'r'};
	StringBuilder stringBuilder=new StringBuilder("hello stringBuilder");

	public void exchange(String str, char[] chars,StringBuilder stringBuilder) {
		str = "world";
		chars[0] = '5';
		stringBuilder=new StringBuilder("I'm a new StringBuilder");
	}


	public static void main(String[] args) {
		TestGbc ro = new TestGbc();
		ro.exchange(ro.str, ro.chars,ro.stringBuilder);
		System.out.println(ro.str);
		System.out.println(ro.chars);
		System.out.println(ro.stringBuilder);
//		System.out.println(ro.stringBuilder.toString());
	}
}
