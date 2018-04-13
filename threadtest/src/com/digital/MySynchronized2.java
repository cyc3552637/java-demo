package com.digital;

public class MySynchronized2 extends Thread {  
	  
 
  
    @Override  
    public void run() {  
           this.sell();
        
    }  
    
    public synchronized static void sell(){
    	int tickets = 10; 
    	for (int i = 0; i <= 100; i++) { 
    	  
            if(tickets>0){  
                System.out.println(Thread.currentThread().getName()+"--卖出票：" + tickets--);  
            }  
        }  
    }
      
      
    public static void main(String[] args) {  
        MySynchronized2 thread1 = new MySynchronized2();  
        MySynchronized2 thread2 = new MySynchronized2();  
        MySynchronized2 thread3 = new MySynchronized2();  
  
        thread1.start();  
        thread2.start();  
        thread3.start();  
          
        //每个线程都独立，不共享资源，每个线程都卖出了10张票，总共卖出了30张。如果真卖票，就有问题了。  
    }  
  
}  
