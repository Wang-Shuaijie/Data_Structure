package com.java.javaSE��ѡ50��;
/**
 * ��Ŀ�����9*9�ھ���
 * ����������������п��ǣ���9��9�У�i�����У�jC�С�
 * ���ʽ�� i+��*��+j+��=��+i*j������Ҫ������forѭ����������ͻ���
 * @author WangShuaiJie
 *
 */
public class Main16 {
	public static void main(String[] args) {
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(i+"*"+j+"="+i*j+" ");//������
			}
			System.out.println();
		}
	}
}
