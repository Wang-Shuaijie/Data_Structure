package com.java.javaSE��ѡ50��;
/**
 * ��Ŀ����һ�������У�2/1��3/2��5/3��8/5��13/8��21/13�����������е�ǰ20��֮�͡�
 * @author WangShuaiJie
 *
 */
public class Main20 {
	/**
	 *  1����һ����2/1
	 *  2��ǰ��һ����Ӻͷ�ĸ��ӵĺͣ�Ϊ��һ��ķ���
	 *  3��ǰ��һ����ӣ�Ϊ��һ��ķ�ĸ 
	 */
	public static void main(String[] args) {
		float up=2;
		float down=1;
		float temp=0;
		float fraction=up/down;//����
		float sum=0;
		for(int i=0;i<20;i++) {
			sum+=fraction;
			temp=up+down;
			down=up;
			up=temp;
			fraction=up/down;
		}
		System.out.println(sum);
	}
	
	private static long getGcd(int m, int n) {
		if(m<n) {
			m=m+n;
			n=m-n;
			m=m-n;
		}
		if(m%n==0) return n;
		else {
			m=m%n;
			return getGcd(m, n);
		}
	}
}
