package com.demo.exercise;
/**
 * ��Ŀ����1��2��3��4�����֣�����ɶ��ٸ�������ͬ�����ظ����ֵ���λ�������Ƕ��٣�
 * @author WangShuaiJie
 *
 */
public class Main11 {
	//���ڰ�λ��ʮλ����λ�����ֶ���1��2��3��4������Ҫ��3��forѭ��
	public static void main(String[] args) {
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=4;j++) {
				for(int k=1;k<=4;k++) {
					if(i!=j && j!=k && i!=k) {
						System.out.println(i*100+j*10+k);
					}
				}
			}
		}
	}
}
