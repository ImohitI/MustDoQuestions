package prep.mt_fun;

import java.util.*;

public class PC_wait_notify {
    
    public static void main(String[] args) {
        PC pc = new PC();

        Thread producer = new Thread(() -> {
            int value = 0;
            try {
                while (true) {
                    pc.produce(++value);
                    Thread.sleep(300);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    pc.consume();
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer");

        producer.start();
        consumer.start();
    }

    static class PC {
        private final Queue<Integer> queue = new LinkedList<>();
        private final int CAPACITY = 5;   

        public synchronized void produce(int value) throws Exception {
            while (queue.size() == CAPACITY) {
                wait();
            }
            queue.add(value);
            System.out.println("Produced: " + value + " | Queue size: " + queue.size());
            notifyAll();
        }

        public synchronized int consume() throws Exception {
            while (queue.isEmpty()) {
                wait();
            }
            int value = queue.remove();
            System.out.println("Consumed: " + value + " | Queue size: " + queue.size());
            notifyAll();
            return value;
        }
        
    }
}
