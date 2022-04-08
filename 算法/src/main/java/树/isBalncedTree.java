package 树;

/**
 * @author Doromv
 * @create 2022-03-28-8:34
 */
public class isBalncedTree {
    static class returnType{
        boolean isBT;
        int height;

        public returnType() {
        }

        public returnType(boolean isBT, int height) {
            this.isBT = isBT;
            this.height = height;
        }
    }
    public static returnType isBalncedTree(Node head){
        if(head==null){
            return new returnType(true,0);
        }
        returnType leftData = isBalncedTree(head.left);
        returnType rightData = isBalncedTree(head.right);
        int height = Math.max(leftData.height, rightData.height);
        returnType headData = new returnType();
        if(leftData.isBT==true&&rightData.isBT==true&&Math.abs(leftData.height - rightData.height)<2){
            headData.isBT=true;
        }
        headData.height=height+1;
        return headData;
    }

    public static void main(String[] args) {
        Node head=new Node();
        returnType balncedTree = isBalncedTree(head);
        System.out.println(balncedTree.isBT);
    }
}
