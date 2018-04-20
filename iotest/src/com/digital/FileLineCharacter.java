package com.digital;

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

public class FileLineCharacter {
	
	//File字符流，加了buffer缓存，没可以设置buffer的大小，默认8192字节，速度比普通的字节流和字符流快了很多
	//this is more speed than BufferByte,but BufferCharacter has messy code problem,we need to translate
	public static void byBufferCharacter(String filePath) {
        File file = new File(filePath);
        BufferedReader bufReader = null;
        BufferedWriter bufWriter = null;
        try {
            bufReader = new BufferedReader(new FileReader(file));
            bufWriter = new BufferedWriter(new FileWriter("d:/io/FileBufferCharacter.txt"));
            String temp = null;
            while ((temp = bufReader.readLine()) != null) {
                bufWriter.write(temp+"\n");
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (bufReader != null && bufWriter != null) {
                try {
                    bufReader.close();
                    bufWriter.close();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
        }
    }


}
