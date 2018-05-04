#  各类I/O速度比对  
  
1、NIO，速度最快。    
2、File字符流，加了buffer缓存，速度第二。  
3、File字节流，加了buffer缓存，速度跟File字符流差不多，速度第三。  
4、单纯File字符流，速度第四。  
5、单纯File字节流，速度第五。
  
  
#  NIO.files  
  
1、Files工具类基本操作。(FilesTest)  
2、Files工具类操作文件属性。(FilesAttribute)    
3、Files工具类进行文本搜索。(FilesThrough)  
4、Files工具类监测硬盘情况。(FilesWatch)  