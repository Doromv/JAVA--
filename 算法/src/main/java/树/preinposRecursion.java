package 树;

/**
 * @author Doromv
 * @create 2022-03-26-9:25
 */
public class preinposRecursion {
    public static void preRecursion(Node head){
        System.out.println("pre-order:");
        if(head==null){
            return;
        }
        System.out.println(head.value+" ");
        preRecursion(head.left);
        preRecursion(head.right);
    }
    public static void inRecursion(Node head){
        if(head==null){
            return;
        }
        inRecursion(head.left);
        System.out.println(head.value+" ");
        inRecursion(head.right);
    }
    public static void posRecursion(Node head){
        if(head==null){
            return;
        }
        posRecursion(head.left);
        posRecursion(head.right);
        System.out.println(head.value+" ");
    }
}
