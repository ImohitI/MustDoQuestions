# Thread
lightweight unit of execution running inside jvm
one jvm process -> many threads -> shared memory
a thread is like a worker, all workers access the same shared tools.

# Thread cycle
6 states 
new, runnable, blocked (waiting for lock), waiting (wait(), join()), timed waiting(sleep, wait(timeout)), terminated

# Race condition
2 threads read/write the same variable at the same time and the output depends on timing 
When multiple threads modify shared data at the same time and output depends on timing.

# synchronized 
synchronized method -- if instance method --> locks on this
-- if static method --> locks on ClassName.class 
synchronized block -- locks on lockObj -----> synchronized(lockObj) {....}

# Lock
lock = synchronized + advanced features 

# wait and notify 
wait --> thread releases lock and waits
notify --> wakes one waiting thread 
Must be inside synchronized block 
wait() gives up lock, sleep does not 

# ExecutorService 
ExecutorService = Executor.newFixedThreadPool(10)
pool of threads 
reuse threads, prevent overload, manage queue/backpressure

# Thread pools and executors internal
- why thread pool 
    - reuse threads
    - control concurrency
    - prevent cpu overload 
    - provide queues for backpressure 
    - allow monitoring and tuning
# threadpool types 
- newFixedThreadPool(N)
- newCachedThreadPool()
- newScheduledThreadPool(N)
    - for cron-like tasks
- newSingleThreadExecutor()
    - sequential execution - good for ordered tasks
- newWorkStealingPool(), ForkJoinPool()
    - parallel recursive tasks


