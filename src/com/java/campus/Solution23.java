package com.java.campus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
12
打败魔人布欧以后，孙悟空收了n个徒弟，每个徒弟战斗力各不相同。他教导所有的徒弟和体术，合体后战斗力为原战斗力相乘。任何两个徒弟都可以合体，所以一共有n*(n-1)/2种合体徒弟。有一天，他想考验一下孙悟天战斗力如何，希望在所有n*(n-1)/2种合体徒弟中选择战斗力第k高的，与孙悟天对战。可是孙悟空徒弟太多了，他已然懵逼，于是找到了你，请你帮他找到对的人。

输入描述:
第一行两个int。徒弟数量：n <= 1*10^6；战斗力排名:k <= n*(n-1)/2
第二行空格分隔n个int，表示每个徒弟的战斗力。



输出描述:
战斗力排名k的合体徒弟战斗力。

示例1
输入
5 2
1 3 4 5 9

输出
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
