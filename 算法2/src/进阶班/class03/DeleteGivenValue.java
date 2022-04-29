package 进阶班.class03;

/**
 * @author Doromv
 * @create 2022-04-29-15:03
 */
public class DeleteGivenValue {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    public static Node removeValue(Node head, int num) {
        while (head!=null){
            if(head.value!=num){
                break;
            }
            head=head.next;
        }
        Node cur=head.next;
        Node pre=head;
        while (cur!=null){
            if(cur.value==num){
                pre.next=cur.next;
            }else {
                pre=cur;
            }
            cur=cur.next;
        }
        return head;
    }
}
