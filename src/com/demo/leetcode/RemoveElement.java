package com.demo.leetcode;

public class RemoveElement {
	/**
	 * ����һ������ nums ��һ��ֵ val������Ҫԭ���Ƴ�������ֵ���� val ��Ԫ�أ������Ƴ���������³��ȡ�
	 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
	 * Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
	 * ʾ�� 1:
	 * ���� nums = [3,2,2,3], val = 3,
	 * ����Ӧ�÷����µĳ��� 2, ���� nums �е�ǰ����Ԫ�ؾ�Ϊ 2��
	 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
	 * 
	 */
	public static int removeElement(int[] nums,int val) {
		if(nums==null || nums.length==0) return 0;
		int res=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=val) {
				//��¼������
				nums[res]=nums[i];
				res++;
			}
		}
		return res;
		
	}
	
	
	public static void main(String[] args) {
		int[] nums=new int[] {1,1,2,3};
		System.out.println(removeElement(nums, 1));
	}
}
