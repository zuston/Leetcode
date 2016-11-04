package leetcode;

/**
 * Created by zuston on 16-11-2.
 */


/**
 * 147题
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x ){
            val = x;

        }
    }

    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode old = head;
        ListNode newHead = new ListNode(0);
        newHead.next = null;
        while (old!=null){
            int value = old.val;
            old = old.next;
            ListNode node = new ListNode(value);
            ListNode nh = newHead;

            while (nh.next!=null&&nh.next.val<value){
                nh = nh.next;
            }
            node.next = nh.next;
            nh.next = node;
        }
        return newHead.next;
    }
}
