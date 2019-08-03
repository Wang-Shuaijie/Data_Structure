package com.java.leetcode;

import java.util.HashMap;

public class FindNumsAppearOnceII {
	/**
	 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ����������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�

˵����

����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����

ʾ�� 1:

����: [2,2,3,2]
���: 3

	 */
	public int singleNumber(int[] nums) {
		if(nums==null || nums.length==0) return -1;
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			}else {
				map.put(nums[i], 1);
			}
		}
		
		for(int key:map.keySet()) {
			if(map.get(key)==1) {
				return key;
			}
		}
		return -1;
	}
	
	//�ٷ��ⷨ
	public int singleNumber2(int[] nums) {
		  int ones = 0, twos = 0, threes = 0;
		        
		  for (int i = 0; i < nums.length; i++) {
		    // twos holds the num that appears twice
		    twos |= ones & nums[i];
		    
		    // ones holds the num that appears once
		    ones ^= nums[i];
		 
		    // threes holds the num that appears three times
		    threes = ones & twos;
		            
		    // if num[i] appears three times
		    // doing this will clear ones and twos
		    ones &= ~threes;
		    twos &= ~threes;
		  }
		        
		  return ones;
		}
}
