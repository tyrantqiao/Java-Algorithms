package data;

import org.junit.jupiter.api.Test;

public class HashCode {
	String msg="test";
	int id;

	@Test
	public void hashcode(){
		int hash=17;
		hash=31*hash+msg.hashCode();
		System.out.print("hash:"+hash);
//		return hash;
	}


}
