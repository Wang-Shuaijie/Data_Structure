package com.demo.LeetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionofTwoArrays {
	/**
	 * Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:

    Each element in the result must be unique.
    The result can be in any order.

��������������������齻���Ĳ��֣��������ظ����֣����ѶȲ�������ǿ����ø�set��nums1���Ž�ȥ��
Ȼ�����nums2��Ԫ�أ������set�д��ڣ�˵���ǽ����Ĳ��֣���������set�У�����ٰѽ��תΪint[]����ʽ���ɣ�
	 */
	public static int[] intersect(int[] nums1, int[] nums2) {
		//set�������ظ�Ԫ��
		Set<Integer> set=new HashSet<>();
		Set<Integer> temp=new HashSet<>();
		for(int i=0;i<nums1.length;i++) {
			set.add(nums1[i]);
		}
		for(int i=0;i<nums2.length;i++) {
			if(set.contains(nums2[i])) {
				temp.add(nums2[i]);
			}
		}
		int[] res=new int[temp.size()];
		Iterator<Integer> it=temp.iterator();
		int count=0;
		while(it.hasNext()) {
			//System.out.println(it.next());
			res[count++]=it.next();
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
