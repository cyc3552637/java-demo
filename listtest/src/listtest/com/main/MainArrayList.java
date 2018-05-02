package listtest.com.main;

import java.util.Iterator;
import java.util.List;

import listtest.com.digital.ArrayListAdd;

//百万级别，Iterator最快，下来是foreach，然后是for,总体差别不大。
//十万级别，foreach最慢一点

public class MainArrayList {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				ArrayListAdd ala=new ArrayListAdd();
				List<String> list1=ala.add();
				for(String result:list1){
					result.toString();
					
				}
				
				long end=System.currentTimeMillis();
				System.out.println("time1=: "+(end-start));
			}
			
		});
		Thread thread2=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				ArrayListAdd ala=new ArrayListAdd();
				List<String> list2=ala.add();
				Iterator<String> iter = list2.iterator();
				while(iter.hasNext()){
				      String result = iter.next();
				   }
				
				long end=System.currentTimeMillis();
				System.out.println("time2=: "+(end-start));
			}
			
		});
		Thread thread3=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				ArrayListAdd ala=new ArrayListAdd();
				List<String> list3=ala.add();
				for(int i=0;i<list3.size();i++){
					String result= list3.get(i);
				   }
				
				long end=System.currentTimeMillis();
				System.out.println("time3=: "+(end-start));
			}
			
		});
		
		Thread thread4=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				ArrayListAdd ala=new ArrayListAdd();
				List<String> list4=ala.add();
				int size=list4.size();
				for(int i=0;i<size;i++){
					String result= list4.get(i);
				   }
				
				long end=System.currentTimeMillis();
				System.out.println("time4=: "+(end-start));
			}
			
		});
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	
	}

}
//1、顺序存储，Random Access（Direct Access）：
//这种方式，相邻的数据元素存放于相邻的内存地址中，整块内存地址是连续的。可以根据元素的位置直接计算出内存地址，直接进行读取。读取一个特定位置元素的平均时间复杂度为O(1)。正常来说，只有基于数组实现的集合，才有这种特性。Java中以ArrayList为代表。
//2、链式存储，Sequential Access：
//这种方式，每一个数据元素，在内存中都不要求处于相邻的位置，每个数据元素包含它下一个元素的内存地址。不可以根据元素的位置直接计算出内存地址，只能按顺序读取元素。读取一个特定位置元素的平均时间复杂度为O(n)。主要以链表为代表。Java中以LinkedList为代表。


//1、传统的for循环遍历，基于计数器的：
//遍历者自己在集合外部维护一个计数器，然后依次读取每一个位置的元素，当读取到最后一个元素后，停止。主要就是需要按元素的位置来读取元素。
//2、迭代器遍历，Iterator：
//每一个具体实现的数据集合，一般都需要提供相应的Iterator。相比于传统for循环，Iterator取缔了显式的遍历计数器。所以基于顺序存储集合的Iterator可以直接按位置访问数据。而基于链式存储集合的Iterator，正常的实现，都是需要保存当前遍历的位置。然后根据当前位置来向前或者向后移动指针。
//3、foreach循环遍历：
//根据反编译的字节码可以发现，foreach内部也是采用了Iterator的方式实现，只不过Java编译器帮我们生成了这些代码。

//复杂度总结
//ArrayList是顺序存储，LinkedList是链式存储
//for对于顺序存储，特定点复杂度O(1)，遍历复杂度O(n)。对于链式存储，特定点复杂度O(n),遍历复杂度O(n2)(n的平方)
//Iterator对于顺序存储，没有太大意义，还有额外操作，会慢一点。对链式存储，遍历复杂度为O(n)
//foreach和Iterator一样，但是Iterator封装了一下，速度比Iterator慢一点。