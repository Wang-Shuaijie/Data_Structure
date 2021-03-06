package com.java.leetcode.二分查找;
/**
 * Input: 4
Output: 2

Input: 8
Output: 2
 * 一个数 x 的开方 sqrt 一定在 0 ~ x 之间，并且满足 sqrt == x / sqrt。
 * 可以利用二分查找在 0 ~ x 之间查找 sqrt。
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
