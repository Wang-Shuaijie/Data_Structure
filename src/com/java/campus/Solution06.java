package com.java.campus;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  Ȧ���˶��������úܶ�ľ�����ڵ������һ���������0�Ķ���Ρ�
С��ϲ��Ȧ���˶�����������ҪȥС���������һЩľ��������Ȧ��һ�������С������սһ��С�������Ը�С��������һЩ�ϰ����ϰ��ֱ��ǣ�
1.���С��Ҫ���i��ľ���Ļ������ͱ����ǰi-1��ľ������������
2.���˵�ľ������������Ȧ���˶��С�
��ô����С����������ٸ�ľ��������ʹ��ľ��Χ�ɵ�ͼ���Ǹ��������0������أ�
��������:
��һ��һ����n����ʾľ��������
�ڶ���n��������i������ʾ��i��ľ���ĳ���ai
1<=n<=10000
1<=ai<=10000

�������:
���һ��������ʾ������Ҫ��ľ������������޽����-1

��������1:
3
6 8 10

�������1:
3

����˵��1:
������6��8��10��ľ���������һ��ֱ�������ε�ͼ��

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
        //ǰn�ʹ���n+1
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
