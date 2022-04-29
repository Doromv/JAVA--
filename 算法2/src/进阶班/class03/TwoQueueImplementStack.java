package 进阶班.class03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Doromv
 * @create 2022-04-29-17:19
 */
public class TwoQueueImplementStack {
    public static class TwoQueueStack<T> {
        public Queue<T> queue;
        public Queue<T> help;
        public TwoQueueStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(T value) {
            queue.offer(value);
        }

        public T poll() {
            if(queue.size()>1){
                help.offer(queue.poll());
            }
            T ans=queue.poll();
            Queue<T> temp=queue;
            queue = help;
            help = temp;
            return ans;
        }
        public T peek() {
            if(queue.size()>1){
                help.offer(queue.poll());
            }
            T ans=queue.poll();
            help.offer(ans);
            Queue<T> temp=queue;
            queue = help;
            help = temp;
            return ans;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
