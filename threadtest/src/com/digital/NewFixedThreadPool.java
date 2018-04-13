package com.digital;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPool {
	public static void main(String[] args) {  
        // 创建一个线程池  
        ExecutorService pool = Executors.newFixedThreadPool(2);  //指定了可以运行的线程的最大数目，超过这个数目的线程加进去以后，不会运行。其次，加入线程池的线程属于托管状态，线程的运行不受加入顺序的影响
        // 创建线程  
//        MyThread thread1 = new MyThread();  
//        MyThread thread2 = new MyThread();  
//        MyThread thread3 = new MyThread();  
//        MyThread thread4 = new MyThread();  
//        MyThread thread5 = new MyThread(); 
        MyRunnable myRunnable = new MyRunnable();  
        Thread thread1 = new Thread(myRunnable, "窗口一");  
        Thread thread2 = new Thread(myRunnable, "窗口二");  
        Thread thread3 = new Thread(myRunnable, "窗口三"); 
        Thread thread4 = new Thread(myRunnable, "窗口四");  
        Thread thread5 = new Thread(myRunnable, "窗口五"); 
        // 将线程放入池中进行执行  
        pool.execute(thread1);  
        pool.execute(thread2);  
        pool.execute(thread3);  
        pool.execute(thread4);  
        pool.execute(thread5);  
        // 关闭线程池  
        pool.shutdown();  
    }  
}  

