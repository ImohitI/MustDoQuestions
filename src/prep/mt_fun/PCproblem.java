package prep.mt_fun;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class PCproblem {
    
    public static void main(String[] args) {
        System.out.println("Hello, PC Problem!");

        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(5);

        Thread producer = new Thread(new Producer(q), "Producer");
        Thread consumer = new Thread(new Consumer(q), "Consumer");

        producer.start();
        consumer.start();

    }
    static class Producer implements Runnable {
        private final BlockingQueue<Integer> q;
        private int counter = 0;

        public Producer(BlockingQueue<Integer> q) {
            this.q = q;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    int item = ++counter;
                    q.put(item); // blocks when queue is full
                    System.out.println(Thread.currentThread().getName() + " produced: " + item + " (size=" + q.size() + ")");
                    TimeUnit.MILLISECONDS.sleep(300);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    static class Consumer implements Runnable {
        private final BlockingQueue<Integer> q;

        Consumer(BlockingQueue<Integer> q) { this.q = q; }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Integer item = q.take(); // blocks when queue is empty
                    System.out.println(Thread.currentThread().getName() + " consumed: " + item + " (size=" + q.size() + ")");
                    TimeUnit.MILLISECONDS.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}



