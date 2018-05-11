package collectiontest.com.main.set;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import collectiontest.com.digital.set.TreeSetAdd;



//百万级别，Iterator最快，下来是foreach，然后是for,总体差别不大。
//十万级别，foreach最慢一点

public class MainTreeSet {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				TreeSetAdd tsd=new TreeSetAdd();
				TreeSet<String> ts1=tsd.add();
				System.out.println("size1=:"+ts1.size());
				for(String result:ts1){
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
				TreeSetAdd tsd=new TreeSetAdd();
				TreeSet<String> ts2=tsd.add();
				System.out.println("size2=:"+ts2.size());
				Iterator<String> iter = ts2.iterator();
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
