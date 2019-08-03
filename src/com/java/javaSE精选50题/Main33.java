package com.java.javaSE精选50题;
/**
 * 题目：打印出杨辉三角形（要求打印出10行如下图）
 *                  1   
                  1   1   
                1   2   1   
              1   3   3   1   
            1   4   6   4   1   
          1   5   10   10   5   1   
        1   6   15   20   15   6   1   
      1   7   21   35   35   21   7   1   
    1   8   28   56   70   56   28   8   1   
  1   9   36   84   126   126   84   36   9   1  
 * @author WangShuaiJie
 *
 */
public class Main33 {
	public static void main(String[] args) {
	    int[][]arr=new int[10][10];
	    for (int i = 0; i < arr.length; i++) {
	        arr[i][0]=1;//控制第一列的数等于1
	   }
	    /**
	     * 使用两个for循环，i控制行，j控制列；
	     * 从第二行第二列起arr[i][j]=arr[i-1][j-1]+arr[i-1][j]
	     */
	   for (int i = 1; i < arr.length; i++) {
	       for (int j=1; j < arr.length; j++) {
	          arr[i][j]=arr[i-1][j-1]+arr[i-1][j];//赋值
	       }
	   }
	   //打印结果
	   for (int i = 0; i < arr.length ; i++) {
	       for (int k = arr.length-i;k>0;k--) {//空格的控制，为了好看
	          System.out.print("  ");
	       }
	       for (int j = 0; j < arr.length; j++) {//打印出数组的数字

	          if (arr[i][j]!=0) {//把把没赋值的零去掉

	              System.out.print(arr[i][j]+"   ");
	          }
	       }
	       System.out.println();//控制换行
	   }
	}
}
