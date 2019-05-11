package com.demo.offer;

import java.util.ArrayList;
import java.util.List;

public class Solution65 {
	/**
	 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ
	 * 
	 * ˼·������forѭ������һ��forѭ���������ڣ��ڶ���forѭ�����������е�ֵ��
	 * Ѱ�����ֵ��������ʹ��ʱ�临�Ӷȸ��͵�˫�˶�����⡣
	 */
	public List<Integer> maxInWindows(int[] nums, int size){
		List<Integer> res=new ArrayList<>();
		if(nums==null || nums.length==0) return res;
		int len=nums.length-size+1;
		for(int i=0;i<len;i++) {
			int current=size+1;
			int max=nums[i];
			for(int j=i;j<current;j++) {
				if(max<nums[j]) {
					max=nums[j];
				}
			}
			res.add(max);
		}
		return res;
	}
}
