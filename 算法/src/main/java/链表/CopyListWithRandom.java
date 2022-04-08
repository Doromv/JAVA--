package 链表;

import java.util.HashMap;

/**
 * @author Doromv
 * @create 2022-03-24-8:52
 */
public class CopyListWithRandom {
    public static Node CopyListWithRandom(Node head) {
        HashMap<Node,Node> map=new HashMap();
        Node cur=head;
        while (cur!=null){
            map.put(cur,new Node(cur.value));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).rand=map.get(cur.rand);
            cur=cur.next;
        }
        return map.get(head);
    }
    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node1.rand=node5;
        node2.rand=node3;
        node3.rand=node1;
        node4.rand=node2;
        node5.rand=node4;
        System.out.println(CopyListWithRandom(node1));
    }
}
