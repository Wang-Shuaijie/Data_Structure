package com.java.campus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
12
���ħ�˲�ŷ�Ժ����������n��ͽ�ܣ�ÿ��ͽ��ս����������ͬ�����̵����е�ͽ�ܺ������������ս����Ϊԭս������ˡ��κ�����ͽ�ܶ����Ժ��壬����һ����n*(n-1)/2�ֺ���ͽ�ܡ���һ�죬���뿼��һ��������ս������Σ�ϣ��������n*(n-1)/2�ֺ���ͽ����ѡ��ս������k�ߵģ����������ս�����������ͽ��̫���ˣ�����Ȼ�±ƣ������ҵ����㣬��������ҵ��Ե��ˡ�

��������:
��һ������int��ͽ��������n <= 1*10^6��ս��������:k <= n*(n-1)/2
�ڶ��пո�ָ�n��int����ʾÿ��ͽ�ܵ�ս������



�������:
ս��������k�ĺ���ͽ��ս������

ʾ��1
����
5 2
1 3 4 5 9

���
36
 * @author WangShuaiJie
 *
 */
public class Solution23 {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        ArrayList<Integer> list=getMultiply(nums);
        Collections.sort(list);
        System.out.println(list.get(list.size()-k));
    }
     
    public static ArrayList<Integer> getMultiply(int[] nums){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            while(j<nums.length){
                list.add(nums[i]*nums[j]);
                j++;
            }
        }
        return list;
    }
}
