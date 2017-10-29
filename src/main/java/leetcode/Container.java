package leetcode;

public class Container {
    public static int maxArea(int[] height) {
        int size=height.length;

        int maxArea=0,left=0,right=size-1;
        while(left<right){
            maxArea=Math.max(maxArea,Math.min(height[left],height[right])*(right-1));
            if(height[left]<height[right])left++;
            else right--;
        }
        return maxArea;
    }


    public static void main(String[] args){
        int[] test={1,1,2,3,4,5,6,2,3};
        int result=maxArea(test);
        System.out.println("result:"+result);
    }

}
