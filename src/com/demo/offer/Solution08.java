package com.demo.offer;

public class Solution08 {
	/**
	 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
	 *  ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء� 
	 *  ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0
	 *  
	 *  ˼·�����ö��ַ����ҵ��м������Ȼ�������ߵ�ֵ���бȽϣ�����������ߵ�����
	 *  ������ߴ�mid��ʼ����С�����ұ�ֵ�������ұߴ�mid��ʼ������������ֵ��ȣ�
	 *  ��ȡmidǰ��ֵ�н�С������
	 */
	public int minNumberInRotateArray(int[] nums) {
		if(nums.length==0 || nums==null) return 0;
		int left=0;
		int right=nums.length-1;
		int res=Integer.MAX_VALUE;
		while(left<=right) {
			int mid=(right-left)/2+left;
			//�޷�ת
			if(nums[left]<nums[right]) {
				return Math.min(nums[left], res);
			}else {
				// num[mid] is on the left rotated part.
				if(nums[mid]>=nums[left]) {
					left=mid+1;
				}else {// num[mid] is on the right rotated part.
					res=nums[mid];
					right=mid-1;
				}
			}
		}
		return res;
	}
}
