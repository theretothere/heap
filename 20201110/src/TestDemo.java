import java.util.PriorityQueue;

/**
 * @Version 1.0
 * @Author: Hu
 * @DATE: 2020/11/10 15:31
 * Content:
 */
public class TestDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(13);
        priorityQueue.offer(3);
        priorityQueue.offer(8);
        priorityQueue.offer(49);

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());
    }
}
