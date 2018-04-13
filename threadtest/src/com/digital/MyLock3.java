package com.digital;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class MyLock3{
    LinkedList<String> store =new LinkedList<String>();
    int i=1;
class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;

//	创建一个锁对象。
	Lock lock = new ReentrantLock();



	//通过已有的锁获取两组监视器，一组监视生产者，一组监视消费者。
	Condition producer_con = lock.newCondition();
	Condition consumer_con = lock.newCondition();

	
	public  void set(String name)//  t0 t1
	{
		lock.lock();
		try
		{
			while(store.size()>3)
			try{
				System.out.println("厨房已经满了");
				consumer_con.signalAll();
				producer_con.await();
				}catch(InterruptedException e){}//   t1    t0
		
		
			String str = "烤鸭"+i;
	        store.add(str);
			System.out.println(Thread.currentThread().getName()+"...生产者..."+str);//生产烤鸭1 生产烤鸭2 生产烤鸭3
			i++;
			producer_con.signalAll();

			
		}
		finally
		{
			lock.unlock();
		}
		
	}

	public  void out()// t2 t3
	{
		lock.lock();
		try
		{
			while(store.size()==0)

			try{
				System.out.println("厨房已经空了");
				producer_con.signalAll();
				consumer_con.await();
				}catch(InterruptedException e){}	//t2  t3
			String str = store.removeLast();
			System.out.println(Thread.currentThread().getName()+"...消费者......."+str);//消费烤鸭
			
				consumer_con.signalAll();
		
		}
		finally
		{
			lock.unlock();
		}
		
	}
}

class Producer implements Runnable
{
	private Resource r;
	Producer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.set("烤鸭");
		}
	}
}

class Consumer implements Runnable
{
	private Resource r;
	Consumer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.out();
		}
	}
}




	public void domain()
	{
		Resource r = new Resource();
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);
		ExecutorService poolproducer = Executors.newCachedThreadPool(); 
   	    ExecutorService poolconsumer = Executors.newCachedThreadPool(); 
   	    poolproducer.execute(new Thread(pro,"生产者一"));
   	    poolproducer.execute(new Thread(pro,"生产者二"));
   	    poolproducer.execute(new Thread(pro,"生产者三"));
   	    poolconsumer.execute(new Thread(con,"消费者一"));
   	    poolconsumer.execute(new Thread(con,"消费者二"));
   	    poolconsumer.execute(new Thread(pro,"消费者三"));

	}
	public static void main(String[] args){
		MyLock3 ml=new MyLock3();
		ml.domain();
	}
}
//生产者和消费者可以选择性唤醒
