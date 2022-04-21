package 新手班.class06;

/**
 * @author Doromv
 * @create 2022-04-15-15:39
 */
//给定一个二叉树，找出其最大深度。
//二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
public class MaximumDepthOfBinaryTree {
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
    public int maxDepth(TreeNode root) {
          if(root==null){
              return 0;
          }
          return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
