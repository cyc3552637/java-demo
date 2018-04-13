package com.digital;

public class MySynchronized3 extends Thread {  
	  

  
    @Override  
    public void run() {  
           this.sell();
        
    }  
    
    public void sell(){
    	 synchronized(MySynchronized3.class){
    	int tickets = 10;
    	for (int i = 0; i <= 100; i++) {  
            if(tickets>0){  
                System.out.println(Thread.currentThread().getName()+"--卖出票：" + tickets--);  
            }  
        } 
    	 }
    }
      
      
    public static void main(String[] args) {  
        MySynchronized3 thread1 = new MySynchronized3();  
        MySynchronized3 thread2 = new MySynchronized3();  
        MySynchronized3 thread3 = new MySynchronized3();  
  
        thread1.start();  
        thread2.start();  
        thread3.start();  
          
        //每个线程都独立，不共享资源，每个线程都卖出了10张票，总共卖出了30张。如果真卖票，就有问题了。  
    }  
  
}  
