package maptest.com.main;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import maptest.com.digital.HashMapAdd;
import maptest.com.digital.LinkedHashMapAdd;



public class MainLinkedHashMap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				String show="";
				LinkedHashMapAdd lhmd1=new LinkedHashMapAdd();
				Map<String, String> map1=lhmd1.add();
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
				LinkedHashMapAdd lhmd2=new LinkedHashMapAdd();
				Map<String, String> map2=lhmd2.add();
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

//1、一般情况下，我们用的最多的是HashMap。HashMap里面存入的键值对在取出的时候是随机的，它根据键的HashCode值存储数据，根据键可以直接获取它的值，具有很快的访问速度。在Map 中插入、删除和定位元素，HashMap 是最好的选择。
//2、TreeMap取出来的是排序后的键值对。但如果您要按自然顺序或自定义顺序遍历键，那么TreeMap会更好。
//3、LinkedHashMap 是HashMap的一个子类，如果需要输出的顺序和输入的相同,那么用LinkedHashMap可以实现,它还可以按读取顺序来排列，像连接池中可以应用。