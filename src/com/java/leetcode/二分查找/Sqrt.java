package com.java.leetcode.���ֲ���;
/**
 * Input: 4
Output: 2

Input: 8
Output: 2
 * һ���� x �Ŀ��� sqrt һ���� 0 ~ x ֮�䣬�������� sqrt == x / sqrt��
 * �������ö��ֲ����� 0 ~ x ֮����� sqrt��
 * @author WangShuaiJie
 *
 */
public class Sqrt {
	public int mySqrt(int x) {
		if(x<=1) return x;
		int left=1, right=x;
		while(left<=right) {
			int mid=left+(right-left)/2;
			int sqrt=x/mid;
			if(sqrt==mid) {
				return mid;
			}else if(mid>sqrt) {
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		return right;
	}
}
