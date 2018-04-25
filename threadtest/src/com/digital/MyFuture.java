package com.digital;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Future 就类似于之前的 Thread(runnable),只是前者 submit 后立即执行，通过 get() 获得结果，后者用 start() 方法启动。
//runnable 是没有结果的，只有 callable 被提交(到线程池) 后返回的 Future 才可能会有结果
//Future必须有线程池，callable配合futuretask可以不需要线程池
public class MyFuture {
	
   	 
  
   class MyCallable implements Callable {
	   private int tickets = 10;
		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			for (int i = 0; i <= 100; i++) {  
	            if(tickets>0){  
	                System.out.println(Thread.currentThread().getName()+"--卖出票：" + tickets--);  
	            }  
	        }
	         return Thread.currentThread().getName()+"--finish"; 
		} 
		
   
		
		
	}
    
    public void dofuture(){
    	ExecutorService executor = Executors.newCachedThreadPool();  
    	Callable mycallable=new MyCallable();
    	Future<Integer> myfuture1 = executor.submit(mycallable);  
    	Future<Integer> myfuture2 = executor.submit(mycallable); 
    	Future<Integer> myfuture3 = executor.submit(mycallable); 
    	try {
			System.out.println(myfuture1.get());
			System.out.println(myfuture2.get());
			System.out.println(myfuture3.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
    }
   public static void main(String[] args){
	   MyFuture myfuture=new MyFuture();
	   myfuture.dofuture();
	   
	    }

}
