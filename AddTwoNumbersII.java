package leetcode;

/**
 * Created by zuston on 16-11-2.
 */

import java.util.HashMap;

/**
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x ){
            val = x;

        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        HashMap<Integer,Integer> a = new HashMap<>();
        HashMap<Integer,Integer> b = new HashMap<>();
        int i = 1;
        int j = 1;
        ListNode a1 = l1;
        ListNode a2 = l2;
        while (a1!=null){
            a.put(i,a1.val);
            i++;
            a1 = a1.next;
        }
        while (a2!=null){
            b.put(j,a2.val);
            j++;
            a2 = a2.next;
        }
        i = i-1;
        j = j-1;
        ListNode head = new ListNode(0);
        head.next = null;
        int front = 0;
        while (i>0||j>0){
            int p1 = 0;
            int p2 =0;
            if(i>0){
                p1 = a.get(i);
                i--;
            }
            if(j>0){
                p2 = b.get(j);
                j--;
            }
            int sum = p1+p2+front;
            front = sum/10;
            System.out.println(front);
            sum = sum%10;
            System.out.println(sum);
            ListNode lc = new ListNode(sum);
            lc.next = head.next;
            head.next = lc;
        }
        if(front!=0){
            ListNode lc = new ListNode(front);
            lc.next = head.next;
            head.next = lc;
        }
        return head.next;
    }
}
