package com.demo.leetcode.双指针;
/**
 * 题目描述：判断一个数是否是两树平方和
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * @author WangShuaiJie
 *
 */
public class JudgeSquareSum {
	public boolean judgeSquareSum(int target) {
		//对目标值开方取整
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
