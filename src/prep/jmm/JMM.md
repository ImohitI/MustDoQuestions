# JMM
Java memory model defines how thread see and share variable

# CPU cache and reordering
- each core has its own cache
- threads read and write variable in there own cache
- CPU may reorder instruction 

this causes 
- stale value
- out of order effects
- inconsistent program behaviour 
Multiplethreading = multiple caches = stale values

# What JMM ensures
- Visibility
- Ordering 
- Happens-before relationship

# Visibility Problem 
- Thread A updates a variable
- Thread B does not see it because it reads from its own CPU cache 
# Volatile 
- ensures visibility
    - a write to a volatile variable is immediately visible to other threads
    - write happens-before a subsequent volatile read of the same variable
- ensures ordering 
    - jvm and cpu must not reorder memory operations across a volatile read/write in ways that would violate happens before semantics.
    - read/write of a volatile primitive variable is atomic but for compound operations like increment are not atomic
but NOT atomicity
So this is not thread safe
- If you do a read modify write like count++, multiple threads can interleave and lose updates volatile does not make the whole compound operation atomic. You still need synchronization or atomic classes for such cases.

# When to use Volatile 
- simple states 
- flags 
- configs
- closed/open 
- running/stopped 

# Happens-before relationship 
if A happens before B then B sees A's changes
- Volatile rule 
- Write to volatile, happens-before, read of the same volatile variable
- Monitor lock rule 
- Unlock happens-before subsequent lock 
- Thread start rule 
- Start happens-before run() 
- Thread join rule 
- Thread completion happens before join()
- Final fields rule 
- Fields marked final are safe to publish after constructor finishes
--- volatile, lock, start/join, final 

# Instruction Reordering 
- jvm and reordering for optimization

# Double checked locking 
- DCL requires volatile --- always

# real world example 
- volatile boolean configReloadNeeded = false 
- Any worker thread sees the change instantly
- multiple threads read market data snapshot
- volatile ensures
    - fresh market data
    - no stale cached values 
    - synchronized visibility in multi-core machines
- dcl using volatile
private static volatile Singleton instance;
public static Singleton getInstance() {
    if (instance == null) {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
    }
}
