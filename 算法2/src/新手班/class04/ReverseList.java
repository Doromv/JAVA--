package 新手班.class04;

/**
 * @author Doromv
 * @create 2022-04-11-15:58
 */
public class ReverseList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }
    public static Node reverseLinkedList(Node head) {
        Node pre=null;
        Node next=null;
        while (head.next!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre=null;
        DoubleNode next=null;
        while (head.next!=null){
            next=head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;
        }
        return pre;
    }
}
