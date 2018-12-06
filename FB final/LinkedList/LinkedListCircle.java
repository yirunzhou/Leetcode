


	Mistakes:

		This time we cannot use while(slow != fast), as the initial state is slow == fast

		The critical point of this is that if some node's next is null, then it has no circle:

			if(fast.next or fast.next.next is null) return false

		Another is that we need to terminate loop when it has circle:

			slow == fast, return true;


```

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(slow == fast){
                return true;
            }
        }
        
        return false;
    }
}