package com.java.campus;
/**
 * (�����)�����ɼ����
����һ������n����n�ֽ�Ϊ������������֮�ͣ�ʹ����Щ�����ĳ˻���󻯣�����ܹ���õ����ĳ˻���
���磺
2=1+1�����1��
10=3+3+4�����36�� 
 * @author WangShuaiJie
 *
 */
public class Solution05 {
	/*
	 * ˼·���ֽ������3Խ�࣬�˻�Խ�󣬾�����ѧ֤�����������ҡ����ֽ⵽ʣ4������ʱ�����Կ�����ʱ�ٷֽ������С����˲���ֽ⣬ֱ����˼��ɡ�
	 */
	private static int getMaxMultiply(int n) {
		if(n==2) return 1;
		if(n==3) return 2;
		if(n==4) return 4;
		int res=1;
		while(n>4) {
			res*=3;
			n=n-3;
		}
		return res*n;
	}
	
}
