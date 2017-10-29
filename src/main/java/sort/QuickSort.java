package sort;


import static java.util.Arrays.sort;

public class QuickSort {
    public static int partition(int low,int high,int[] arr){
        int basic=arr[low];
        int left=low,right=high;
        while(true) {
            while (less(arr[++left], basic)) if (left == high) break;
            while (less(basic, arr[--right])) if (right == low) break;
            if(left>=right)break;
            exch(arr, left, right);
        }
        exch(arr,low,right);

        return right;
    }

    private static void exch(int[] arr, int left, int right) {
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }

    @org.jetbrains.annotations.Contract(pure = true)
    private static boolean less(int basic, int i) {
        return basic<i;
    }

    public static void main(String[] args){
        int []a={2,5,6,3,2,1};
        int b=partition(0,a.length,a);
        for(int i:a)
            System.out.print(" "+i);
        System.out.println(" partition:"+b);
        sort(a,0,b);
        sort(a,b+1,a.length-1);

        for(int i:a)
            System.out.print(" "+i);

    }

}
