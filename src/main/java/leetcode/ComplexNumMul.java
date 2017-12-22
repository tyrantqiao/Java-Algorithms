package leetcode;

import org.junit.jupiter.api.Test;

public class ComplexNumMul {
	public String complexNumberMultiply(String a, String b) {
		String[] left=a.split("[+]");
		String[] right=b.split("[+]");
		StringBuffer result=new StringBuffer("");
		int x1=Integer.parseInt(left[0]);
		int x2=Integer.parseInt(left[1].split("[i]")[0]);
		//if(a.contains("-"))x2=-x2;
		int y1=Integer.parseInt(right[0]);
		int y2=Integer.parseInt(right[1].split("[i]")[0]);
	//	if(b.contains("-"))y2=-y2;
		result.append(x1*y1-x2*y2);
		result.append('+');
		result.append(x1*y2+x2*y1);
		result.append('i');
		return result.toString();
	}

	@Test
	public void test(){
		String s1="1+-2i";
		String s2="0+1i";
		String result=complexNumberMultiply(s1,s2);
		System.out.println(result);
	}
}
