package com.demo.offer;

import java.util.ArrayList;

public class Solution45 {
	/**
	 * ԲȦ�����ʣ�µ����֣�Լɪ�򻷣�
	 * ��֪n����(�Ա��1��2��3...n�ֱ��ʾ)Χ����һ��Բ����Χ��
	 * �ӱ��Ϊk���˿�ʼ����������m���Ǹ��˳���;
	 * ������һ�����ִ�1��ʼ����������m���Ǹ����ֳ���;
	 * ���˹����ظ���ȥ��ֱ��Բ����Χ����ȫ�����С�
	 * 
	 * ������n���ˣ���1��n������һ��ArrayList�У����ÿ�ʼ�ı��k(��Ϊ0��Ϊ��һ���ˣ���
	 * ������Ҫ��������1�����õ���Ҫ�����˵�������Ҫע��Ҫ���е����ǲ������һ���ˣ�Ҫ���⴦����ArrayListΪ�գ������
	 */
	
	public static void yesefu(int totalNum, int countNum) {
		//��ʼ������
		ArrayList<Integer> start=new ArrayList<>();
		for(int i=0;i<=totalNum;i++) {
			start.add(i);
		}
		 //�ӵ�k������ʼ����
        int k = 0;
        while(start.size()>0) {
        	k=k+countNum;
        	 //��m�˵�����λ��
            k = k % (start.size()) - 1;//��Ϊ�����Ǵ�0��ʼ������ȡ������Ϊ��ֹk����Ȧ���˵�����
            //�ж��Ƿ񵽶�β����k�Ĵ�СΪstart�Ĵ�С����ʱkΪ-1
            if(k<0) {
            	//�������β�ˣ��������βԪ��
            	System.out.println(start.get(start.size()-1)+" ");
            	start.remove(start.size()-1);
            	k=0;
            }else {
            	//����ֱ�����k��Ӧ��Ԫ��
                System.out.print(start.get(k)+" ");
                start.remove(k);
            }
        }
	}
	
	public static void main(String[] args) {
		yesefu(10, 3);
	}
}
