Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.



```

public void reorderList(ListNode head) {

	int n = 0;

	ListNode cur = head;

	while(cur != null){
		cur = cur.next;
		n ++;
	}

	cur = head;

	// 1->2 | 3<-4<-5
	for(int i = 0; i < n/2 -1; i ++){
		cur = cur.next;
	}

	ListNode secondPart = cur.next;

	cur.next = null;

	ListNode tail = reverse(secondPart);

	// 1->2 | 3<-4<-5

	// D->1->5->2->4->3
	ListNode dummy = new ListNode(0);
	cur = dummy;

	while(head != null && tail != null){
		cur.next = head;
		head = head.next;
		cur = cur.next;

		cur.next = tail;
		tail = tail.next;
		cur = cur.next;
	}

	return dummy.next;
}

private ListNode reverse(ListNode head){
	if(head == null{
		return null;
	}

	// 1->2->3
	ListNode prev = head;
	ListNode cur = head.next;

	head.next = null;

	// change cur.next to prev
	while(cur != null){
		// 1<-2?3->

		ListNode next = cur.next;

		cur.next = prev;

		prev = cur;

		cur = next;

	}

	// 1<-2<-3

	return prev;

}

private ListNode reverseRec(ListNode head){
	// base
		// empty list
	if(head == null){
		return null;
	}

		// reached the end
		// return as newHead
		
	if(head.next == null){
		return head;
	}


	ListNode newHead = reverseRec(head.next);
	// 1->|  2<-3

	head.next.next = head;

	head.next = null;

	// <-1<-2<-3

	return newHead;
}