package javaStudy.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListNodeTest {
	private ListNode listNode;
	private static final int[] ADD_DATA={1,3,4,5,7,9};
	private static final boolean[] CONTAINS_DATA={true,false};
	private static List<Integer> acc_data;

	@BeforeEach
	void setUp(){
		acc_data=new ArrayList<>();
		listNode=new ListNode();
		ListNode firstNode=new ListNode(1);
		ListNode secondNode=new ListNode(3);
		ListNode thirdNode=new ListNode(5);
		ListNode fouthNode=new ListNode(7);
		ListNode fifthNode=new ListNode(9);

		this.listNode=firstNode;
		firstNode.next=secondNode;
		secondNode.next=thirdNode;
		thirdNode.next=fouthNode;
		fouthNode.next=fifthNode;
	}

	@Test
	void add(){
		listNode=listNode.add(listNode,new ListNode(4),2);

		while(listNode!=null){
			acc_data.add(listNode.data);
			listNode=listNode.next;
		}

		for(int i=0;i<acc_data.size();i++){
			assertEquals(ADD_DATA[i],acc_data.get(i));
		}
	}

	@Test
	void remove(){
		ListNode removed=listNode.remove(listNode,2);
		assertEquals(5,removed.data);
	}

	@Test
	void contains(){
		boolean[] result=new boolean[2];
		result[0]=listNode.contains(listNode,new ListNode(3));
		result[1]=listNode.contains(listNode,new ListNode(10));

		assertArrayEquals(CONTAINS_DATA,result);
	}

}