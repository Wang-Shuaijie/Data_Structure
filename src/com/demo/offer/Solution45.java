package com.demo.offer;

import java.util.ArrayList;

public class Solution45 {
	/**
	 * 圆圈中最后剩下的数字（约瑟夫环）
	 * 已知n个人(以编号1，2，3...n分别表示)围坐在一张圆桌周围。
	 * 从编号为k的人开始报数，数到m的那个人出列;
	 * 他的下一个人又从1开始报数，数到m的那个人又出列;
	 * 依此规律重复下去，直到圆桌周围的人全部出列。
	 * 
	 * 假设有n个人，从1到n，放入一个ArrayList中，设置开始的编号k(设为0，为第一个人），
	 * 加上需要报的数减1，即得到需要出列人的索引，要注意要出列的人是不是最后一个人，要特殊处理。当ArrayList为空，则完成
	 */
	
	public static void yesefu(int totalNum, int countNum) {
		//初始化人数
		ArrayList<Integer> start=new ArrayList<>();
		for(int i=0;i<=totalNum;i++) {
			start.add(i);
		}
		 //从第k个数开始计数
        int k = 0;
        while(start.size()>0) {
        	k=k+countNum;
        	 //第m人的索引位置
            k = k % (start.size()) - 1;//因为索引是从0开始，进行取余是因为防止k大于圈中人的总数
            //判断是否到队尾，即k的大小为start的大小，此时k为-1
            if(k<0) {
            	//如果到队尾了，则输出队尾元素
            	System.out.println(start.get(start.size()-1)+" ");
            	start.remove(start.size()-1);
            	k=0;
            }else {
            	//否则，直接输出k对应的元素
                System.out.print(start.get(k)+" ");
                start.remove(k);
            }
        }
	}
	
	public static void main(String[] args) {
		yesefu(10, 3);
	}
}
