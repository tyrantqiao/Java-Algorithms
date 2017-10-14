package leetcode;

public class PalindromicString {
    private static int maxLen = 0;
    private static int base = 0;

    public static String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        for (int i = 0; i < s.length(); i++) {
            testPalindromic(s, i, i);
            testPalindromic(s, i, i + 1);
        }
        return s.substring(base, base + maxLen);

    }

    private static void testPalindromic(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            if (right - left - 1 > maxLen) {
                base = left + 1;
                maxLen = right - left - 1;
            }
//            System.out.println("base:" + base);
//            System.out.println("len:" + maxLen);
        }
    }

    public static void main(String[] args) {
        String result = longestPalindrome("asbbbdbsa");
        System.out.println(result);
    }
}
