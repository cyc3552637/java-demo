package com.digital;


import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * 操作同一个对象时的同步锁 synchronized
 */
public class MySynchronized6{
    LinkedList<String> store =new LinkedList<String>();
    int i=1;
  
    public void toTest(){
        //为每个对象创建一个线程，一位是内部类，所有操作的外部CopyOfSynchronizedClass的store是公共的
    	 ExecutorService poolproducer = Executors.newCachedThreadPool(); 
    	 ExecutorService poolconsumer = Executors.newCachedThreadPool(); 
    	Resource resource = new Resource();
    	Thread producer1=new Thread(new Producer(resource),"生产者一");
    	Thread producer2=new Thread(new Producer(resource),"生产者二");
    	Thread producer3=new Thread(new Producer(resource),"生产者三");
    	Thread consumer1=new Thread(new Consumer(resource),"消费者一");
    	Thread consumer2=new Thread(new Consumer(resource),"消费者二");
    	Thread consumer3=new Thread(new Consumer(resource),"消费者三");
    	poolproducer.execute(producer1);
    	poolproducer.execute(producer2);
    	poolproducer.execute(producer3);
    	poolconsumer.execute(consumer1);
    	poolconsumer.execute(consumer2);
    	poolconsumer.execute(consumer3);
    }
    public class Resource {
        /*资源序号*/
        private int number = 0;
        /*资源标记*/
        private boolean flag = false;

        /**
         * 生产资源
         */
        public synchronized void create() {
            while (store.size()>1) {//先判断标记是否已经生产了，如果已经生产，等待消费；
                try {
                    wait();//让生产线程等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String str = "货物"+i;
            store.add(str);
            System.out.println(Thread.currentThread().getName() + "生产者------------" + str);
            i++;
            flag = true;//将资源标记为已经生产
            notifyAll();//唤醒在等待操作资源的线程（队列）
        }

        /**
         * 消费资源
         */
        public synchronized void destroy() {
            while (store.size()<1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String str = store.removeLast();
            System.out.println(Thread.currentThread().getName() + "消费者****" + str);
            flag=false;
            
            notifyAll();
        }
    }
    //生产者
    class Producer implements Runnable{
    
    	private Resource resource;

        public Producer(Resource resource) {
            this.resource = resource;
        }
        public void run() {
        	while (true) {
        		 try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		 resource.create();
  
        }
        
    }
    }
    //消费者
    class Consumer implements Runnable{
    	private Resource resource;

        public Consumer(Resource resource) {
            this.resource = resource;
        }
        @Override
        public void run() {
        	while (true) {
       		 try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

       		resource.destroy();
        }
    }
    }
    public static void main(String[] args) {
        /**
         * 第二大类：只new一个对象：synchronizedClass；所有动作都在这个对象中操作
         */
    	MySynchronized6 synchronizedClass = new MySynchronized6();
        synchronizedClass.toTest();
    }
//用list的size做判断往往有延迟，所以用flag做判断比较明显
}