package com.digital.test;
import com.digital.test.ListAdd;

public class ListTest {
	public static  void main(String[] args){
		ListAdd list=new ListAdd();
		
		Thread threadOne = new Thread(new Runnable() {
	        public void run() {
	        	long start = System.currentTimeMillis();
	            
	            for (String result : list.add()) {  
	            	if(!result.equals("101")){
//	                System.out.println("result1"+result);
	            		result.toString();
	            	}
	            }  
	            long end = System.currentTimeMillis();
	            System.out.println("forJava1: " + (end - start));
	            
	        }
	    });
	     
		Thread threadtwo = new Thread(new Runnable() {
	        public void run() {
	        	long start = System.currentTimeMillis();
	        	list.add().parallelStream().filter((result)->!"101".equals(result)).forEach(result -> result.toString());
	        	 long end = System.currentTimeMillis();
		            System.out.println("forJava2: " + (end - start));
	        }
	    });

	    // 执行线程
	
	    threadOne.start();
	    threadtwo.start();


	}

}
