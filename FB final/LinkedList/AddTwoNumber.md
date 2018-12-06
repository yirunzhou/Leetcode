AddTwoNumber.md


Mistakes:

	1. Create LinkedList -> dummy node

	2. Iterate LinkedList -> do not forget to move your pointer

	3. EVERY time you make ".", think twice, will it be null???



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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        
        ListNode cur = dummy;
        
        int carry = 0;
        
        while(l1 != null || l2 != null){
            
            int sum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            
            carry = sum / 10;
            
            cur.next = new ListNode(sum%10);
            
            cur = cur.next;
            
            if(l1 != null){
                l1 = l1.next;
            }
            
            if(l2 != null){
                l2 = l2.next;
            }
            
        }
        
        if(carry != 0){
            cur.next = new ListNode(1);
        }
        
        return dummy.next;
        
    }
}