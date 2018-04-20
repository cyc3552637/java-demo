package com.digital;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileByte {
	
	
	//File字节流，实际测试速度最慢，而且明显很慢
	public static void byByte(String filePath) {
        File file = new File(filePath);  
        InputStream ins = null;
        OutputStream outs = null;
        try {
            ins = new FileInputStream(file);
            outs = new FileOutputStream("d:/io/FileByte.txt");
            int temp;
            while ((temp = ins.read()) != -1) {
                outs.write(temp);
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (ins != null && outs != null) {
                try {
                    outs.close();
                    ins.close();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
        }
    }

}
