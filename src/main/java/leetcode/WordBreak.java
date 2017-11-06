package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

public class WordBreak {
	@Test
	public void wordBreak(String s, List<String> wordDict) {
		boolean[] substring=new boolean[s.length()+1];

		substring[0]=true;

		for(int i=1;i<=s.length();i++){
			for(int j=0;j<=i;j++) {
				if (substring[j] && wordDict.contains(s.substring(j, i))){
					substring[i] = true;
					break;
				}
			}
		}

//		return substring[s.length()];
	}



}
