package com.files;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {  
    public static void main(String[] args) throws Exception {  
    	long start=System.currentTimeMillis();
        // 复制文件  
        Files.copy(Paths.get("D:/io/origin.txt"), new FileOutputStream("D:/io/filesnio.txt"));  
        
        
        // 判断FilesTest.java文件是否为隐藏文件  
        System.out.println("FilesTest.java是否为隐藏文件：" + Files.isHidden(Paths.get("D:/io/filesnio.txt")));  
        
        
        // 一次性读取FilesTest.java文件的所有行  
        List<String> lines = Files.readAllLines(Paths.get("D:/io/filesnio.txt"), Charset.forName("GBK"));
        for(String line:lines){
        System.out.println(line);  
        }
        
        
        // 判断指定文件的大小  
        System.out.println("FilesTest.java的大小为：" + Files.size(Paths.get("D:/io/filesnio.txt"))); 
        
        // 直接将多个字符串内容写入指定文件中,这是新建重写      
        List<String> poem = new ArrayList<>();  
        poem.add("银鞍照白马");  
        poem.add("飒沓如流星");  
        Files.write(Paths.get("D:/io/filesnio1.txt"), poem, Charset.forName("gbk"));  
        
        //这些增加的
        Files.write(Paths.get("D:/io/filesnio1.txt"), poem, Charset.forName("gbk"),StandardOpenOption.APPEND);
        
        // 使用Java 8新增的Stream API列出当前目录下所有文件和子目录  
        Files.list(Paths.get("D:/io")).forEach(path -> System.out.println(path)); 
        
        
        // 使用Java 8新增的Stream API读取文件内容  
        Files.lines(Paths.get("D:/io/filesnio1.txt"), Charset.forName("GBK")).forEach(line -> System.out.println(line));  
        
        
        // 判断C盘的总空间，可用空间  
        FileStore cStore = Files.getFileStore(Paths.get("D:"));  
        System.out.println("D:共有空间：" + cStore.getTotalSpace());  
        System.out.println("D:可用空间：" + cStore.getUsableSpace());  
        
        long end=System.currentTimeMillis();
        System.out.println("用时: "+(end-start));
    }  
}  
