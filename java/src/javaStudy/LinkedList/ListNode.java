package javaStudy.LinkedList;

public class ListNode implements LinkedList{

	public int data;
	public ListNode next;

	public ListNode(){
	}

	public ListNode(int data){
		this.data=data;
		this.next=null;
	}

	@Override
	public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
		ListNode node=head;

		for(int i=0;i<position-1;i++){
			node=node.next;
		}

		nodeToAdd.next=node.next;
		node.next=nodeToAdd;
		return head;

	}

	@Override
	public ListNode remove(ListNode head, int positionToRemove) {
		ListNode node=head;

		if(positionToRemove==0){
			ListNode deleteToNode=node;
			head=node.next;
			deleteToNode.next=null;
			return deleteToNode;
		}
		for(int i=0;i<positionToRemove-1;i++){
			node=node.next;
		}

		ListNode deleteNode=node.next;
		node.next=deleteNode.next;
		deleteNode.next=null;
		return deleteNode;

	}

	@Override
	public boolean contains(ListNode head, ListNode nodeToCheck) {
		ListNode node=head;
		while(node.next!=null){
			if(node.next.data==nodeToCheck.data)
				return true;
			node=node.next;
		}
		return false;
	}
}
