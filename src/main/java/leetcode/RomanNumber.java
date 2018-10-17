package leetcode;

/**
 * @author tyrantqiao
 */
public class RomanNumber {
    /**
     *  倒序的思想，先建立两个数组，数字-字母表。
     *  然后我们对数字从数组第0位开始判断大小，若数字大于数组第0位即1000，那就减1000，然后结果加上相应的字母
     *  最后输出结果即可
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(strs[i]);
            }
        }
        return result.toString();
    }
}
