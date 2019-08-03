package com.demo.leetcode.̰��;
/**
 * ��Ŀ������һ�ι�Ʊ���װ��������������ֻ����һ�ν��ף���������档

ֻҪ��¼ǰ�����С�۸񣬽������С�۸���Ϊ����۸�Ȼ�󽫵�ǰ�ļ۸���Ϊ�۳��۸񣬲鿴��ǰ�����ǲ����������
 * @author WangShuaiJie
 *
 */
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int n=prices.length;
		if(n==0) return 0;
		int soFarMin=prices[0];
		int max=0;
		for(int i=0;i<n;i++) {
			if(soFarMin>prices[i]) soFarMin=prices[i];
			else max=Math.max(max, prices[i]-soFarMin);
		}
		return max;
	}
}
