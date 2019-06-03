package com.demo.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution51 {
	/**
	 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡� ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ��������ظ�������2����3��
	 */
	public int duplicate(int[] nums) {
		if(nums==null || nums.length==0) return -1;
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			}else {
				map.put(nums[i], 1);
			}
		}
		
		for(int key:map.keySet()) {
			if(map.get(key)>1) {
				return key;
			}
		}
		return -1;
	}
	
	
	
	
	
	
	//һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		// ��ת��String������removeɾ�������ֱ��ɾ����ֵ���ͻ������±�
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (!list.contains(String.valueOf(array[i]))) {
				list.add(String.valueOf(array[i]));
			} else {
				list.remove(String.valueOf(array[i]));
			}
		}
		if (list.size() != 0) {
			num1[0] = Integer.valueOf(list.get(0));
			num2[0] = Integer.valueOf(list.get(1));
		}
	}
}
