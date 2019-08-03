package com.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	/**
	 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
	 * candidates 中的数字可以无限制重复被选取。
	 * 说明：所有数字（包括 target）都是正整数。解集不能包含重复的组合。 
	 * 示例 1:
	 * 输入: candidates = [2,3,6,7], target = 7,
	 * 所求解集为:
[
  [7],
  [2,2,3]
]

	 */
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        /**
         *像这种结果要求返回所有符合要求解的题十有八九都是要利用到递归，
         *而且解题的思路都大同小异类似的题目有 Path Sum II，Subsets II，
         *Permutations，Permutations II，Combinations 等等，
         *如果仔细研究这些题目发现都是一个套路，都是需要另写一个递归函数，
         *这里我们新加入三个变量，start记录当前的递归到的下标，
         *list为一个解，res保存所有已经得到的解，每次调用新的递归函数时，
         *此时的target要减去当前数组的的数，具体看代码如下：
         */
		List<List<Integer>> res=new ArrayList<>();
		if(candidates==null || candidates.length==0) return res;
		helper(res,new ArrayList<>(),candidates,target,0);
		return res;
    }

	public static void helper(List<List<Integer>> res,List<Integer> list,int[] candidates,int target,int start) {
		if(target<0) return;
		if(target==0) {
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=start;i<candidates.length;i++) {
			list.add(candidates[i]);
			helper(res,list,candidates,target-candidates[i],i);
			list.remove(list.size()-1);
		}
	}
	
	
	public static void main(String[] args) {
		int[] candidates=new int[] {2,3,6,7};
		int target=7;
		List<List<Integer>> res=combinationSum(candidates, target);
		System.out.println(res.toString());
	}
}
