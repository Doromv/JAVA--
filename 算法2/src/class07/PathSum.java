package class07;

/**
 * @author Doromv
 * @create 2022-04-18-16:41
 */
//给你二叉树的根节点 root 和一个表示目标和的整数targetSum 。
// 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
// 如果存在，返回 true ；否则，返回 false 。
public class PathSum {
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
    boolean isSum=false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
         if(root==null){
             return false;
         }
         isSum=false;
         f(root,0, targetSum);
         return isSum;
    }
    public void f(TreeNode root,int preSum,int targetSum){
        if(root.left==null&&root.right==null){
            if(root.val+preSum==targetSum){
                isSum=true;
            }
            return;
        }
        preSum+=root.val;
        if(root.left!=null){
            f(root.left,preSum, targetSum);
        }
        if(root.right!=null){
            f(root.right,preSum, targetSum);
        }
    }
}
