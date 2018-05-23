#  线程方式  
  
Thread  
多个线程同一个执行体是分别执行，每个线程都独立，不共享资源。  
  
Runnable  
多个线程同一个执行体，共享资源，这里要注意Runnable只会共享变量资源，但是每个线程里的循环这样的操作还是独立的。  
  
Future  
相当于Thread，配合callable可以拿到返回值。   
  
Callable  
相当于Runnable，有返回值，可以配合FutureTask不用线程池，配合Future有线程池。    
  
  
#  线程锁  
  
synchronized  
1、是Java的关键字在JVM层面  
2、可以修饰方法、变量、类等  
3、执行完或者线程异常，会释放锁  
4、线程等待模式  
5、不判断锁状态  
6、可重入、中断、非公平  
7、少量同步    
  
Lock  
1、是一个类  
2、直接调用lock类方法加锁  
3、finally中必须释放锁，否则容易死锁  
4、线程不等待  
5、不判断锁状态  
6、可重入、可中断、可公平  
7、大量同步  
  
 
Volatile  
1、是Java的关键字在JVM层面  
2、只能修饰变量  
3、线程不等待  
4、跟synchronized比不能保证原子性，这样导致线程不安全  
  
  
#  线程池  
  
CachedThreadPool  
可根据需要，创建新线程的线程池，而且以前构造的线程可用时，将重用它们。  
  
FixedThreadPool  
指定了可以运行的线程的最大数目，超过这个数目的线程加进去以后，不会运行。  
其次，加入线程池的线程属于托管状态，线程的运行不受加入顺序的影响。  
  
ScheduledThreadPool  
定时线程池，可以根据自定义时间启动线程。  
  
SingleThread  
单例线程池，只有唯一线程运行  
   
