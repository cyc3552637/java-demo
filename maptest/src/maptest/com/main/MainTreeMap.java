package maptest.com.main;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import maptest.com.digital.HashMapAdd;
import maptest.com.digital.TreeMapAdd;



public class MainTreeMap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				String show="";
				TreeMapAdd tma1=new TreeMapAdd();
				Map<String, String> map1=tma1.add();
				System.out.println("size1=:"+map1.size());
				for(String result1:map1.values()){
					show=show+","+result1.toString();
				}
				
				long end=System.currentTimeMillis();
				System.out.println("time1=: "+(end-start));
				System.out.println("LinkedHashMapAdd1: "+show);
			}
			
		});
		Thread thread2=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				String show="";
				TreeMapAdd tma2=new TreeMapAdd();
				Map<String, String> map2=tma2.add();
				System.out.println("size2=:"+map2.size());
				Iterator<String> iter = map2.values().iterator();
				while(iter.hasNext()){
					 String result2 = iter.next();
				      show=show+","+result2;
				   }
				
				long end=System.currentTimeMillis();
				System.out.println("time2=: "+(end-start));
				System.out.println("LinkedHashMapAdd2: "+show);
			}
			
		});

		
		thread1.start();
		thread2.start();

	
	}

}

//TreeMap
//1、TreeMap 可以用于排序，有Comparator对比排序器