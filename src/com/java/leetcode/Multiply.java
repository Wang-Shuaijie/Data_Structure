package com.java.leetcode;

public class Multiply {
	/**
	 * �����������ַ�����ʽ��ʾ�ķǸ����� num1 �� num2��
	 * ���� num1 �� num2 �ĳ˻������ǵĳ˻�Ҳ��ʾΪ�ַ�����ʽ��
ʾ�� 1:

����: num1 = "2", num2 = "3"
���: "6"
	 */
	
	public static String multiply(String num1,String num2) {
		//����ʹ��int num=Integer.parseInt(num1);
		/**
		 * ������������������ַ������ֵ���ˣ�
		 * ������������ͷ��ص����������ַ�����ʽ����ģ�
		 * ��������ԭ��������������Լ��㳬������ˣ�
		 * ���Բ���int��long����ֵ��Χ��Լ������ô���Ǹ����������˷��أ�
		 * ����Сʱ��ѧ����λ���ĳ˷����̣�����ÿλ���Ȼ���λ��ӣ�
		 * �Ѵ�λ��Ӻ�Ľ�����浽һ��һά�����У�Ȼ��ֱ�ÿλ�����λ��
		 * ���ÿ�����ֶ����һλ��Ȼ��Ҫ������ȥ������λ0��
		 * ����ÿλ�ϵ����ְ�˳�򱣴浽����м���
		 */
		if(num1==null || num2==null) return "0";
		int[] digits=new int[num1.length()+num2.length()];
		for(int i=num1.length()-1;i>=0;i--) {
			for(int j=num2.length()-1;j>=0;j--) {
				int product=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
				
				int p1=i+j,p2=i+j+1;
				int sum=product+digits[p2];
				digits[p1]+=sum/10;
				digits[p2]=sum%10;
				
			}
		}
		StringBuilder res=new StringBuilder();
		for(int digit:digits) {
			if(!(digit==0 && res.length()==0)) {
				res.append(digit);
			}
		}
		return res.length()==0?"0":res.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(multiply("12", "5"));
	}
}
