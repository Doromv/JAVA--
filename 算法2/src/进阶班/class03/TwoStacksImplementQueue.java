package 进阶班.class03;

import java.util.Stack;

/**
 * @author Doromv
 * @create 2022-04-29-17:11
 */
public class TwoStacksImplementQueue {
    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;
        private void pushToPop() {
            if(stackPop.empty()){
                while (!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int pushInt) {
            stackPush.add(pushInt);
            pushToPop();
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("队列空了");
            }
            pushToPop();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("队列空了");
            }
            pushToPop();
            return stackPop.peek();
        }

    }
}
