package 进阶班.class09;

import java.util.Stack;

/**
 * @author Doromv
 * @create 2022-05-13-15:24
 */
public class IsPalindromeList {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int data) {
            this.val = data;
        }
    }

    public static boolean isPalindrome1(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        ListNode cur=head;
        while (cur!=null){
            stack.add(cur.val);
            cur=cur.next;
        }
        while (head!=null){
            if(head.val !=stack.pop()){
                return false;
            }
            head=head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if(head.next.next==null){
            return head.val ==head.next.val;
        }
        ListNode slow=head.next;
        ListNode fast=head.next.next;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode pre=slow;
        ListNode cur=slow.next;
        slow.next=null;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        ListNode last=pre;
        ListNode cur2=head;
        while (pre!=null&&cur2!=null){
            if(pre.val !=cur2.val){
                return false;
            }
            pre=pre.next;
            cur2=cur2.next;
        }
        ListNode pre2=last;
        last=last.next;
      while (last!=null){
          ListNode next=last.next;
          last.next=pre;
          pre=last;
          last=next;
      }
        return true;
    }
}
