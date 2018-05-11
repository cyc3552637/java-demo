package collectiontest.com.main.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import collectiontest.com.digital.set.HashSetAdd;





//百万级别，Iterator最快，下来是foreach，然后是for,总体差别不大。
//十万级别，foreach最慢一点

public class MainHashSet {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				HashSetAdd hsd=new HashSetAdd();
				HashSet<String> hs1=hsd.add();
				System.out.println("size1=:"+hs1.size());
				for(String result:hs1){
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
				HashSetAdd hsd=new HashSetAdd();
				HashSet<String> hs2=hsd.add();
				System.out.println("size2=:"+hs2.size());
				Iterator<String> iter = hs2.iterator();
				while(iter.hasNext()){
				      String result = iter.next();
				   }
				
				long end=System.currentTimeMillis();
				System.out.println("time2=: "+(end-start));
			}
			
		});
		
		
		thread1.start();
		thread2.start();

	
	}

}
//hashset、linkedhashset、treeset都不能放重复的数据，只能放不重复的数据，重复的会自动去重