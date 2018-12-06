RemoveFromEnd.md


Mistakes:


	IMPORTANT!  1. Deleting in LinkedList -> what if delete **HEAD**?

	IMPORTATN!  2. Return value of function

	3. ith node from end -> move fast by i-1 step

	4. Delete node should use PREV pointer

	5. Or we just use a prev pointer, no need for slow



Solution:


```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = dummy;
        
        
        for(int i = 0; i < n-1; i ++){
            fast = fast.next;
        }
        
        while(fast.next != null){
            
            fast = fast.next;
            prev = slow;
            slow = slow.next;
            
        }
        
        
        prev.next = prev.next.next;
        
        return dummy.next;
        
    }
}