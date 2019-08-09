package com.java.leetcode.���ֲ���;
/**
 * ��Ŀ����������һ��Ԫ�� n ������ [1, 2, ..., n] �汾��
 * �ڵ� x λ�ÿ�ʼ���ִ���汾�����º���İ汾������
 * ���Ե��� isBadVersion(int x) ֪��ĳ���汾�Ƿ����Ҫ���ҵ���һ������İ汾��

����� m ���汾�������ʾ��һ������İ汾�� [l, m] ֮�䣬�� h = m��
�����һ������İ汾�� [m + 1, h] ֮�䣬�� l = m + 1��
 * @author WangShuaiJie
 *
 */
public class FirstBadVersion {
	public int firstBadVersion(int n) {
		int l=1, h=n;
		while(l<h) {
			int mid=l+(h-l)/2;
			if(isBadVersion(mid)) {
				h=mid;
			}else {
				l=mid+1;
			}
		}
		return l;
	}

	private boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}
}
