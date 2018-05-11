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
//hashset、linkedhashset、treeset都不能放重复的数据，只能放不重复的数据，重复的会自动去重

//总结来说：

//1、HashSet：
//(1)基于哈希表
//(2)无序
//(3)适合遍历

//2、LinkedHashSet：
//(1)基于哈希表和链表
//(2)按顺序插入
//(3)适合移动和替换

//3、TreeSet：
//(1)基于红黑树(自平衡二叉查找树)
//(2)有序
//(3)适合单节点查找

//哈希表（Hash table，也叫散列表） 
//是根据关键码值(Key value)而直接进行访问的数据结构。也就是说，它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。这个映射函数叫做散列函数，存放记录的数组叫做散列表。
//例如：hash(key)%len，例如一个长度为16的数组中,哈希的key值为0-15,下标也为0-15,12%16=12,28%16=12,108%16=12,140%16=12。所以12、28、108以及140都存储在数组下标为12的位置。
//[0]  
//[1]
//[2]        
//[3]
//[4]
//[5]    
//[6]    
//[7]    
//[8]    
//[9]
//[10]
//[11]
//[12]    {12} -> {28} -> {108} -> {140}
//[13]
//[14]
//[15]


//链表
//链表是一种物理存储单元上非连续、非顺序的存储结构，数据元素的逻辑顺序是通过链表中的指针链接次序实现的。链表由一系列结点（链表中每一个元素称为结点）组成，结点可以在运行时动态生成。
//每个结点包括两个部分：一个是存储数据元素的数据域，另一个是存储下一个结点地址的指针域。
//单向链表：{(10)[20]}->{(20)[60]}->{(60)[40]}
//双向链表：{[0](10)[20]}<->{[10](20)[60]}->{[20](60)[40]},双向链表何以首尾闭合
//链表不是顺序存储的

//红黑树(自平衡二叉查找树)
//性质1. 节点是红色或黑色。
//性质2. 根节点是黑色。
//性质3 每个叶节点（NIL节点，空节点）是黑色的。
//性质4 每个红色节点的两个子节点都是黑色。(从每个叶子到根的所有路径上不能有两个连续的红色节点)
//性质5. 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。


//                           30
//                          (黑色)                                     
//             80                              70
//           (红色)                           (黑色)
//     50              20                30           90
//   (黑色)           (黑色)            (红色)       (红色)
// NIL   NIL      80         60      NIL    NIL   NIL   NIL
//(黑色) (黑色)  (红色)     (红色)   (黑色) (黑色)(黑色) (黑色)                                                                                          (黑色)
//             NIL  NIL    NIL  NIL 
//           (黑色)(黑色) (黑色)(黑色)