package leetcode;


/**
 * @author tyrantqiao
 */
public class StringProblems {
    /**
     * Sliding Window
     * 用字母数组装字符，每次仅装s1的size，用来进行匹配，matches()函数
     * 因为是对数组是否有同样的字符进行检查，所以无论是正序还是逆序的，都能看是否包含，不过不能识别是正还是逆序
     * InAndOut就是一个用于迭代的数，装还没装的数字，并把已经测完的第一个字母剔除掉
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] leftArray = new int[26];
        int[] rightArray = new int[26];
        //装数据
        for (int index = 0; index < s1.length(); index++) {
            leftArray[s1.charAt(index) - 'a']++;
            rightArray[s2.charAt(index) - 'a']++;
        }
        //迭代后面内容，查看是否有匹配的情况
        for (int inAndOutIndex = 0; inAndOutIndex < s2.length() - s1.length(); inAndOutIndex++) {
            if (alphabetsMatches(leftArray, rightArray)) {
                return true;
            }
            rightArray[s2.charAt(inAndOutIndex + s1.length()) - 'a']++;
            rightArray[s2.charAt(inAndOutIndex) - 'a']--;
        }
        return alphabetsMatches(leftArray, rightArray);
    }

    /**
     * 用于检测字母数组是否匹配
     *
     * @param leftArray
     * @param rightArray
     * @return
     */
    private boolean alphabetsMatches(int[] leftArray, int[] rightArray) {
        int charsSize = 26;
        for (int i = 0; i < charsSize; i++) {
            if (leftArray[i] != rightArray[i]) {
                return false;
            }
        }
        return true;
    }

    public static int myAtoi(String str) {
        char space = ' ';
        char minNum = '0', maxNum = '9';
        char minus = '-', add = '+';
        if (str.isEmpty()) {
            return 0;
        }
        int i = 0;
        char[] arr = str.toCharArray();
        while (arr[i] == space) {
            i++;
        }
        boolean charValid = !(arr[i] >= minNum && arr[i] <= maxNum || arr[i] == minus || arr[i] == add);
        if (charValid) {
            return 0;
        }

        int result = 0;
        int signal = 0;
        if (arr[i] == add) {
            signal = 1;
            i++;
        } else if (arr[i] == minus) {
            signal = -1;
            i++;
        } else {
            signal = 1;
        }

        while (i < arr.length && Character.isDigit(arr[i])) {
            //when char is used to calculate, it use the unicode index.
            if (result >= Integer.MAX_VALUE / 10 && arr[i] > 7) {
                return signal == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + arr[i++] - minNum;
        }
        return result * signal;
    }

    public static boolean notOperand(char c) {
        return !Character.isDigit(c) && c != '+' && c != '-';
    }

    private static int getInterruptPoint(char[] arr) {
        int tag = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '+' || arr[i] == '-') {
                tag++;
            }
            boolean charIsOperand = (arr[i] == '-' || arr[i] == '+') && tag == 2 || notOperand(arr[i]);
            if (charIsOperand) {
                return i;
            }
            System.out.print(arr[i]);
        }
        return arr.length;
    }

    private static boolean testOverflow(int num, int base) {
//        int test = num * 10 + base;
        int b = (Integer.MAX_VALUE - base) / 10;
        System.out.println("calculate:" + b);
        return num > (Integer.MAX_VALUE - base) / 10;
    }

    public static void main(String[] args) {
        StringProblems stringProblems = new StringProblems();
        System.out.println(stringProblems.checkInclusion("aba", "cbaa"));
    }
}
