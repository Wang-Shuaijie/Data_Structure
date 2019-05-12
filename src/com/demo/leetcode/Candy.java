package com.demo.leetcode;

public class Candy {
	/**
	 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。

你需要按照以下要求，帮助老师给这些孩子分发糖果：

    每个孩子至少分配到 1 个糖果。
    相邻的孩子中，评分高的孩子必须获得更多的糖果。

那么这样下来，老师至少需要准备多少颗糖果呢？

示例 1:

输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。

	 */
	
	public static int candy(int[] ratings) {
		if(ratings.length==0 && ratings==null) return 0;
		int[] candyNum=new int[ratings.length];
		int res=0;
		//初始每人一块糖
		for(int i=0;i<candyNum.length;i++) {
			candyNum[i]=1;
		}
		/*
		 * 这样写解答错误，会出现少一个的情况
		 * 正解应该分开做两次比较
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
			//依次和左边比
			if(ratings[i+1]>ratings[i]) {
				candyNum[i+1]=candyNum[i]+1;
			}
		}
		for(int i=ratings.length-1;i>0;i--) {
			//依次和右边比
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
