package 新手班.class06;

/**
 * @author Doromv
 * @create 2022-04-15-15:18
 */
//镜像对称树
public class SymmetricTree {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left,root.right);
    }
    public static boolean isMirror(TreeNode h1, TreeNode h2) {
        if(h1==null^h2==null){
            return false;
        }
        if(h1==null&&h2==null){
            return true;
        }
        return h1.val==h2.val&&isMirror(h1.left,h2.right)&&isMirror(h1.right,h2.left);
    }
}
