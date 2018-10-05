```
public void reorderList(ListNode head) {
        
        // corner cases
        if(head == null || head.next == null){
        	return;
        }

        // n = len
        ListNode runner = head;
        int n = 0;
        while(runner != null){
            runner = runner.next;
            n ++;
        }

        // cut the list
        ListNode slow = head;
        for(int i = 0; i < n/2-1; i ++){
            slow = slow.next;
        }
        
        ListNode secondPart = slow.next;
        slow.next = null;
        
        ListNode tail = reverse(secondPart);
        ListNode front = head;
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while(front != null){
        	ListNode frontNext = front.next;
        	ListNode tailNext = tail.next;

        	cur.next = front;
        	cur = cur.next;
        	cur.next = tail;
        	cur = cur.next;

        	front = frontNext;
        	tail = tailNext;
        }
   }

   private ListNode reverse(ListNode head){
   		ListNode prev = null;
   		ListNode mid = head;
   		while(mid != null){
   			ListNode next = mid.next;
   			mid.next = prev;

   			prev = mid;
   			mid = next;
   		}
   		return prev;
   }


   private ListNode reverseRecursively(ListNode prevHead, ListNode newHead){
   		if(newHead == null){
   			return prevHead;
   		}

   		ListNode next = newHead.next;
   		newHead.next = prevHead;

   		prevHead = newHead;
   		newHead = next;

   		return reverseRecursively(prevHead, newHead);

   }


   // reverse the list of [head to tail], return tail as new head
   private ListNode reverseRecursivelyV2(ListNode head){
   		if(head == null || head.next == null){
   			return head;
   		}

   		ListNode newHead = reverseRecursivelyV2(head.next);
   		
   		//1. let the reversed list's tail link to current one
   		head.next.next = head;

   		//2. let current's next one point to null
   		head.next = null;
   		return newHead;
   }