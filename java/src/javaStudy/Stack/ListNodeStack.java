package javaStudy.Stack;

import javaStudy.LinkedList.ListNode;

public class ListNodeStack implements Stack{

	int top;
	ListNode listNode;

	public ListNodeStack(){
		top=-1;
		listNode=null;
	}

	@Override
	public void push(int data) {
		ListNode nextNode=new ListNode(data);
		if(listNode==null){
			listNode=new ListNode(data);
			top++;
		}else{
			listNode=listNode.add(listNode,nextNode,++top);
		}
	}

	@Override
	public int pop() {
		if(top==-1){
			return top;
		}
		return listNode.remove(listNode,top--).data;
	}
}
