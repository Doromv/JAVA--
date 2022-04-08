package 链表;
import java.util.Stack;

/**
 * @author Doromv
 * @create 2022-03-24-8:13
 */
//判断回文数
public class isPalindrome1 {
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack=new Stack<>();
        Node cur= head;
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while (head!=null){
            if(head.value!=stack.pop().value){
                return false;
            }
            head=head.next;
        }
        return true;
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
        System.out.println(isPalindrome1(node1));
    }
}
