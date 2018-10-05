

```
public ListNode mergeKLists(ListNode[] lists) {
	if(lists == null || lists.length == 0){
		return null;
	}

	return mergeSort(lists, 0, lists.length-1);
}

private ListNode mergeSort(ListNode[] lists, int start, int end){
	if(start == end){
		return lists[start];
	} else {
		int mid = start + (end - start) /2;
		ListNode left = mergeSort(lists, start, mid);
		ListNode right = mergeSort(lists, mid + 1, hi);
		return mergeTwoLists(left, right);
	}
}

private ListNode mergeTwoLists(ListNode left, ListNode right){
	ListNode dummy = new ListNode(0);
	ListNode tail = dummy;

	while(left != null && right != null){
		if(left.val <= right.val){
			tail.next = left;
			left = left.next;
		} else {
			tail.next = right;
			right = right.next;
		}
		tail = tail.next;
	}

	if(left != null){
		tail.next = left;
	}

	if(right != null){
		tail.next = right;
	}

	return dummy.next;
}

