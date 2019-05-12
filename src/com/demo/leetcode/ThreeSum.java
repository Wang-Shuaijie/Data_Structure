package com.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
	/**
	 * ����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��
	 * ʹ�� a + b + c = 0 ���ҳ��������������Ҳ��ظ�����Ԫ��
	 * ����, �������� nums = [-1, 0, 1, 2, -1, -4]��
	 * ����Ҫ�����Ԫ�鼯��Ϊ��[
	 * 							[-1, 0, 1],
	 * 							[-1, -1, 2]
	 * 						  ]
	 * (0,1,-1)���ظ�
	 */
	public static List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> res=new ArrayList<>();
		//��ԭ��������
		Arrays.sort(nums);
		//һǰһ��ķ���
		for(int i=0;i<nums.length-2;i++) {
			//ȥ��
			if(i>0 && nums[i]==nums[i-1]) continue;
			/*
			 * i=-1 low=0 high=-4
			 * i=0 low=1 high=-1
			 * ...
			 */
			int low=i+1,high=nums.length-1,sum=0-nums[i];
			
			while(low<high) {
				if(nums[low]+nums[high]==sum) {
					res.add(Arrays.asList(nums[i],nums[low],nums[high]));
					//ȥ��
					while(low<high && nums[low]==nums[low+1]) low++;
					while(low<high && nums[high]==nums[high-1]) high--;
					
					low++;
					high--;
				}else if(nums[low]+nums[high]<sum){
					low++;
				}else {
					high--;
				}
			}
		}
		return res;
	}
	//(ȥ��ʧ��)�����ƽ� O(n^3)
	public static List<List<Integer>> threeSum2(int[] nums){
		List<List<Integer>> res=new ArrayList<>();
		for(int i=0;i<nums.length-2;i++) {
			for(int j=i+1;j<nums.length-1;j++) {
				for(int k=j+1;k<nums.length;k++) {
					if(nums[i]+nums[j]+nums[k]==0) {
						res.add(Arrays.asList(nums[i],nums[j],nums[k]));
					}
				}
			}
		}
		return res;
	}
	//ʧ��(ȥ��̫����)
	public static List<List<Integer>> threeSum3(int[] nums){
		List<List<Integer>> res=new ArrayList<>();
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.remove(nums[i]);
			}
			
			map.put(nums[i], i);
		}
		
		for(int i=0;i<nums.length;i++) {
			int sum=0-nums[i];
			for(int j=i+1;j<nums.length;j++) {
				if(map.containsKey(sum-nums[j]) && map.get(sum-nums[j])>j) {
					List<Integer> listTmp = new ArrayList<Integer>();
					listTmp.add(nums[i]);
					listTmp.add(nums[j]);
					listTmp.add(sum-nums[j]);
					res.add(listTmp);
					
				
				}
			}

		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums));
	}
}
