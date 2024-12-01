package edu.javastuff.concurrency;

import java.util.concurrent.Semaphore;

public class javacon {
    public static void main(String[] args) {
        /*
         * Thread safety and synchronized
         * a class is thread safe 
         * if multiple threads can cosume the exposed API without causing race conditions or state corruption for the class
         * The composition of two or more thread safe classes doesn't guarantee the resulting type to be thread safe
         * 
         * Synchronized
         * restrict access to critical sections one thread at a time
         * Each java object has monitor lock , exclusive lock
         * Once a thread gets hold of lock on the object, it has exclusive access to all the methods marked as synchronized
         * No other thread allowed and will block till first thread releases the monitor which is equivalent to first thread 
         * exiting the synchronized method
         * -- for static method, monitor will on class object, which is distinct from monitor on object instance
         * -- an uncaught exception in synchronized method, monitor is still released
         * -- synchronized block can be re-entered
         * 
         * wait
         * in each java object, When thread executes wait method it releases the monitor for the object
         * and is placed in the wait queue, thread must be on the synchroized block of the object to do this
         * Thread must hold the monitor of the object on which it will call wait, otherwise IllegalMonitor exception
         * 
         * notify
         * same way to be used as wait, 
         * Thread calling notify will awaken one of the threads in wait queue
         * Thread which calls notify will also need to give up object's monitor
         * before any one of the competing thread will acquire the monitor
         * 
         * notifyAll
         * it wakes up all thread in waiting on object's monitor
         * 
         * Interrupted Exception
         * when a thread waiting or sleeping, one way to give up waiting or sleeping is to be interrupted
         * If interrupted will wake up and throw Interrupted exception
         * Thread class exposes interrupt() method which will be used to interrupt the thread blocked in wait or sleep
         * 
         * volatile
         * read and write always happens in main memory,
         * Also all variable that are visible to writing thread also gets write down in main memory alongside volatile variable
         * Also all variable visible to reading thread also have latest value visible to thre reading thread
         */

         try {
           // IncorrectSemaphoreExample.example();
            CorrectSemaphoreExample.example();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}


class IncorrectSemaphoreExample {

    public static void example() throws InterruptedException {

        final Semaphore semaphore = new Semaphore(1);

        Thread badThread = new Thread(new Runnable() {

            public void run() {

                while (true) {

                    try {
                        semaphore.acquire();
                    } catch (InterruptedException ie) {
                        // handle thread interruption
                    }

                    // Thread was meant to run forever but runs into an
                    // exception that causes the thread to crash.
                    throw new RuntimeException("exception happens at runtime.");

                    // The following line to signal the semaphore is never reached
                    // semaphore.release();
                }
            }
        });

        badThread.start();

        // Wait for the bad thread to go belly-up
        Thread.sleep(1000);

        final Thread goodThread = new Thread(new Runnable() {

            public void run() {
                System.out.println("Good thread patiently waiting to be signalled.");
                try {
                    semaphore.acquire();
                } catch (InterruptedException ie) {
                    // handle thread interruption
                }
            }
        });

        goodThread.start();
        badThread.join();
        goodThread.join();
        System.out.println("Exiting Program");
    }
}


class CorrectSemaphoreExample {

    public static void example() throws InterruptedException {

        final Semaphore semaphore = new Semaphore(1);

        Thread badThread = new Thread(new Runnable() {

            public void run() {

                while (true) {

                    try {
                        semaphore.acquire();
                        try {
                            throw new RuntimeException("");
                        } catch (Exception e) {
                            // handle any program logic exception and exit the function
                            return;
                        } finally {
                            System.out.println("Bad thread releasing semahore.");
                            semaphore.release();
                        }

                    } catch (InterruptedException ie) {
                        // handle thread interruption
                    }
                }
            }
        });

        badThread.start();

        // Wait for the bad thread to go belly-up
        Thread.sleep(1000);

        final Thread goodThread = new Thread(new Runnable() {

            public void run() {
                System.out.println("Good thread patiently waiting to be signalled.");
                try {
                    semaphore.acquire();
                } catch (InterruptedException ie) {
                    // handle thread interruption
                }
            }
        });

        goodThread.start();
        badThread.join();
        goodThread.join();
        System.out.println("Exiting Program");
    }
}


