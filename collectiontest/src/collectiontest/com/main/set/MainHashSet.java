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
//速度来看hashset和linkedhashset是要比treeset快的


//HashSet是用hash table 实现的，它其中的元素是无序的，add、remove和contains方法的时间复杂度都是O(1)。
//TreeSet是使用tree 结构实现的（算法书中的红黑树）。它其中的元素是有序的，但是add、remove和contains方法的时间复杂度是 O(log (n))
//LinkedHashSet是介于TreeSet和HashSet之间的，它利用hash table 实现的，同时使用了Link  List，所以它提供了插入的顺序，基本方法的时间复杂度是O(1)。


//如果你想访问set中的任意元素，无疑TreeSet是最快的，因为TreeSet已经排序好了无需再遍历整个数组或者是链表。
//所有的linked实现的结构在访问任意元素上都很慢，但是在移动和替换元素上是很快的。
//HashSet是大多内存要求的，如果你有大量的RAM，并且在你的set中的读写的性能相对合理的话，那么HashSet是个不错的选择。