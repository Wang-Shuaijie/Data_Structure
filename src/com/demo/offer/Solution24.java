package com.demo.offer;

public class Solution24 {
	/**
	 * ����һ���������飬�жϸ������ǲ���ĳ��Ԫ�������ĺ�������Ľ��������Ƿ���true�����򷵻�false��

��������5��7��6��9��11��10��8��������һ�����������������ĺ�����������

         8
       / \
      6   10
    / \    / \
   5  7   9  11

��˷���true��

�������7��4��6��5��û���Ŀ����ĺ�������Ľ����������У���˷���false��


�㷨˼�룺�����������������һ���ڵ��Ƕ������ĸ��ڵ㣬�����ǰ�벿�ֶ�С�ڸ��ڵ�(��Ϊ�Ƕ�Ԫ������)����벿�ֶ����ڸ��ڵ㡣

˼·�����ҵ��������Ŀ�ʼλ�ã�Ȼ��ֱ�������������ݹ鴦��
	 */
	public boolean verifySequenceofBST(int[] sequence) {
		if(sequence==null || sequence.length==0) return false;
		return helper(sequence, 0, sequence.length-1);
	}
	
	private boolean helper(int[] sequence, int left, int right) {
		if(left>=right) {
			return true;
		}
		int i=left;
		//�ҵ�������
		for(;i<right-1;i++) {
			if(sequence[i]>sequence[right]) {
				break;
			}
		}
		int j=i;
		for(;j<right-1;j++) {
			if(sequence[j]<sequence[right]) {
				return false;
			}
		}
		return helper(sequence, left, i-1) && helper(sequence, i, right-1);
	}
}
