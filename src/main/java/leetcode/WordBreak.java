package leetcode;

import java.util.List;

/**
 * @author tyrantqiao
 */
public class WordBreak {
    /**
     * 找拆开的单词，当发现有一致的单词时，将对应的字符设为true，通过设置的boolean来获取词语
     *
     * @param s
     * @param wordDict
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] subString = new boolean[s.length() + 1];

        subString[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (subString[j] && wordDict.contains(s.substring(j, i))) {
                    subString[i] = true;
                    break;
                }
            }
        }

        return subString[s.length()];
    }
}
