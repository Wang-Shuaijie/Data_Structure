package com.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	/**
	 * ����һ������ n ������������ nums ��һ��Ŀ��ֵ target���ж� nums ���Ƿ�����ĸ�Ԫ�� a��b��c �� d ��
	 * ʹ�� a + b + c + d ��ֵ�� target ��ȣ��ҳ��������������Ҳ��ظ�����Ԫ�顣
	 * �������� nums = [1, 0, -1, 0, -2, 2]���� target = 0��
	 * ����Ҫ�����Ԫ�鼯��Ϊ��[
	 * 							[-1,  0, 0, 1],
	 * 							[-2, -1, 1, 2],
	 * 							[-2,  0, 0, 2]
	 * 						  ]
	 */
	 public static List<List<Integer>> fourSum(int[] nums, int target) {
	        List<List<Integer>> res=new ArrayList<>();
	        Arrays.sort(nums);
	        for(int i=0;i<nums.length-3;i++) {
	        	//ȥ��
	        	if(i>0 && nums[i]==nums[i-1]) continue;
	        	for(int j=i+1;j<nums.length-2;j++) {
	        		if(j>i+1 && nums[j]==nums[j-1]) continue;
	        			
	        		int start=j+1,end=nums.length-1,sum=target-nums[i]-nums[j];
	        		while(start<end) {
	        			if(nums[start]+nums[end]==sum) {
	        				res.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
	        				//ȥ��
	        				while(start<end && nums[start]==nums[start+1]) start++;
	        				while(start<end && nums[end]==nums[end-1]) end--;
	        				
	        				start++;
	        				end--;
	        			}else if(nums[start]+nums[end]<sum) {
	        				start++;
	        			}else {
	        				end--;
	        			}
	        		}
	        			
	        			
	        	}
	        }
	       return res;
	 }
	 
	 public static void main(String[] args) {
		int[] nums=new int[] {1, 0, -1, 0, -2, 2};
		System.out.println(fourSum(nums, 0));
	}
	 
}
