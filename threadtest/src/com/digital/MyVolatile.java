package com.digital;

import java.util.LinkedList;

import com.digital.MySynchronized5.Consumer;
import com.digital.MySynchronized5.Producer;

public class MyVolatile {
	static class ThreadNoLock extends Thread {
        static int count = 0;

        private static void addCount() {
            for (int i = 0; i < 100; i++) {
                count++;
            }
            System.out.println("count = " + count);
        }

        @Override
        public void run() {
            addCount();
        }
    }
	static class ThreadVolatile extends Thread {
		volatile static int volatilecount = 0;

        private static void addCount() {
            for (int i = 0; i < 100; i++) {
            	volatilecount++;
            }
            System.out.println("Volatilecount = " + volatilecount);
        }

        @Override
        public void run() {
            addCount();
        }
    }
	static class SynchronizedThread extends Thread {
        static int synchronizedcount = 0;

        private synchronized static void addCount() {
            for (int i = 0; i < 100; i++) {
            	synchronizedcount++;
            }
            System.out.println("synchronizedcount = " + synchronizedcount);
        }

        @Override
        public void run() {
            addCount();
        }
    }
	public static void main(String[] args){
		ThreadNoLock[] tnl=new ThreadNoLock[100];
		SynchronizedThread[] st=new SynchronizedThread[100];
		ThreadVolatile[] tv=new ThreadVolatile[100];
		for(int i=0;i<100;i++){
			tnl[i]=new ThreadNoLock();
			st[i]=new SynchronizedThread();
			tv[i]=new ThreadVolatile();
		}
		for (ThreadNoLock t:tnl) {
			t.start();
        }
		for (SynchronizedThread s:st) {
			s.start();
        }
		for (ThreadVolatile v:tv) {
			v.start();
        }

	}
	
}
//关键字volatile是线程同步的轻量级实现，所以volatile性能肯定比synchronized要好，并且volatile只能修饰于变量，而synchronized可以修饰方法，以及代码块。随着JDK版本的升级，synchronized关键字在 执行效率上得到很大提升，在开发中使用synchronized关键字的比率还是比较大的。
//多线程访问volatile不会发生阻塞，而synchronized会出现阻塞。
//volatile能保证数据的可见性，但不能保证原子性；而synchronized可以保证原子性，也可以间接保证可见性，因为它将私有内存和公共内存中的数据做同步。
//值得强调的是：关键字volatile解决的是变量在多个线程之间的可见性；而关键字synchronized解决的是多线程之间访问资源的同步性。

//原子是世界上的最小单位，具有不可分割性。比如 a=0；（a非long和double类型）这个操作是不可分割的，那么我们说这个操作时原子操作。再比如：a++；这个操作实际是a = a + 1；是可分割的，所以他不是一个原子操作。非原子操作都会存在线程安全问题，需要我们使用同步技术（sychronized）来让它变成一个原子操作
//在这个例子中，单线程是只会++1次，所以多线程的时候，就会互相增加，这时候synchronized保证了锁，使得具有原子性，线程安全。
//而volatile不具有原子性，因为多个的时候会多线程同时++操作，但没有锁导致了同时做一个操作，会有数据重复和丢失，不能线程安全。
//线程安全意味着，本线程不会被其他线程影响，不会有多个线程是做同一件重复事情，拿到锁的线程是绝对安全的。
