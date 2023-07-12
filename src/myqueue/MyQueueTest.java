package myqueue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<Double> queue = new MyQueue<>();
        queue.add(1.5d);
        queue.add(44.d);
        queue.add(0.1d);
        queue.add(15.78d);
        System.out.println("queue = " + queue);

        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue = " + queue);

        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue = " + queue);

        System.out.println("queue.size() = " + queue.size());

        queue.clear();
        System.out.println("queue = " + queue);
    }
}
