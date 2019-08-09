package com.java.campus;

import java.util.Scanner;
import java.util.TreeSet;
/**
 * 有一批订单记录，数据有订单号，入店时间，离店时间；
输入一个时间值A，需要在这批记录中找到符合入离店时间范围（A大于等于入店时间，并且A小于等于离店时间）内的所有记录。 单次查询时间复杂度控制在O(logN)
※注意：订单号升序输出
 * @author WangShuaiJie
 *
 */
public class Solution07 {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long A=sc.nextLong();
        int[] nums=new int[n];
        long[] enter=new long[n];
        long[] out=new long[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
            enter[i]=sc.nextLong();
            out[i]=sc.nextLong();
        }
        TreeSet<Integer> res=getResult(nums,A,enter,out);
        if(res.size()==0) {
            System.out.println("null");
        }else{
            for(int i:res){
                System.out.println(i);
            }
        }
             
    }
     
    private static TreeSet<Integer> getResult(int[] nums, long A, long[] enter, long[] out){
        TreeSet<Integer> res=new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(A>=enter[i] && A<=out[i]){
                res.add(nums[i]);
            }
        }
        return res;
    }
}
