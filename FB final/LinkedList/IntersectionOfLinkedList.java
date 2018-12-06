

Mistakes:
	
	0. This algo could deal with null head

	1. Consider the inital value as a solution if I use while(true)



```
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode curA = headA;
        ListNode curB = headB;
        
        while(curA != curB){
            
            curA = curA == null ? headB : curA.next;
            
            curB = curB == null ? headA : curB.next;
            
        }
        
        return curA;
        
    }
}