package com.digital;


import java.util.LinkedList;

import com.digital.MySynchronized4.Consumer;
import com.digital.MySynchronized4.Producer;

/** 
 * 操作同一个对象时的同步锁 synchronized
 */
public class MySynchronized5{
    LinkedList<String> store =new LinkedList<String>();
    /** 
     * 3.public synchronized void getCount(){}修饰一个普通方法,只是对同一个对象的同步线程有影响，new SynchronizedClass()多一个同步锁，不共用，岂不多锁的效果
     */
    /*public synchronized void getCount(){
        System.out.println("当前线程："+Thread.currentThread().getName());
        for(int i = 0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+":i="+i);
        }
    }*/
    
    /** 
     * 4.synchronized(this)修饰this同步代码块时,只是对同一个对象的同步线程有影响,其他试图访问该对象的线程将被阻塞。
     * new SynchronizedClass()多一个同步锁，不共用，岂不多锁的效果
     */
    /*public void getCount(){
        synchronized(this){
            System.out.println("当前线程："+Thread.currentThread().getName());
            for(int i = 0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+":i="+i);
            }
        }
    }*/
    
    /** 
     * 5.synchronized(store)修饰store指定对象最好的场景：取钱，存钱；或者生产者模式,只是对同一个对象的同步线程有影响,其他试图访问该对象的线程将被阻塞。
     * new SynchronizedClass()多一个同步锁，不共用，岂不多锁的效果
     */
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
    public void getCount(){
        synchronized(store){
                try{

                    while(store.size() == 0){
                        System.out.println("仓库无货！");
                        store.wait();//方法wait() 是无限期(一直)等待，直到其它线程调用notify或notifyAll方法唤醒当前的线程
                    }
                    String str = store.removeLast();
                    System.out.println(Thread.currentThread().getName()+"消费货品："+str);
//                    Thread.sleep(200);
                    store.notifyAll();//notify()方法只唤醒一个等待（对象的）线程并使该线程开始执行。所以如果有多个线程等待一个对象，这个方法只会唤醒其中一个线程，
                                   //选择哪个线程取决于操作系统对多线程管理的实现(因为此处只有'生产者'和'消费者'，你懂得);
                                   //notifyAll()方法会唤醒所有等待(对象的)线程，哪一个线程将会第一个处理或访问(加了synchronized修饰的场景)取决于操作系统的实现
                }catch(InterruptedException e){
                    System.out.println("consumer is interrupted! msg="+e.getMessage());
                }
            }
        }
 
    int i=1;
    public void setCount(){
        synchronized(store){
            	
                try{
            
                    while(store.size() > 1){
                        System.out.println("仓库货物已满！");
                        store.wait();
                    }
                    String str = "货物"+i;
                    store.add(str);
                    System.out.println(Thread.currentThread().getName()+"生产的货物："+str);
//                    Thread.sleep(200);
                    store.notifyAll();
                    i++;
                }catch(InterruptedException e){
                    System.out.println("Producer is interrupted! msg="+e.getMessage());
                }
        }
    }
    //生产者
    class Producer implements Runnable{
        @Override
        public void run() {
        	while(true){
            try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            setCount();
        }
        	}
        
    }
    //消费者
    class Consumer implements Runnable{
        @Override
        public void run() {
            // TODO Auto-generated method stub
        	while(true){
            try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            getCount();
        	}
        }
    }
    public static void main(String[] args) {
        /**
         * 第二大类：只new一个对象：synchronizedClass；所有动作都在这个对象中操作
         */
    	MySynchronized5 synchronizedClass = new MySynchronized5();
        synchronizedClass.toTest();
    }
//这里对资源store加了锁，跟方法加锁效果一样，大家从抢夺方法变成了抢夺资源。
}