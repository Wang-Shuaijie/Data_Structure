package com.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FindNumsAppearOnce {
	/**
	 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
	 * ʾ�� 1:

����: [2,2,1]
���: 1

	 */
	public static int singleNumber(int[] nums) {
		if(nums==null || nums.length==0) return -1;
		if(nums.length==1) return nums[0];
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++) {
			if(i!=0 && i!=nums.length-1 && nums[i]!=nums[i+1] && nums[i]!=nums[i-1]) {
				return nums[i];
			}else if(i==0 && nums[i]!=nums[i+1]) {
				return nums[i];
			}else if(i==nums.length-1 && nums[i]!=nums[i-1]) {
				return nums[i];
			}
		}
		return -1;
	}
	
	public static int singleNumber2(int[] nums) {
		if(nums==null || nums.length==0) return -1;
		Set<Integer> set=new HashSet<>();
		//List<Integer> list=new ArrayList<>();
		for(int i=0;i<nums.length;i++) {
			if(set.contains(nums[i])) {
				set.remove(nums[i]);
			}else {
				set.add(nums[i]);
			}
		}

		Iterator<Integer> iter=set.iterator();
		while(iter.hasNext()) {
			return iter.next();
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {-1,-1,2};
		System.out.println(singleNumber2(nums));
	}
}
