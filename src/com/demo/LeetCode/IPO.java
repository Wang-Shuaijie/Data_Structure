package com.demo.LeetCode;

import java.util.PriorityQueue;

public class IPO {
	/**
	 * ���� LeetCode ������ʼ�� IPO��Ϊ���Ը��ߵļ۸񽫹�Ʊ��������Ͷ�ʹ�˾��LeetCodeϣ���� IPO ֮ǰ��չһЩ��Ŀ���������ʱ��� ������Դ���ޣ���ֻ���� IPO ֮ǰ������ k ����ͬ����Ŀ������ LeetCode ��������� k ����ͬ��Ŀ��õ�������ʱ��ķ�ʽ��
�������ɸ���Ŀ������ÿ����Ŀ i��������һ�������� Pi��������Ҫ��С���ʱ� Ci ��������Ӧ����Ŀ����������� W �ʱ����������һ����Ŀʱ���㽫��ô����������󽫱���ӵ�������ʱ��С�
�ܶ���֮���Ӹ�����Ŀ��ѡ����� k ����ͬ��Ŀ���б�����������ʱ�����������տɻ�õ�����ʱ���

ʾ�� 1:

����: k=2, W=0, (��õ�����)Profits=[1,2,3], (��Ҫ���ʱ�)Capital=[0,1,1].

���: 4

����:
������ĳ�ʼ�ʱ�Ϊ 0����ֻ���Դ� 0 ����Ŀ��ʼ��
����ɺ��㽫��� 1 ������������ʱ�����Ϊ 1��
��ʱ�����ѡ��ʼ 1 �Ż� 2 ����Ŀ��
������������ѡ��������Ŀ����������Ҫ��� 2 ����Ŀ�Ի�������ʱ���
��ˣ���������󻯵��ʱ���Ϊ 0 + 1 + 3 = 4��

	 */
	
	public static int findMaximizedCapital(int k,int W,int[] Profits,int[] Capital) {
		/*
		 * �ҳ�ÿ��������capital�����profit��project.
		     ��������heap ���� capital �� profit�Ķ�, һ�� min heap ��С������capital����. һ��max heap�Ӵ�С����profit����.
                   ������capitalС�����жԶ��� min heap��poll�����ӵ�max heap��, ��ͷ�ľ���С��capital���profit��project.
		 */
		//(a,b)->a[0]-b[0]�ȽϺ���������Ҫ��
		PriorityQueue<int[]> capMinHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
		PriorityQueue<int[]> proMaxHeap=new PriorityQueue<>((a,b)->b[1]-a[1]);
		
		for(int i=0;i<Profits.length;i++) {
			capMinHeap.add(new int[] {Capital[i],Profits[i]});
		}

		for(int i=0;i<k;i++) {
			while(!capMinHeap.isEmpty() && capMinHeap.peek()[0]<=W) {
				proMaxHeap.add(capMinHeap.poll());
			}
			if(proMaxHeap.isEmpty()) {
				break;
			}
			W+=proMaxHeap.poll()[1];
		}
		return W;
	}
	
	public static void main(String[] args) {
		int k=2,W=0;
		int[] Profits=new int[] {1,2,3};
		int[] Capital=new int[] {0,1,1};
		System.out.println(findMaximizedCapital(k, W, Profits, Capital));
	}
}
