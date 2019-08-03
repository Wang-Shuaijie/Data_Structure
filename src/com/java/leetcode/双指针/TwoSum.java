package com.java.leetcode.˫ָ��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��Ŀ������
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * @author WangShuaiJie
 *
 */
public class TwoSum {
	//ʹ��˫ָ��
	public int[] twoSum(int[] nums, int target) {
		int[] res=new int[] {-1,-1};
		if(nums==null || nums.length==0) return res;
		int i=0;//ͷָ��
		int j=nums.length-1;//βָ��
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
	
	
	
	//ʹ��map��
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
	
	
	//�����⣬ThreeSum��FourSum
	/**
	 * ����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��
	 * ʹ�� a + b + c = 0 ���ҳ��������������Ҳ��ظ�����Ԫ��
	 * ����, �������� nums = [-1, 0, 1, 2, -1, -4]��
	 * ����Ҫ�����Ԫ�鼯��Ϊ��[
	 * 							[-1, 0, 1],
	 * 							[-1, -1, 2]
	 * 						  ]
	 * (0,1,-1)���ظ�
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res=new ArrayList<>();
		if(nums==null || nums.length==0) return res;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++) {
			if(i>0 && nums[i]==nums[i-1]) continue;//ȥ��
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
        	//ȥ��
        	if(i>0 && nums[i]==nums[i-1]) continue;
        	for(int j=i+1;j<nums.length-2;j++) {
        		if(j>i+1 && nums[j]==nums[j-1]) continue;
        			
        		int start=j+1,end=nums.length-1,sum=target-nums[i]-nums[j];
        		while(start<end) {
        			if(nums[start]+nums[end]==sum) {
        				res.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
        				//ȥ��
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
