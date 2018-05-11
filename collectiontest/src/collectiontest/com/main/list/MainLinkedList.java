package collectiontest.com.main.list;

import java.util.Iterator;
import java.util.List;

import collectiontest.com.digital.list.LinkedListAdd;





public class MainLinkedList {
	
	
//十万级别，LinkedList的foreach最快，跟arraylist差不多，但是到百万级别就不如arraylist了
//用Iterator和arraylist的所有都差不多
//for的速度极慢
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				LinkedListAdd ala=new LinkedListAdd();
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
				LinkedListAdd ala=new LinkedListAdd();
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
				LinkedListAdd ala=new LinkedListAdd();
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
				LinkedListAdd ala=new LinkedListAdd();
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
//LinkedList是通过双向链表实现的，无法支持随机访问。当你要向一个链表取第index个元素时，
//它需要二分后从某一端开始找，一个一个地数才能找到该元素。这样一想，就能明白为何get(index)如此费时了。


//1、传统的for循环遍历，基于计数器的：
//因为是基于元素的位置，按位置读取。所以我们可以知道，对于顺序存储，因为读取特定位置元素的平均时间复杂度是O(1)，所以遍历整个集合的平均时间复杂度为O(n)。而对于链式存储，因为读取特定位置元素的平均时间复杂度是O(n)，所以遍历整个集合的平均时间复杂度为O(n^2)（n的平方）。
//2、迭代器遍历，Iterator：
//那么对于RandomAccess类型的集合来说，没有太多意义，反而因为一些额外的操作，还会增加额外的运行时间。但是对于Sequential Access的集合来说，就有很重大的意义了，因为Iterator内部维护了当前遍历的位置，所以每次遍历，读取下一个位置并不需要从集合的第一个元素开始查找，只要把指针向后移一位就行了，这样一来，遍历整个集合的时间复杂度就降低为O(n)；
//3、foreach循环遍历：
//分析Java字节码可知，foreach内部实现原理，也是通过Iterator实现的，只不过这个Iterator是Java编译器帮我们生成的，所以我们不需要再手动去编写。但是因为每次都要做类型转换检查，所以花费的时间比Iterator略长。时间复杂度和Iterator一样。
