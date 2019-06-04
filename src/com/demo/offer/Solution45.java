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
	
	public static int yesefu(int n, int m) {
		 if (m == 0 || n == 0) {
	            return -1;
	        }
	        ArrayList<Integer> data = new ArrayList<Integer>();
	        for (int i = 0; i < n; i++) {
	            data.add(i);
	        }
	        int index = -1;
	        while (data.size() > 1) {
//	          System.out.println(data);
	            index = (index + m) % data.size();
//	          System.out.println(data.get(index));
	            data.remove(index);
	            index--;
	        }
	        return data.get(0);
	}
	
	int LastRemaining_Solution(int n, int m) {
		 if(n==0||m==0)return -1;
	        int s=0;
	        for(int i=2;i<=n;i++)
	        {
	            s=(s+m)%i;
	        }   
	       return s ;
    }
	
	//f[1]=0;
	//f[i]=(f[i-1]+m)%i;  (i>1) 
	int LastRemaining_Solution2(int n, int m)
    {
        if(n==0)
            return -1;
        if(n==1)
            return 0;
        else
            return (LastRemaining_Solution(n-1,m)+m)%n;
    }
	
	public static void main(String[] args) {
		System.out.println(yesefu(5, 3));
	}
}
