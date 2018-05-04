#  内容  
  
ListTest分别用lambda和foreach遍历判定list循环，速度而言少量数据foreach快，大量数据lambda速度会接近foreach  
ListTest2将线程方式也做了lambda和java原生的区分，速度而言java原生的快  
配合JVM调优测试 https://blog.csdn.net/cyc3552637/article/details/79913254  