package com.demo.LeetCode;

public class RemoveKDigits {
	/**
	 * ����һ�����ַ�����ʾ�ķǸ����� num���Ƴ�������е� k λ���֣�ʹ��ʣ�µ�������С��

ע��:

    num �ĳ���С�� 10002 �� �� k��
    num ��������κ�ǰ���㡣

ʾ�� 1 :

����: num = "1432219", k = 3
���: "1219"
����: �Ƴ����������� 4, 3, �� 2 �γ�һ���µ���С������ 1219��

ʾ�� 2 :

����: num = "10200", k = 1
���: "200"
����: �Ƶ���λ�� 1 ʣ�µ�����Ϊ 200. ע������������κ�ǰ���㡣

ʾ�� 3 :

����: num = "10", k = 2
���: "0"
����: ��ԭ�����Ƴ����е����֣�ʣ��Ϊ�վ���0��

	 */
	public static String removeKdigits(String num,int k) {
		//˼·��124682385  K=1 12462385  k=2 1242385  k=3 122385
		//���Ž���Զ���Ƴ���һ�γ��ֵ�   ��ߵ���>�ұߵ���
		//��������������������Ƴ�
		if(num==null || num.length()==0) return "0";
		//��String����ת��ΪStringBuilder����
		StringBuilder res=new StringBuilder(num);
		for(int i=0;i<k;i++) {
			int j=0;
			while(j<res.length()-1 && res.charAt(j)<=res.charAt(j+1)) {
				j++;			
			}
			//�Ƴ�ĩβ�����	
			if(j==res.length()-1) {
				res.deleteCharAt(j);
			}else {
				res.delete(j, j+1);//�Ƴ�res.charAt(j);			
			}
		}
		//��λ��0�����
		while(res.length()>1 && res.charAt(0)=='0') res.delete(0, 1);
		//ȫ���Ƴ������
		while(res.length()==0) return "0";
		
		return res.toString();
	}
	
	public static void main(String[] args) {
		String num="124682385";
		System.out.println(removeKdigits(num, 3));
	}
}
