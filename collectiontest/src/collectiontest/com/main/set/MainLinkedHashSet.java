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

//hashset、linkedhashset、treeset都不能放重复的数据，只能放不重复的数据，重复的会自动去重


//一.HashSet
//特点：
//1.HashSet中不能有相同的元素，可以有一个Null元素，存入的元素是无序的。
//2.HashSet如何保证唯一性？
//1).HashSet底层数据结构是哈希表，哈希表就是存储唯一系列的表，而哈希值是由对象的hashCode()方法生成。
//2).确保唯一性的两个方法：hashCode()和equals()方法。
//3.添加、删除操作时间复杂度都是O(1)。
//4.非线程安全

//二.LinkedHashSet
//特点：
//1.LinkedHashSet中不能有相同元素，可以有一个Null元素，元素严格按照放入的顺序排列。
//2.LinkedHashSet如何保证有序和唯一性？
//1).底层数据结构由哈希表和链表组成。
//2).链表保证了元素的有序即存储和取出一致，哈希表保证了元素的唯一性。
//3.添加、删除操作时间复杂度都是O(1)。
//4.非线程安全



//三.TreeSet
//特点：
//1.TreeSet是中不能有相同元素，不可以有Null元素，根据元素的自然顺序进行排序。
//2.TreeSet如何保证元素的排序和唯一性？
//底层的数据结构是红黑树(一种自平衡二叉查找树)
//3.添加、删除操作时间复杂度都是O(log(n))
//4.非线程安全
