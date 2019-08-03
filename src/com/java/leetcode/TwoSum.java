package com.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	/**
	 * 1.����֮��
	 * 2.����һ���������� nums ��һ��Ŀ��ֵ target��
	 * �����ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±�
	 * 3.������ nums = [2, 7, 11, 15], target = 9
	 * ��Ϊ nums[0] + nums[1] = 2 + 7 = 9���Է��� [0, 1]
	 */
	//time:O(n) space:O(n)
	
	public static int[] twoSum(int[] nums,int target) {
		//˼·������hashmap key��������Ԫ�أ�value�����±�
		if(nums==null || nums.length<2) {
			return new int[] {-1,-1};
		}
		
		int[] res=new int[] {-1,1};
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			//ÿһ�α�����Ҫ��(taget-��ǰ������ֵ)�Ƿ����������������
			if(map.containsKey(target-nums[i])) {
				res[0]=map.get(target-nums[i]);
				res[1]=i;
			}
			map.put(nums[i], i);
		}
		return res;
	}
	
	public static int[] twoSum2(int[] nums,int target) {
		if(nums==null || nums.length<2) {
			return new int[] {-1,-1};
		}
		
		int[] res=new int[] {-1,1};
		//ͷָ��
		int i=0;
		//βָ��
		int j=nums.length-1;
		//nums��������������
		while(i<j) {
			int sum=nums[i]+nums[j];
			if(sum == target) {
				res[0]=i;
				res[1]=j;
			}else if(sum < target) {
				i++;
			}else {
				j++;
			}
		}

		return res;
	}
	
	
	
	public static void main(String[] args) {
		int[] nums=new int[] {2,7,11,15};
		int target=9;
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}
}
