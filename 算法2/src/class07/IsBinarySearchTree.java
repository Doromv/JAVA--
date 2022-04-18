package class07;

import jdk.nashorn.internal.ir.IfNode;

/**
 * @author Doromv
 * @create 2022-04-18-17:24
 */
public class IsBinarySearchTree {
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
  class Info{
        boolean isBinary;
        int max;
        int min;

      public Info(boolean isBinary, int max, int min) {
          this.isBinary = isBinary;
          this.max = max;
          this.min = min;
      }
  }
    public boolean isValidBST(TreeNode root) {
        return f(root).isBinary;
    }
    public Info f(TreeNode root){
        if(root==null){
            return null;
        }
        Info infoL=f(root.left);
        Info infoR=f(root.right);
        int max= root.val;
        int min= root.val;
        if(infoL!=null){
            max = Math.max(infoL.max, max);
            min = Math.min(infoL.min, min);
        }
        if(infoR!=null){
            max = Math.max(infoR.max, max);
            min = Math.min(infoR.min, min);
        }
        boolean isBinary=false;
        boolean leftIsBinary=infoL==null?true:infoL.isBinary;
        boolean rightIsBinary=infoR==null?true:infoR.isBinary;
        boolean lmaxlessrootval=infoL==null?true:(infoL.max<root.val);
        boolean rminmorerootval=infoR==null?true:(infoR.min>root.val);
        if(leftIsBinary && rightIsBinary && lmaxlessrootval && rminmorerootval){
            isBinary=true;
        }
        return new Info(isBinary,max,min);
    }
}
