package 进阶班.class09;

import java.util.HashMap;

/**
 * @author Doromv
 * @create 2022-05-13-16:37
 */
// 测试链接 : https://leetcode.com/problems/copy-list-with-random-pointer/
public class CopyListWithRandom {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList1(Node head) {
        HashMap<Node,Node> map=new HashMap<>();
        Node cur=head;
        while (cur!=null){
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
    public static Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        while(cur!=null){
            next=cur.next;
            cur.next=new Node(cur.val);
            cur.next.next=next;
            cur=next;
        }
        cur=head;
        Node copy=null;
        while (cur!=null){
            next=cur.next.next;
            copy=cur.next;
            copy.random=cur.random==null?null:cur.random.next;
            cur=next;
        }
        Node res=head.next;
        cur=head;
        while (cur!=null){
            next=head.next.next;
            copy=cur.next;
            cur.next=next;
            copy.next=next==null?null:next.next;
            cur=next;
        }
        return res;
    }
}
