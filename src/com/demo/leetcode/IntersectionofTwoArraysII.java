package com.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionofTwoArraysII {
	/**
	 * �����������飬��дһ���������������ǵĽ�����

ʾ�� 1:

����: nums1 = [1,2,2,1], nums2 = [2,2]
���: [2,2]

ʾ�� 2:

����: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
���: [4,9]

˵����

    ��������ÿ��Ԫ�س��ֵĴ�����Ӧ��Ԫ�������������г��ֵĴ���һ�¡�
    ���ǿ��Բ�������������˳��

	 */
	public static int[] intersect(int[] nums1, int[] nums2) {		
		if(nums1==null || nums2==null) return new int[0];
		List<Integer> temp=new ArrayList<>();
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<nums1.length;i++) {
			Integer value=map.get(nums1[i]);
			map.put(nums1[i], (value==null?0:value)+1);
		}
		for(int i=0;i<nums2.length;i++) {
			if(map.containsKey(nums2[i]) && map.get(nums2[i])!=0) {
				temp.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i])-1);
			}
		}
		int[] res=new int[temp.size()];
		int i=0;
		for(Integer e:temp) {
			res[i++]=e;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums1=new int[] {1,2,2,1};
		int[] nums2=new int[] {2,2};
		int[] res=intersect(nums1, nums2);
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+" ");
		}
	}
}
