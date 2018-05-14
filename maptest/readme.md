#  map比较  
  
1、HashMap:  
(1)基于哈希表  
(2)无序  
(3)非线程安全  
(4)最多只允许一条记录的key键为Null(多条会覆盖)  
(5)允许多条记录的value值为 Null  
(6)HashSet通过HashMap实现  
  
  
2、HashTable:  
(1)基于哈希表  
(2)无序  
(3)支持线程同步  
(4)key不能为空    
(5)value值不能为空  
  
  
3、LinkedHashMap:  
(1)基于哈希表和双向链表    
(2)保留了插入的顺序  
(3)非线程安全  
(4)最多只允许一条记录的key键为Null(多条会覆盖)     
(5)允许多条记录的value值为 Null   
(6)LinkedHashSet通过LinkedHashMap实现  
  
  
4、TreeMap:  
(1)基于红黑树(自平衡二叉查找树)    
(2)有序,也可以指定排序的比较器    
(3)非线程安全  
(4)key不能为空     
(5)value不能为空   
(6)TreeSet通过TreeMap实现  