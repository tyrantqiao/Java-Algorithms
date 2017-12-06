package leetcode;

import org.junit.jupiter.api.Test;

public class FindSingle {
	public int singleNonDuplicate(int[] nums) {
		int len=nums.length;
		int start=0,end=len-1;
		while(start<end){
			int mid=(start+end)/2;
			if (mid % 2 == 1) mid--;
			if(nums[mid]!=nums[mid+1])end=mid;
			else start+=2;
		}
		return nums[start];
	}

//	public int binarySearch(int[] nums,int left,int right){
//
//
//	}


	@Test
	public void test(){
		 int[] nums={1,1,2};
		 int result=singleNonDuplicate(nums);
		 System.out.print(result);
	}
}
