package collectiontest.com.main.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

import collectiontest.com.digital.set.LinkedHashSetAdd;





//百万级别，Iterator最快，下来是foreach，然后是for,总体差别不大。
//十万级别，foreach最慢一点

public class MainLinkedHashSet {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				LinkedHashSetAdd lhsd=new LinkedHashSetAdd();
				LinkedHashSet<String> lhs1=lhsd.add();
				System.out.println("size1=:"+lhs1.size());
				for(String result:lhs1){
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
				LinkedHashSetAdd lhsd=new LinkedHashSetAdd();
				LinkedHashSet<String> lhs2=lhsd.add();
				System.out.println("size2=:"+lhs2.size());
				Iterator<String> iter = lhs2.iterator();
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
