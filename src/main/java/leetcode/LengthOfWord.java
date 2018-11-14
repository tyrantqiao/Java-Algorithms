package leetcode;

/**
 * @author tyrantqiao
 * date: 2018/11/14
 * blog: tyrantqiao.com
 * contact: tyrantqiao@icloud.com
 */
public class LengthOfWord {
    /**
     * split函数分开拿最后的
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.equals("") || s.equals(" ")) {
            return 0;
        }

        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }

    public static void main(String[] args) {
        LengthOfWord lengthOfWord = new LengthOfWord();
        System.out.println(lengthOfWord.lengthOfLastWord("ddwd feegrg"));
    }
}
