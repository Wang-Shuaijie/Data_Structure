package com.demo.base.LinkedList;
/**
 * 单向链表
 * @author WangShuaiJie
 *
 */
public class ListNode {
	//节点内容
	int data;
	//下一节点
	ListNode next;
	
	public ListNode(int data) {
		this.data=data;
	}
	
	//为节点追加节点
	public ListNode append(ListNode node) {
		//this.next=node;只能追加一次
		ListNode currentNode=this;
		//循环找下一节点
		while(true) {
			//取出当前节点的下一个节点
			ListNode nextNode=currentNode.next;
			if(nextNode==null) {
				break;
			}
			//赋给当前节点
			currentNode=nextNode;
		}
		//把需要追加的节点追加为找到的当前节点的下一个节点
		currentNode.next=node;
		return this;
	}
	
	//删除当前节点的下一个节点
	public void removeNode() {
		//取出下下个节点
		ListNode nextNode=this.next.next;
		//把下下个节点设置为当前节点的下一个节点
		this.next=nextNode;
	}
	
	//插入节点作为当前节点的下一个节点
	public void insertNode(ListNode node) {
		//取出当前节点的下一个节点，作为下下节点
		ListNode nextNode = this.next;
		//把新节点作为当前节点的下一个节点
		this.next=node;
		node.next=nextNode;
	}
	
	//获取下一个节点
	public ListNode next() {
		return this.next;
	}
	
	//获取节点数据
	public int getData() {
		return this.data;
	}
	
	//当前节点是否为最后一个节点
	public boolean isLast() {
		return this.next==null;
	}
	
	//显示所有节点信息
	public void show() {
		ListNode currentNode=this;
		while(true) {
			if(currentNode==null) {
				break;
			}
			System.out.print(currentNode.data+"-");
			currentNode=currentNode.next;
		}
	}
}
