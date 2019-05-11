package com.demo.LeetCode;

import java.util.PriorityQueue;

public class IPO {
	/**
	 * 假设 LeetCode 即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，LeetCode希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 LeetCode 设计完成最多 k 个不同项目后得到最大总资本的方式。
给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。

示例 1:

输入: k=2, W=0, (获得的利益)Profits=[1,2,3], (需要的资本)Capital=[0,1,1].

输出: 4

解释:
由于你的初始资本为 0，你只可以从 0 号项目开始。
在完成后，你将获得 1 的利润，你的总资本将变为 1。
此时你可以选择开始 1 号或 2 号项目。
由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。

	 */
	
	public static int findMaximizedCapital(int k,int W,int[] Profits,int[] Capital) {
		/*
		 * 找出每次在现有capital内最大profit的project.
		     利用两个heap 保存 capital 和 profit的对, 一个 min heap 从小到大按照capital保存. 一个max heap从大到小按照profit保存.
                   比现有capital小的所有对都从 min heap中poll出来加到max heap里, 顶头的就是小于capital最大profit的project.
		 */
		//(a,b)->a[0]-b[0]比较函数，必须要有
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
