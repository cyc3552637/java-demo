package maptest.com.main;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import maptest.com.digital.HashMapAdd;



public class MainHashMap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				String show="";
				HashMapAdd hmd1=new HashMapAdd();
				Map<String, String> map1=hmd1.add();
				System.out.println("size1=:"+map1.size());
				for(String result1:map1.values()){
					show=show+","+result1.toString();
				}
				
				long end=System.currentTimeMillis();
				System.out.println("time1=: "+(end-start));
				System.out.println("HashMapAdd1: "+show);
			}
			
		});
		Thread thread2=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				String show="";
				HashMapAdd hmd2=new HashMapAdd();
				Map<String, String> map2=hmd2.add();
				System.out.println("size2=:"+map2.size());
				Iterator<String> iter = map2.values().iterator();
				while(iter.hasNext()){
					   String result2 = iter.next();
					   show=show+","+result2;
				   }
				
				long end=System.currentTimeMillis();
				System.out.println("time2=: "+(end-start));
				System.out.println("HashMapAdd2: "+show);
			}
			
		});

		
		thread1.start();
		thread2.start();

	
	}

}

//HashMap 
//1、HashMap最多只允许一条记录的键为Null;允许多条记录的值为 Null。
//2、HashMap不支持线程的同步，即任一时刻可以有多个线程同时写HashMap;可能会导致数据的不一致。

//LinkedHashMap
//1、LinkedHashMap也是一个HashMap,但是内部维持了一个双向链表,可以保持顺序

//TreeMap
//1、TreeMap 可以用于排序，有Comparator对比排序器
