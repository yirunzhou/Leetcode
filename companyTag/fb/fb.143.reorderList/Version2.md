
```
public void reorderList(ListNode head) {
	// find the mid point

	int n = 0;

	ListNode runner = head;

	while(runner != null){
		runner = runner.next;
		n ++;
	}

	ListNode slow = head;

	for(int i = 0; i < n/2-1; i ++){
		slow = slow.next;
	}

	ListNode secondPart = slow.next;

	slow.next = null;

	ListNode tail = reverse(secondPart);

	return merge(head, tail);;
}


private ListNode reverse(ListNdoe head){
	// 1->2->3

	ListNode prev = head;
	ListNode cur = head.next;
	head.next = null;

	while(cur != null){
		ListNode next = cur.next;

		cur.next = prev;

		prev = cur;
		cur = next;
	}

	return prev;
}

private ListNode reverseRec(ListNode head){

	// 1->| 2 3 |4<-5<-6

	// exit
	if(head == null){
		return null;
	}

	if(head.next = null){
		return head;
	}

	//

	head.next.next = head;
	head.next = null;

	ListNode newHead = reverseRec(head.next);
	return newHead;
}


private ListNode merge(ListNode head, ListNode tail){
	ListNode dummy = new ListNode(0);

	ListNode cur = dummy;

	// append head, tail to cur.next;

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



