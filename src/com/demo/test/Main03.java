package com.demo.test;

import java.util.Arrays;

/**
 * ��˾��֯�Ž������ĳƯ��ʥ��Ư����������������� Ա���������ز�һ���� i ���˵�����Ϊ people[i]��ÿ��Ư�������Գ��ص��������Ϊ
 * limit�� ÿ�Ҵ�����ͬʱ�����ˣ�����������Щ�˵�����֮�����Ϊ limit��
 * Ϊ��ʡ��֧���鷳��æ������ص�ÿһ�����������С��ֻ��(��֤ÿ���˶��ܱ�����)�� ��������: ��һ���������Ư������Ա��Ӧ���������飬
 * 
 * �ڶ�������Ư�������ص��������
 * 
 * �������: ������С��ֻ�� ʾ��1 ���� 1 2 3 ��� 1
 * 
 * @author WangShuaiJie
 *
 */
public class Main03 {
	public int countLeastBoat(int[] nums, int maxLoad) {
		Arrays.sort(nums);
		int count = 0;
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			if (nums[i] + nums[j] <= maxLoad) {
				i++;
				j--;
			} else {
				j--;
			}
			count++;
		}
		return count + (j == i ? 1 : 0);
	}
}
