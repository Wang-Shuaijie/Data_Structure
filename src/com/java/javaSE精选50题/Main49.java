package com.java.javaSE��ѡ50��;
/**
 * ��Ŀ�������ַ������Ӵ����ֵĴ���

�����������string���͵��ַ�����ÿ��Ԫ�أ�ת��Ϊchar���������ÿ�������ֵstring.toCharArray()
 * @author WangShuaiJie
 *
 */
public class Main49 {
	//�ж�char�������Ƿ���ڿո񣬴��ڵĻ����ַ���������1
	private static int count(String str) {
		int count=0;
		for(char c:str.toCharArray()) {
			if(c==' ') {
				count++;
			}
		}
		return count;
	}
}
