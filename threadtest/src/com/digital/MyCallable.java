package com.digital;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//Callable 相当于之前的 Runnable, 只是 Callable 是有返回值的
//FutureTask配合Callable使用
public class MyCallable implements Callable {  
	  
    private int tickets = 10;  
  
    @Override  
    public String call() {  
  
        for (int i = 0; i <= 100; i++) {  
            if(tickets>0){  
                System.out.println(Thread.currentThread().getName()+"--卖出票：" + tickets--);  
            }  
        }
         return Thread.currentThread().getName()+"--finish"; 
    }  
      
      
    public static void main(String[] args) {  
        MyCallable mycallable = new MyCallable(); 
        FutureTask<Integer> result1 = new FutureTask<>(mycallable);
        FutureTask<Integer> result2 = new FutureTask<>(mycallable);
        FutureTask<Integer> result3 = new FutureTask<>(mycallable);
        Thread thread1 = new Thread(result1, "窗口一");  
        Thread thread2 = new Thread(result2, "窗口二");  
        Thread thread3 = new Thread(result3, "窗口三");  
  
        thread1.start();
        thread2.start();  
        thread3.start();  
        try {
			System.out.println(result1.get());
			System.out.println(result2.get());
			System.out.println(result3.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }


 
  
}  
