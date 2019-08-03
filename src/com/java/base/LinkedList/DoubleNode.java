package com.java.base.LinkedList;
/**
 * 双向循环链表
 * @author WangShuaiJie
 *
 */
public class DoubleNode {
	//上一个节点
	DoubleNode pre=this;
	//下一个节点
	DoubleNode next=this;
	//节点数据
	int data;
	
	public DoubleNode(int data) {
		this.data=data;
	}
	
	//添加节点
	public void after(DoubleNode node) {
		//原来的下一个节点
		DoubleNode nextNode = this.next;
		//把新节点作为当前节点的下一个节点
		this.next=node;
		//当前节点为新节点的上一个节点
		node.pre=this;
		//新节点的下一个节点为原节点的下一节点
		node.next=nextNode;
		//原节点的下一节点的上一节点为新节点
		nextNode.pre=node;
	}
	
	//上一节点
	public DoubleNode pre() {
		return this.pre;
	}
	
	//下一节点
	public DoubleNode next() {
		return this.next;
	}
	
	//获取数据
	public int getData() {
		return this.data;
	}
}
