package com.java.剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution41_1 {
	/**
	 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
	 *方法很多，比如hash，暴力破解，这里写出一种，定义两个指针，分别从前面和后面进行遍历。间隔越远乘积越小，所以是最先出现的两个数乘积最小
	 */
	public int[] findNumberWithSum(int[] nums, int target) {
		Arrays.sort(nums);
		int[] res=new int[] {-1,-1};
		if(nums==null || nums.length==0) return res;
		int start=0;
		int end=nums.length-1;
		while(start<=end) {
			int sum=nums[start]+nums[end];
			if(sum==target) {
				res[0]=nums[start];
				res[1]=nums[end];
			}else if(sum>target) {
				end--;
			}else {
				start++;
			}
		}
		return res;
	}
	
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i=0,j=array.length-1;
        while(i<j){
            if(array[i]+array[j]==sum){
            	list.add(array[i]);
            	list.add(array[j]);
                return list;
           }else if(array[i]+array[j]>sum){
                j--;
            }else{
                i++;
            }
             
        }
        return list;
    }
}
