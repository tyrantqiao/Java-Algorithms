package algorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author tyrantqiao
 * date: 2019/5/6
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class TestFangyan {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int N=in.nextInt();
        int K=in.nextInt();
        int all=0;
        int[] nums=new int[N];
        for(int i=0;i<N;i++){
            nums[i]=in.nextInt();
//            all+=in.nextInt();
        }
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            int temp=0;
            while(i<nums.length&& nums[i]==nums[i-1]){
                temp++;
                i++;
                if(temp>all){
                    all=temp;
                }
            }
        }
        System.out.println(K-all);

//        for(int i=0;i<K;i++){
////            nums[i]=in.nextInt();
//            all+=in.nextInt();
//        }


//        if(N- N*K+all>0) {
//            System.out.println(N- N * K+all);
//        }else{
//            System.out.println(0);
//        }
    }
}
