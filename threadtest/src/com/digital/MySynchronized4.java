package com.digital;


import java.util.LinkedList;

/** 
 * 操作同一个对象时的同步锁 synchronized
 */
public class MySynchronized4{
    LinkedList<String> store =new LinkedList<String>();
    int i=1;
  
    public void toTest(){
        //为每个对象创建一个线程，一位是内部类，所有操作的外部CopyOfSynchronizedClass的store是公共的
    	Producer producer=new Producer();
    	Consumer consumer=new Consumer();
        new Thread(producer,"生产者一").start();
        new Thread(producer,"生产者二").start();
        new Thread(producer,"生产者三").start();
        new Thread(consumer,"消费者一").start();
        new Thread(consumer,"消费者二").start();
        new Thread(consumer,"消费者三").start();
    }
    //调用此方法，消费
    public synchronized void create() {
       
        if (store.size()>3) {//先判断标记是否已经生产了，如果已经生产，等待消费；
            try {
            	System.out.println("仓库货已满！");
                wait();//让生产线程等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
        i++;
        String str = "货物"+i;
        store.add(str);//生产一个
        System.out.println(Thread.currentThread().getName() + "生产的货物："+str);
        notifyAll();//唤醒在等待操作资源的线程（队列）
        }
      	
    }
    public synchronized void destroy() {
        if (store.size()==0) {
            try {
            	System.out.println("仓库无货！");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
        String str = store.removeLast();
        System.out.println(Thread.currentThread().getName() + "消费货品："+str);
        notifyAll();
        }

    }
    //生产者
    class Producer implements Runnable{
    

        public void run() {
        	while (true) {
        		 try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		 create();
  
        }
        
    }
    }
    //消费者
    class Consumer implements Runnable{

        @Override
        public void run() {
        	while (true) {
       		 try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

       		destroy();
        }
    }
    }
    public static void main(String[] args) {
        /**
         * 第二大类：只new一个对象：synchronizedClass；所有动作都在这个对象中操作
         */
    	MySynchronized4 synchronizedClass = new MySynchronized4();
        synchronizedClass.toTest();
    }
//无论是生产者还是消费者，进入以后每一个线程都是等待状态，这样谁先到拿到线程就开始运行，然后运行完以后notify唤醒。
//唤醒以后，下一个等待资源抢夺到线程锁进行，自身在while循环判断下重新进入等待状态。
//出现无货或者货满状态，直接wait，这样就无限等待了，下一次肯定拿不到锁，需要下次别的线程执行完了notify的时候唤醒。
//这里由于notify只唤醒一个线程，有可能唤醒自己的线程，所以用notifyall
}