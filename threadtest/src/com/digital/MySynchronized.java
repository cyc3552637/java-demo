package com.digital;


import java.util.LinkedList;

/** 
 * 操作同一个对象时的同步锁 synchronized
 */
public class MySynchronized{
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
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
    //调用此方法，消费
    public void getCount(){
        synchronized(store){
            while(true){
                try{
                    while(store.size() == 0){
                        System.out.println("仓库无货！");
                        store.wait();//方法wait() 是无限期(一直)等待，直到其它线程调用notify或notifyAll方法唤醒当前的线程
                    }
                    String str = store.removeLast();
                    System.out.println("消费货品："+str);
                    Thread.sleep(200);
                    store.notify();//notify()方法只唤醒一个等待（对象的）线程并使该线程开始执行。所以如果有多个线程等待一个对象，这个方法只会唤醒其中一个线程，
                                   //选择哪个线程取决于操作系统对多线程管理的实现(因为此处只有'生产者'和'消费者'，你懂得);
                                   //notifyAll()方法会唤醒所有等待(对象的)线程，哪一个线程将会第一个处理或访问(加了synchronized修饰的场景)取决于操作系统的实现
                }catch(InterruptedException e){
                    System.out.println("consumer is interrupted! msg="+e.getMessage());
                }
            }
        }
    }
    int i=0;
    public void setCount(){
        synchronized(store){
            while(true){
                try{
                    while(store.size() > 3){
                        System.out.println("仓库货物已满！");
                        store.wait();
                    }
                    String str = "货物"+i;
                    store.add(str);
                    System.out.println("生产的货物："+str);
                    Thread.sleep(200);
                    store.notify();
                    i++;
                }catch(InterruptedException e){
                    System.out.println("Producer is interrupted! msg="+e.getMessage());
                }
            }
        }
    }
    //生产者
    class Producer implements Runnable{
        @Override
        public void run() {
            setCount();
        }
        
    }
    //消费者
    class Consumer implements Runnable{
        @Override
        public void run() {
            // TODO Auto-generated method stub
            getCount();
        }
    }
    public static void main(String[] args) {
        /**
         * 第二大类：只new一个对象：synchronizedClass；所有动作都在这个对象中操作
         */
    	MySynchronized synchronizedClass = new MySynchronized();
        synchronizedClass.toTest();
    }
//sleep和wait，wait是无限等待，sleep是暂时等待,在本例子中放入货物和消费货物都是sleep一个等待线程，这样唤起只能唤起自己。
//知道放满或者消费满以后，用wait无限等待了，这样这个线程就拿不到锁了，另外一个拿到锁以后，notify的时候会顺带唤起wait的线程。
}