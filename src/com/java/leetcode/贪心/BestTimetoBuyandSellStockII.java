package com.java.leetcode.̰��;
/**
 * ��Ŀ���������Խ��ж�ν��ף���ν���֮�䲻�ܽ�����У����Խ��ж�ν��ס�

���� [a, b, c, d]������� a <= b <= c <= d ����ô�������Ϊ d - a��
�� d - a = (d - c) + (c - b) + (b - a) ����˵����ʵ�һ�� prices[i] �� prices[i] - prices[i-1] > 0��
��ô�Ͱ� prices[i] - prices[i-1] ��ӵ������С�
 * @author WangShuaiJie
 *
 */
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += (prices[i] - prices[i - 1]);
			}
		}
		return profit;
	}
}
