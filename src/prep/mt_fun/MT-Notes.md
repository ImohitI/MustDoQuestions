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

# ThreadPool Executor Intenals
- ThreadPoolExecutor
    - corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit, 
    - Blockingqueue<Runnable>, ThreadFactory, RejectedExecutionHandler
- core - queue - max - reject 

- task flow
    - if running threads < core, create thread immediately
    - Else if queue not full 
    - add task to queue
    - Else if threads < max 
    - create extra thread 
    - Else 
    - Invoke rejected execution handler
    
- RejectExecutionHandler
    - abortpolicy, throws RejectedExecutionException
    - callerrunspolicy, caller thread executes the task
    - discardpolicy, silently drop task
    - discardoldestpolicy, removes oldest task in queue

- queue types 
    - Unbounded queue, used in FixedThreadPool
    - new LinkedBlockingQueue<>()
    - Bounded queue
    - new ArrayBlockingQueue<>(1000)
    - SynchronousQueue
    - Used by cachedThreadPool (no queue, direct handoff)

- ForkJoinPool 
    - used in parallel streams, CompletableFuture default pool
    - each worker has its own deque
    - Idle workers steal work from others --> improved parallelism

# Producer Consumer patterns
- producer produces, consumer process data
- shared buffer, holds data
- slow producers vs fast producers
- controlling pressure on downstream systems 
- buffering data 
- async communication 
- decoupling modules 

# method 1 : using blockingqueue
- waiting
- signaling 
- thread safety
- blocking behaviour
