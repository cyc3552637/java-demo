package com.digital;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileNio {
	
	 //速度最快，毫无争议，而且没有乱码，速度比其他快了不至几十倍
	 public static void byteBuffer(String filePath) {
	        FileInputStream in = null;
	        FileOutputStream out = null;
	        try {
	            // 获取源文件和目标文件的输入输出流  
	            in = new FileInputStream(filePath);
	            out = new FileOutputStream("d:/io/ByteBuffer.txt");
	            // 获取输入输出通道
	            FileChannel fcIn = in.getChannel();
	            FileChannel fcOut = out.getChannel();
	            ByteBuffer buffer = ByteBuffer.allocate(1024);
	            while (true) {
	                // clear方法重设缓冲区，使它可以接受读入的数据
	                buffer.clear();
	                // 从输入通道中将数据读到缓冲区
	                int r = fcIn.read(buffer);
	                if (r == -1) {
	                    break;
	                }
	                // flip方法让缓冲区可以将新读入的数据写入另一个通道  
	                buffer.flip();
	                fcOut.write(buffer);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (in != null && out != null) {
	                try {
	                    in.close();
	                    out.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }

}
