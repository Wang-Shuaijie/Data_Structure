package com.demo.leetcode;

public class RemoveDuplicatesfromSortedArray {
	/**
	 * ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
	 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
	 * ʾ�� 1:
	 * �������� nums = [1,1,2], 
	 * ����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2�� 
	 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ��
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
	
	
	//һ����������ɾ���ظ�Ԫ��
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
