package leetcode;


public class StringToInt {
    public static int myAtoi(String str) {
        if (str.isEmpty()) return 0;
        int i = 0;
        char[] arr = str.toCharArray();
        while (arr[i] == ' ') i++;
        if (!(arr[i] >= '0' && arr[i] <= '9' || arr[i] == '-' || arr[i] == '+')) return 0;

        int result = 0;
        int signal = 0;
        if (arr[i] == '+') {
            signal = 1;
            i++;
        } else if (arr[i] == '-') {
            signal = -1;
            i++;
        } else signal = 1;

        while (i < arr.length && Character.isDigit(arr[i])) {
            //when char is used to calculate, it use the unicode index.
            if (result >= Integer.MAX_VALUE / 10 && arr[i] > 7)
                return signal == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + arr[i++] - '0';
        }
        return result * signal;
    }

//    public static boolean notOperand(char c) {
//        return !Character.isDigit(c) && c != '+' && c != '-';
//    }

//    private static int getInterruptPoint(char[] arr) {
//        int tag = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == '+' || arr[i] == '-')
//                tag++;
////            System.out.println(notOperand(arr[i]));
//            if ((arr[i] == '-' || arr[i] == '+') && tag == 2 || notOperand(arr[i])) {
//                return i;
//            }
//            System.out.print(arr[i]);
//        }
//        return arr.length;
//    }

//    private static boolean testOverflow(int num, int base) {
////        int test = num * 10 + base;
//        int b = (Integer.MAX_VALUE - base) / 10;
//        System.out.println("calculate:" + b);
//        return num > (Integer.MAX_VALUE - base) / 10;
//    }

    public static void main(String[] args) {
        int a = myAtoi("-2147483647");
//        int b=214748364;
//        int c=b*10+8;
//        int d=c*10/10-8;
//        int e=d/10;
//        System.out.println("b:"+b+" c:"+c+" d:"+d+" e:"+e);
        System.out.println(a);
    }
}
