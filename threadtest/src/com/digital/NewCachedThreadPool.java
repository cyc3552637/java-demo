package com.digital;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPool {
	public static void main(String[] args) {  
        // 创建一个线程池  
        ExecutorService pool = Executors.newCachedThreadPool(); //可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们
        // 创建线程  
        MyThread thread1 = new MyThread();  
        MyThread thread2 = new MyThread();  
        MyThread thread3 = new MyThread();  
        MyThread thread4 = new MyThread();  
        MyThread thread5 = new MyThread(); 
        
        
//        MyRunnable myRunnable = new MyRunnable();  
//        Thread thread1 = new Thread(myRunnable, "窗口一");  
//        Thread thread2 = new Thread(myRunnable, "窗口二");  
//        Thread thread3 = new Thread(myRunnable, "窗口三"); 
//        Thread thread4 = new Thread(myRunnable, "窗口四");  
//        Thread thread5 = new Thread(myRunnable, "窗口五"); 
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

