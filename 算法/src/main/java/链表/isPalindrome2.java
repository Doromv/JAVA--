package 链表;

/**
 * @author Doromv
 * @create 2022-03-24-8:23
 */
//回文数
public class isPalindrome2 {
    public static boolean isPalindrome2(Node head){
        if(head==null||head.next==null){
            return true;
        }
        Node nm=head;
        Node nk=head;
        while (nk.next!=null&&nk.next.next!=null){
            nm=nm.next;
            nk=nk.next.next;
        }
        nk=nm.next;
        nm.next=null;
        Node temp=null;
        while (nk!=null){
            temp=nk.next;
            nk.next=nm;
            nm=nk;
            nk=temp;
        }
        temp=nm;
        nk=head;
        boolean flag=true;
        while (nk!=null&&nm!=null){
            if(nk.value!=nm.value){
                flag=false;
                break;
            }
            nk=nk.next;
            nm=nm.next;
        }
        nm=temp.next;
        temp=null;
        nk=nm.next;
        while (nm!=null){
            nk=nm.next;
            nm.next=temp;
            temp=nm;
            nm=nk;
        }
        return flag;
    }
    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(2);
        Node node5=new Node(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println(isPalindrome2(node1));
    }
}
