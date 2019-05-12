package com.demo.leetcode;

public class Candy {
	/**
	 * ��ʦ��������Ƿַ��ǹ����� N ������վ����һ��ֱ�ߣ���ʦ�����ÿ�����ӵı��֣�Ԥ�ȸ��������֡�

����Ҫ��������Ҫ�󣬰�����ʦ����Щ���ӷַ��ǹ���

    ÿ���������ٷ��䵽 1 ���ǹ���
    ���ڵĺ����У����ָߵĺ��ӱ����ø�����ǹ���

��ô������������ʦ������Ҫ׼�����ٿ��ǹ��أ�

ʾ�� 1:

����: [1,0,2]
���: 5
����: ����Էֱ�����������ӷַ� 2��1��2 ���ǹ���

	 */
	
	public static int candy(int[] ratings) {
		if(ratings.length==0 && ratings==null) return 0;
		int[] candyNum=new int[ratings.length];
		int res=0;
		//��ʼÿ��һ����
		for(int i=0;i<candyNum.length;i++) {
			candyNum[i]=1;
		}
		/*
		 * ����д�����󣬻������һ�������
		 * ����Ӧ�÷ֿ������αȽ�
		for(int i=0;i<ratings.length;i++) {
			if(i!=0 && ratings[i]>ratings[i-1] ){
				candyNum[i]=candyNum[i-1]+1;
			}
			if(i!=ratings.length-1 && ratings[i]>ratings[i+1]) {
				candyNum[i]=candyNum[i+1]+1;
			}
		}
		*/
		for(int i=0;i<ratings.length-1;i++) {
			//���κ���߱�
			if(ratings[i+1]>ratings[i]) {
				candyNum[i+1]=candyNum[i]+1;
			}
		}
		for(int i=ratings.length-1;i>0;i--) {
			//���κ��ұ߱�
			if(ratings[i-1]>ratings[i] ){
				candyNum[i-1]=Math.max(candyNum[i]+1,candyNum[i-1]);
			}
		}
		
		
		for(int i=0;i<candyNum.length;i++) {
			res+=candyNum[i];
		}
		
		return res;
		
	}
	
	public static void main(String[] args) {
		int[] ratings=new int[] {1,2,87,87,87,2,1};
		System.out.println(candy(ratings));
	}
}
