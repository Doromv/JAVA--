package 树;

import java.util.LinkedList;

/**
 * @author Doromv
 * @create 2022-03-28-8:18
 */
//判断是否是完全二叉树
public class isCBT {
    public static boolean isBCT(Node head){
        if(head==null){
            return true;
        }
        LinkedList<Node> queue=new LinkedList<>();
        boolean leaf=false;
        Node l=null;
        Node r=null;
        queue.add(head);
        while (!queue.isEmpty()){
            head=queue.poll();
            l=head.left;
            r=head.right;
            if((leaf&&(l!=null||r!=null))||(l==null&&r!=null)){
                return false;
            }
            if(l!=null){
                queue.add(l);
            }
            if(r!=null){
                queue.add(r);
            }
            if(l==null||r==null){
                leaf=true;
            }
        }
        return true;
    }

}
