package com.digital;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCharacter {
	
	//File字符流，实际测试速度比file字节流快了很多，但是倒数第二慢，有乱码问题，如果转码消耗更大
	public static void byCharacter(String filePath) {
        File file = new File(filePath);
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader(file);
            writer = new FileWriter("d:/io/FileCharacter.txt");
            int temp;
            while ((temp = reader.read()) != -1) {
                writer.write((char)temp);
            }
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            if (reader != null && writer != null) {
                try {
                    reader.close();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
