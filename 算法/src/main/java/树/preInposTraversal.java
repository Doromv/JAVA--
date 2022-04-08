package 树;

import java.util.Stack;

/**
 * @author Doromv
 * @create 2022-03-26-9:14
 */
public class preInposTraversal {
    public static void preOrderUnrecur(Node head){
        System.out.print("pre-order:");
        if(head!=null){
            Stack<Node> stack=new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head=stack.pop();
                System.out.print(head.value+" ");
                if(head.right!=null){
                    stack.push(head.right);
                }
                if(head.left!=null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }
    public static void inOrderUnrecur(Node head){
        System.out.print("in-order:");
        if(head!=null){
            Stack<Node> stack=new Stack<>();
            while (!stack.isEmpty()||head!=null){
                if(head!=null){
                    stack.push(head);
                    head=head.left;
                }else{
                    head=stack.pop();
                    System.out.print(head.value+" ");
                    head=head.right;
                }
            }
        }
        System.out.println();
    }
    public static void posOrderUnrecur(Node head){
        System.out.print("pos-order:");
        if(head!=null){
            Stack<Node> stack1=new Stack<>();
            Stack<Node> stack2=new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()){
                head=stack1.pop();
                stack2.push(head);
                if(head.left!=null){
                    stack1.push(head.left);
                }
                if(head.right!=null){
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()){
                System.out.print(stack2.pop().value+" ");
            }
        }
        System.out.println();
    }
}
