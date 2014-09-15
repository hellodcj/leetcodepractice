package leetcode;

import org.junit.Test;

/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * @author dcj
 *
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1.新建一个ListNode保存返回结果
		ListNode p = new ListNode(0);
		ListNode result = p;
		//2.对两个ListNode同时进行遍历，直到next为null
		int jinwei = 0; //进位
		while(l1!=null && l2!=null){
			ListNode node = new ListNode(0);
			int count = l1.val+l2.val+jinwei;
			if (count<10){
				node.val = count;
				jinwei = 0;
			}else{
				node.val = count%10;
				jinwei = 1;
			}
			p.next = node;
			p = node;
			l1=l1.next;
			l2=l2.next;
		}
		//3.遍历过程中，保存进位，如果一个list已经循环完毕，则加0
		//l1的next不为空，则说明l1,还没循环完
		while(l1!=null){
			ListNode node = new ListNode(0);
			int count = l1.val+jinwei;
			if (count<10){
				node.val = count;
				jinwei = 0;
			}else{
				node.val = count%10;
				jinwei = 1;
			}
			p.next = node;
			p = node;
			l1=l1.next;
		}
		//l2的next不为空，则说明l2,还没循环完
		while(l2!=null){
			ListNode node = new ListNode(0);
			int count = l2.val+jinwei;
			if (count<10){
				node.val = count;
				jinwei = 0;
			}else{
				node.val = count%10;
				jinwei = 1;
			}
			p.next = node;
			p = node;
			l2=l2.next;
		}
		
		if (jinwei==1){
			ListNode node = new ListNode(1);
			p.next = node;
		}
		return result.next;
    }
	
	@Test
	public void test(){
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(4);
		a1.next=a2;
		a2.next=a3;
		b1.next=b2;
		b2.next=b3;
		ListNode res = this.addTwoNumbers(a1, b1);
		System.out.println(res.val+"--"+res.next.val+"--"+res.next.next.val);
	}
}

class ListNode {
     int val;
	 ListNode next;
	 ListNode(int x) {
		val = x;
	 	next = null;
	 }
}