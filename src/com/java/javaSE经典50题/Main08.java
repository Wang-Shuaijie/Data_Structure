package com.java.javaSE����50��;
/**
 * ��Ŀ��һ�������ǡ�õ�����������֮�ͣ�������ͳ�Ϊ����������
 * ����6=1��2��3.����ҳ�1000���ڵ�����������
 * @author WangShuaiJie
 *
 */
public class Main08 {
	public static void main(String[] args) {
		for(int i=1;i<=1000;i++) {
			if(isRightNum(i)) {
				System.out.println(i);
			}
		}
	}
	private static boolean isRightNum(int n) {
		int sum=0;
		//�������ᳬ��ԭ������һ��
		for(int i=1;i<=n/2;i++) {
			if(n%i==0) sum=sum+i;
		}
		if(sum==n) return true;
		return false;
	}
}
