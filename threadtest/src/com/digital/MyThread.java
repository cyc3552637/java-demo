package com.digital;

public class MyThread extends Thread {  
	  
    private int tickets = 10;  
  
    @Override  
    public void run() {  
  
        for (int i = 0; i <= 100; i++) {  
            if(tickets>0){  
                System.out.println(Thread.currentThread().getName()+"--卖出票：" + tickets--);  
            }  
        }  
    }  
      
      
    public static void main(String[] args) {  
        MyThread thread1 = new MyThread();  
        MyThread thread2 = new MyThread();  
        MyThread thread3 = new MyThread();  
  
        thread1.start();  
        thread2.start();  
        thread3.start();  
          
        //每个线程都独立，不共享资源，每个线程都卖出了10张票，总共卖出了30张。如果真卖票，就有问题了。  
    }  
  
}  
