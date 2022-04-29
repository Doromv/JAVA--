package 进阶班.class03;

import java.util.Stack;

/**
 * @author Doromv
 * @create 2022-04-29-16:38
 */
public class GetMinStack {
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;
        public MyStack1() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum) {
            if(stackMin.isEmpty()){
                stackMin.push(newNum);
            }else if(newNum<=this.getmin()){
                stackMin.push(newNum);
            }
            stackData.push(newNum);
        }

        public int pop() {
            if(stackData.isEmpty()){
                throw new RuntimeException("栈空了");
            }
            Integer value = stackData.pop();
            if(value==this.getmin()){
                stackMin.pop();
            }
            return value;
        }

        public int getmin() {
            if(stackMin.isEmpty()){
                throw new RuntimeException("栈空了");
            }
            return stackMin.peek();
        }
    }
    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum) {
            if(stackMin.isEmpty()){
                stackMin.push(newNum);
            }else if(newNum<this.getmin()){
                stackMin.push(newNum);
            }else {
                int temp=stackMin.peek();
                stackMin.push(temp);
            }
            stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("栈空了");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }
}
