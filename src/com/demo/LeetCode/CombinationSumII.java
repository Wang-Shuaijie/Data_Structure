package com.demo.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	/**
	 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
	 * candidates 中的每个数字在每个组合中只能使用一次。
	 * 说明：
	 * 所有数字（包括目标数）都是正整数。
	 * 解集不能包含重复的组合。 
	 * 示例 1:
	 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
	 */
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
		if(candidates==null || candidates.length==0) return res;
		//不能有重复元素，需要去重,先排序
		Arrays.sort(candidates);
		help(res, new ArrayList<Integer>(), candidates, target, 0);
		return res;
    }
	
	public static void help(List<List<Integer>> res,List<Integer> list,int[] candidates,int target,int start) {
		if(target<0) return;
		if(target==0) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=start;i<candidates.length;i++) {
			if(i!=start && candidates[i]==candidates[i-1]) continue;
			list.add(candidates[i]);
			//每个解集只能用一次，所以是i+1
			help(res, list, candidates, target-candidates[i], i+1);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[] candidates=new int[] {10,1,2,7,6,1,5};
		int target=8;
		List<List<Integer>> res=combinationSum2(candidates, target);
		System.out.println(res.toString());
	}
}

