package com.files;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.Date;
import java.util.List;

public class FilesAttribute {
	 public static void main(String[] args) throws Exception {  
	        // 获取将要操作的文件  
	        Path testPath = Paths.get("D:/io/filesnio.txt");  
	        // 获取访问基本属性的BasicFileAttributeView  
	        BasicFileAttributeView basicView = Files.getFileAttributeView(testPath, BasicFileAttributeView.class);  
	        // 获取访问基本属性的BasicFileAttributes  
	        BasicFileAttributes basicAttribs = basicView.readAttributes();  
	        System.out.println("创建时间：" + new Date(basicAttribs.creationTime().toMillis()));  
	        System.out.println("最后访问时间：" + new Date(basicAttribs.lastAccessTime().toMillis()));  
	        System.out.println("最后修改时间：" + new Date(basicAttribs.lastModifiedTime().toMillis()));  
	        System.out.println("文件大小：" + basicAttribs.size());  
	        // 获取访问文件属主信息的FileOwnerAttributeView  
	        FileOwnerAttributeView ownerView = Files.getFileAttributeView(testPath, FileOwnerAttributeView.class);
	        //获取访问文件的所属用户
	        System.out.println(ownerView.getOwner());  
	        // 获取访问DOS属性的DosFileAttributeView  
	        DosFileAttributeView dosView = Files.getFileAttributeView(testPath, DosFileAttributeView.class);  
	        // 将文件设置隐藏、只读  
	        dosView.setHidden(true);  
	        dosView.setReadOnly(true);  
	    }  
}
