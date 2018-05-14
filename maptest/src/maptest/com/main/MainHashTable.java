package maptest.com.main;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import maptest.com.digital.HashMapAdd;
import maptest.com.digital.HashTableAdd;



public class MainHashTable {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				String show="";
				HashTableAdd hta1=new HashTableAdd();
				Map<String, String> map1=hta1.add();
				System.out.println("size1=:"+map1.size());
				for(String result1:map1.values()){
					show=show+","+result1.toString();
				}
				
				long end=System.currentTimeMillis();
				System.out.println("time1=: "+(end-start));
				System.out.println("HashTableAdd1: "+show);
			}
			
		});
		Thread thread2=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				String show="";
				HashTableAdd hta2=new HashTableAdd();
				Map<String, String> map2=hta2.add();
				System.out.println("size2=:"+map2.size());
				Iterator<String> iter = map2.values().iterator();
				while(iter.hasNext()){
					   String result2 = iter.next();
					   show=show+","+result2;
				   }
				
				long end=System.currentTimeMillis();
				System.out.println("time2=: "+(end-start));
				System.out.println("HashTableAdd2: "+show);
			}
			
		});

		
		thread1.start();
		thread2.start();

	
	}

}

//1. HashSet是通过HashMap实现的,TreeSet是通过TreeMap实现的,只不过Set用的只是Map的key。
//2.HashMap和Hashtable都实现了Map接口，HashMap几乎可以等价于Hashtable，除了HashMap是非synchronized的。

