package com.demo.leetcode.˫ָ��;
/**
 * ��Ŀ�������ж�һ�����Ƿ�������ƽ����
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * @author WangShuaiJie
 *
 */
public class JudgeSquareSum {
	public boolean judgeSquareSum(int target) {
		//��Ŀ��ֵ����ȡ��
		int i=0, j=(int)Math.sqrt(target);
		while(i<=j) {
			int powSum=i*i+j*j;
			if(powSum==target) {
				return true;
			}else if(powSum<target) {
				i++;
			}else {
				j--;
			}
		}
		return false;
	}
}
