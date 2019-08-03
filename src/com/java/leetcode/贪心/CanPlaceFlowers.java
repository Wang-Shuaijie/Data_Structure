package com.java.leetcode.贪心;
/**
 * Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
题目描述：flowerbed 数组中 1 表示已经种下了花朵。花朵之间至少需要一个单位的间隔，求解是否能种下 n 朵花。
 * @author WangShuaiJie
 *
 */
public class CanPlaceFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int len=flowerbed.length;
		int cnt=0;
		for(int i=0;i<len && cnt<n; i++) {
			if(flowerbed[i]==1) continue;
			int pre=i==0?0:flowerbed[i-1];
			int next=i==len-1?0:flowerbed[i+1];
			if(pre==0 && next==0) {
				cnt++;
				flowerbed[i]=1;
			}
		}
		return cnt>n;
	}
}
