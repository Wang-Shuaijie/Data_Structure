package com.java.javaSE��ѡ50��;
/**
 * ��Ŀ����ӡ����������Σ�Ҫ���ӡ��10������ͼ��
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
	        arr[i][0]=1;//���Ƶ�һ�е�������1
	   }
	    /**
	     * ʹ������forѭ����i�����У�j�����У�
	     * �ӵڶ��еڶ�����arr[i][j]=arr[i-1][j-1]+arr[i-1][j]
	     */
	   for (int i = 1; i < arr.length; i++) {
	       for (int j=1; j < arr.length; j++) {
	          arr[i][j]=arr[i-1][j-1]+arr[i-1][j];//��ֵ
	       }
	   }
	   //��ӡ���
	   for (int i = 0; i < arr.length ; i++) {
	       for (int k = arr.length-i;k>0;k--) {//�ո�Ŀ��ƣ�Ϊ�˺ÿ�
	          System.out.print("  ");
	       }
	       for (int j = 0; j < arr.length; j++) {//��ӡ�����������

	          if (arr[i][j]!=0) {//�Ѱ�û��ֵ����ȥ��

	              System.out.print(arr[i][j]+"   ");
	          }
	       }
	       System.out.println();//���ƻ���
	   }
	}
}
