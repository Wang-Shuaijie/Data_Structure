package com.java.campus;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ����һ����������,�ж������Ƿ���3������ΪN
 * @author WangShuaiJie
 *
 */
public class Solution18 {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] s=str.split(",");
        String[] n=s[0].split(" ");
        int[] nums=new int[n.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.valueOf(n[i]);
        }
        int target=Integer.valueOf(s[1]);
        if(isThreeSum(nums, target)){
            System.out.println("True");
        }else{
             System.out.println("False");
        }
    }
     
    private static boolean isThreeSum(int[] nums, int target){
        Arrays.sort(nums);
        if(nums.length==0 || nums==null) return false;
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            int sum=target-nums[i];
            while(j<k){
                if(nums[j]+nums[k]==sum){
                    return true;
                }else if(nums[j]+nums[k]<sum){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return false;
    }
}
