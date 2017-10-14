package leetcode;

public class RevertInt {
    //Too Long
    public static int revertIntVersionOne(int x) {
        StringBuffer sBuffer = new StringBuffer();
        if (x > 0) {
            String s = String.valueOf(x);
            sBuffer.append(s);

            sBuffer.reverse();
        } else {
            String s = String.valueOf(-x);
            sBuffer.append(s);
            sBuffer.reverse();
            sBuffer.insert(0, '-');
        }
        return Integer.parseInt(sBuffer.toString());
    }

    //hard code 0x7777777f 0x800000000
    public static int revertInt(int x) {
        int result=0;
        for(;x!=0;x/=10){
            int base=x%10;
            int test=result*10+base;
            if((test-base)/10!=result)
                return 0;
            result=test;
        }
        return result;
    }

    public static void main(String[] args) {
        int b = revertInt(-2147483412);
//        int c=946455555;
        System.out.print(b);
    }

}
