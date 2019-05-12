package com.demo.leetcode;

public class RemoveDuplicatesfromSortedArray {
	/**
	 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
	 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
	 * 示例 1:
	 * 给定数组 nums = [1,1,2], 
	 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
	 * 你不需要考虑数组中超出新长度后面的元素
	 */
	public static int removeDuplicates(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int res=1;
		for(int i=1;i<nums.length;i++) {
			if(nums[i-1]!=nums[i]) {
				nums[res]=nums[i];
				res++;		
			}
		}
		return res;
	}
	
	
	//一个排序链表，删除重复元素
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode cur=head;
		while(cur.next!=null) {
			if(cur.next.val==cur.val) {
				cur.next=cur.next.next;
			}else {
				cur=cur.next;
			}
		}
		return head;		
	}
}
