package com.digital;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileLineByte {
	
	//File字节流，加了buffer缓存，没可以设置buffer的大小，默认8192字节，速度比普通的字节流和字符流快了很多
	//比起buffer的字符流要慢.
	//but if though character has messy code problem that need to translate,in my opinion this more speed than BufferCharacter
	public static void byBufferByte(String filePath) {
        File file = new File(filePath);
        BufferedInputStream bufInput = null;
        BufferedOutputStream bufOutput = null;
        try {
            bufInput = new BufferedInputStream(new FileInputStream(file));
            bufOutput = new BufferedOutputStream(new FileOutputStream("d:/io/FileBufferByte.txt"));

            int temp;
            while ((temp = bufInput.read()) != -1) {
            	bufOutput.write(temp);
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (bufInput != null && bufOutput != null) {
                try {
                	bufInput.close();
                	bufOutput.close();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
        }
    }


}
