

Mistakes:

	1. think about using  insertion to reverse

	2. after insertion, the post node will be placed behind prev, thus post need to be updated


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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        /**
            Input: 1->2->3->4->5->NULL, m = 2, n = 4
            Output: 1->4->3->2->5->NULL
        */
        
        // validation
        
        // m = 1?
        
        ListNode dummy = new ListNode(0);
        
        dummy.next = head;
        
        ListNode prev = dummy;
        
        for(int i = 0; i < m-1; i ++){
            prev = prev.next;
        }
        
        ListNode cur = prev.next;
        
        ListNode post = cur.next;
        
        for(int i = 0; i < n-m; i ++){
            
            ListNode prevNext = prev.next;
            
            ListNode postNext = post.next;
            
            ListNode curNext = cur.next;
            
            prev.next = post;
            
            post.next = prevNext;
            
            cur.next = postNext;
            
            post = cur.next;

        }
        
        
        
        return dummy.next;   
        
    }
}