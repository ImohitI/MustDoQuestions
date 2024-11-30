package edu.javastuff.java8newedu;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class conInro {
    public static void main(String[] args) {
        /*
         * CompletableFuture
         * for asynchronous computation
         * executed in a non-blocking call in a separate thread, result made available when ready
         * main thread does not block or wait for completion, and can execute other task in parallel
         * 
         * It implements completionStage and Future
         * CompletionStage is a promise, it promises that computation will eventually be done
         * 
         * CompletableFuure has methods to compose, combine, execute asynchronous computation steps
         * 
         * Future limitations
         * isDone check if done, get get result, cancel cancel computation error handling
         * 
         * --cannot perform action on Future's result without blocking
         * --get blocks until computation is complete
         * --future chaining not possible 
         * --future combining not possible
         * --no exception handling
         * 
         * 
         * completedFuture, when sure of the result
         */

         CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Hello World");
         try {
            System.out.println(completableFuture.get());
         } catch (Exception e) {
            e.printStackTrace();
         }

         /*
          * Asynchronous computatation, and do not expect result
          * runAsync static method runs some background computation asynchronously and return CompletableFuture<Void>
          * It takes runnable as parameter
          * It can also take an executor to provid threadpool
          */

          CompletableFuture<Void> future = CompletableFuture.runAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                throw new IllegalStateException();
            }
            System.out.println("Doing something " + Thread.currentThread().getName());
          });

          System.out.println("this will print immediately " + Thread.currentThread().getName());

          try {
            future.get();
          } catch(Exception e) {
            e.printStackTrace();
          }

          System.out.println("this will print after 5 seconds " + Thread.currentThread().getName());


          //supplyAsync
          // we get the result of computation
          CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch(Exception e) {
                e.printStackTrace();
            }
            return "Hello supplyasync";
          });

          System.out.println("print immediate");

          try {
            future2.get();
          } catch(Exception e) {
            e.printStackTrace();
          }
          System.out.println("after 5");


          /*
           * attach a callback, which runs after the future completes
           * thenApply - accepts a function, process the result and return future that holds a value returned by function
           * thenApplyAsync - 
           * thenAccept
           * thenRun
           * 
           */

           CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch(Exception e) {
                e.printStackTrace();
            }
            return 31;
           });

           CompletableFuture<Integer> resFuture3 = future3.thenApply(e -> {
            System.out.println(Thread.currentThread().getName());
            return e * 2;
           });

           try {
            System.out.println(resFuture3.get());
           } catch(Exception e) {
            e.printStackTrace();
           }
           //all the operations should be executed by a different thread. We can achieve this by using
           //thenApplyAsync
           //then accept , callback does not return anything
           
           /**
            * thenCompose , thenCombine
            * chain computation 
            * want some data from a service and save it to database
            * write 2 CompletableFuture instances in a chain of computation steps and chain them
            * first complete and share its result to second instance
            */
                    // Create a future which returns an integer.
        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 50;
        });

        // Calling thenCompose() which takes a Function as parameter. 
        // It takes a number as input and returns a CompletableFuture of double of number.
        CompletableFuture<Integer> resultFuture4 = future4.thenCompose(num -> 
        CompletableFuture.supplyAsync(() -> num * 2));

        try {
            System.out.println(resultFuture4.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // thenCombine, two independent futures and do something with their results, we use thenCombine

            // Create a future which returns an integer.
            CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 50;
        });
    
            // Calling thenCompose() which takes a Function as parameter. 
            // It takes a number as input and returns a CompletableFuture of double of number.
            CompletableFuture<Integer> resultFuture5 = future5.thenCombine(
                    CompletableFuture.supplyAsync(() -> 20) , (num1, num2) -> num1 + num2);
    
            try {
                System.out.println(resultFuture5.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            /*
             * allOf 
             * join
             * anyOf
             * run multiple future in parallel, and combine their result we use allOf, anyOf
             *  
             * 
             */
            CompletableFuture<Integer> future11 = CompletableFuture.supplyAsync(() -> 50);
            CompletableFuture<Integer> future22 = CompletableFuture.supplyAsync(() -> 40);
            CompletableFuture<Integer> future33 = CompletableFuture.supplyAsync(() -> 30);
    
            CompletableFuture<Void> finalFuture = CompletableFuture.allOf(future11, future22, future33);
    
            try {
                finalFuture.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
    
            System.out.println("Code that should be executed after all the futures complete.");
        

    }
}
