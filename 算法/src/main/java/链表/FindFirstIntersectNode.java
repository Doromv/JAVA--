package 链表;

import com.sun.xml.internal.bind.v2.runtime.NameBuilder;
import 链表.Node;

/**
 * @author Doromv
 * @create 2022-03-26-8:35
 */
public class FindFirstIntersectNode {
    public static Node getIntersectNode(Node head1,Node head2){
        if(head1==null||head1==null){
            return null;
        }
        Node loop1=getLoopNode(head1);
        Node loop2=getLoopNode(head2);
        if(loop1==null&&loop2==null){
            return noLoop(head1,head2);
        }
        if(loop1!=null&&loop2!=null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }
    //找到链表的第一个入环节点，如果无环，则返回null
    public static Node getLoopNode(Node head){
        if(head.next==null||head.next.next==null){
            return null;
        }
        Node nf=head.next.next;
        Node ns=head.next;
        while (nf!=ns){
            if(nf.next==null||nf.next.next==null){
                return null;
            }
            ns=ns.next;
            nf=nf.next.next;
        }
        nf=head;
        while (nf!=ns){
            ns=ns.next;
            nf=nf.next;
        }
        return nf;
    }
    //如果两个链表都无环，返回第一个相交的节点，如果不相交，返回null
    public static Node noLoop(Node head1,Node head2){
        if(head1==null||head2==null){
            return null;
        }
        Node cur1=head1;
        Node cur2=head2;
        int n=0;
        while (cur1.next!=null){
            n++;
            cur1=cur1.next;
        }
        while (cur2.next!=null){
            n--;
            cur2=cur2.next;
        }
        if(cur1!=cur2){
            return null;
        }
        cur1= n>0? head1:head2;
        cur2=cur1==head1? head2:head1;
        n=Math.abs(n);
        while (n!=0){
            n--;
            cur1=cur1.next;
        }
        while (cur1!=cur2){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }
    //两个有环的环链表，返回第一个相交的节点，如果不相交返回null
    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1=null;
        Node cur2=null;
        if(loop1==loop2){
            cur1=head1;
            cur2=head2;
            int n=0;
            while (cur1!=loop1){
                n++;
                cur1=cur1.next;
            }
            while (cur2!=loop1){
                n--;
                cur2=cur2.next;
            }
            cur1=n>0? head1:head2;
            cur2=cur1==head1? head2:head1;
            n=Math.abs(n);
            while (n!=0){
                n--;
                cur1=cur1.next;
            }
            while (cur1!=cur2){
                cur1=cur1.next;
                cur2=cur2.next;
            }
            return cur1;
        }else{
            cur1=loop1.next;
            while (cur1!=loop1){
                if(cur1==loop2){
                    return loop1;
                }
                cur1=cur1.next;
            }
        }
        return null;
    }
}
