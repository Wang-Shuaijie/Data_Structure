package com.java.leetcode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目描述：
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * @author WangShuaiJie
 *
 */
public class TwoSum {
	//使用双指针
	public int[] twoSum(int[] nums, int target) {
		int[] res=new int[] {-1,-1};
		if(nums==null || nums.length==0) return res;
		int i=0;//头指针
		int j=nums.length-1;//尾指针
		while(i<j) {
			int sum=nums[i]+nums[j];
			if(sum == target) {
				res[0]=i;
				res[1]=j;
			}else if(sum < target) {
				i++;
			}else {
				j++;
			}
		}
		return res;
		
	}
	
	
	
	//使用map解
	public int[] twoSum2(int[] nums, int target) {
		int[] res=new int[] {-1,-1};
		if(nums==null || nums.length==0) return res;
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(target-nums[i])) {
				res[0]=map.get(target-nums[i]);
				res[1]=i;
			}
			map.put(nums[i], i);
		}
		return res;
	}
	
	
	//延伸题，ThreeSum，FourSum
	/**
	 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
	 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组
	 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
	 * 满足要求的三元组集合为：[
	 * 							[-1, 0, 1],
	 * 							[-1, -1, 2]
	 * 						  ]
	 * (0,1,-1)算重复
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res=new ArrayList<>();
		if(nums==null || nums.length==0) return res;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++) {
			if(i>0 && nums[i]==nums[i-1]) continue;//去重
			int left=i+1, right=nums.length-1, target=0-nums[i];
			while(left<right) {
				int sum=left+right;
				if(sum==target) {
					res.add(Arrays.asList(nums[i],nums[left],nums[right]));;
					while(left<right && nums[left]==nums[left+1]) left++;
					while(left<right && nums[right]==nums[right-1]) right--;
					left++;
					right--;
				}else if(sum<target){
					left++;
				}else {
					right--;
				}
			}
		}
		return res;
	}
	
	//foursum
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++) {
        	//去重
        	if(i>0 && nums[i]==nums[i-1]) continue;
        	for(int j=i+1;j<nums.length-2;j++) {
        		if(j>i+1 && nums[j]==nums[j-1]) continue;
        			
        		int start=j+1,end=nums.length-1,sum=target-nums[i]-nums[j];
        		while(start<end) {
        			if(nums[start]+nums[end]==sum) {
        				res.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
        				//去重
        				while(start<end && nums[start]==nums[start+1]) start++;
        				while(start<end && nums[end]==nums[end-1]) end--;
        				
        				start++;
        				end--;
        			}else if(nums[start]+nums[end]<sum) {
        				start++;
        			}else {
        				end--;
        			}
        		}
        			
        			
        	}
        }
       return res;
 }
}
