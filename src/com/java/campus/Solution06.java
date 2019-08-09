package com.java.campus;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  圈地运动，就是用很多木棍摆在地上组成一个面积大于0的多边形～
小明喜欢圈地运动，于是他需要去小红店里面买一些木棍，期望圈出一块地来。小红想挑战一下小明，所以给小明设置了一些障碍。障碍分别是：
1.如果小明要买第i块木棍的话，他就必须把前i-1块木棍都买下来。
2.买了的木棍都必须用在圈地运动中。
那么请问小明最少买多少根木棍，才能使得木棍围成的图形是个面积大于0多边形呢？
输入描述:
第一行一个数n，表示木棍个数。
第二行n个数，第i个数表示第i个木棍的长度ai
1<=n<=10000
1<=ai<=10000

输出描述:
输出一个数，表示最少需要的木棍个数，如果无解输出-1

输入例子1:
3
6 8 10

输出例子1:
3

例子说明1:
用三根6，8，10的木棍可以组成一个直角三角形的图形

 * @author WangShuaiJie
 *
 */
public class Solution06 {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        //int[] arr=new int[] {1,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,2180,3481,2613,82,5212,5589,6408,6736,8888,7749,8395,8270,1518,6766,1748};
        System.out.println(getMinResult(nums));
    }
    
    private static int getMinResult(int[] nums){
        //前n和大于n+1
        int sum=nums[0]+nums[1];
        int max=nums[0]>nums[1]?nums[0]:nums[1];
        for(int i=2;i<nums.length;i++){
          if(nums[i]>max) {
        	  max=nums[i];
          }
          sum+=nums[i];
          if(sum-max>max) {
        	  return i+1;
          }
        }
        return -1;
    }
}
