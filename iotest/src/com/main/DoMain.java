package com.main;

import com.digital.FileByte;
import com.digital.FileCharacter;
import com.digital.FileLineByte;
import com.digital.FileLineCharacter;
import com.digital.FileNio;

public class DoMain {
	private static final String FILE_PATH = "d:/io/origin.txt";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread filebytethread=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				FileByte fb=new FileByte();
				fb.byByte(FILE_PATH);
				long end=System.currentTimeMillis();
				System.out.println("FileByte is :"+(end-start));
			}
			
			
			
		});
		
		Thread filecharacterthread=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				FileCharacter fc=new FileCharacter();
				fc.byCharacter(FILE_PATH);
				long end=System.currentTimeMillis();
				System.out.println("Filecharacter is :"+(end-start));
				
			}
			
			
		});
		
		Thread filelinebytethread=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				FileLineByte fib=new FileLineByte();
				fib.byBufferByte(FILE_PATH);
				long end=System.currentTimeMillis();
				System.out.println("Filelinebyte is :"+(end-start));
				
			}
			
			
		});
		
		Thread filelinecharacterthread=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				FileLineCharacter fic=new FileLineCharacter();
				fic.byBufferCharacter(FILE_PATH);
				long end=System.currentTimeMillis();
				System.out.println("Filelinecharacter is :"+(end-start));
				
			}
			
			
		});
		
		Thread fileniothread=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long start=System.currentTimeMillis();
				FileNio fn=new FileNio();
				fn.byteBuffer(FILE_PATH);
				long end=System.currentTimeMillis();
				System.out.println("Filenio is :"+(end-start));
				
			}
			
			
		});
		filecharacterthread.start();
		filebytethread.start();
		filelinecharacterthread.start();
		filelinebytethread.start();
		fileniothread.start();
	}

}
