package com.digital;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPool {
	public static void main(String[] args) { 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 创建一个线程池  
		ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(5); 
        // 创建线程  
		for (int i = 0; i < 5; i ++){
            final int temp = i + 1;
            exec.schedule(() -> {
                System.out.println("第"+temp+"个炸弹爆炸时间:" + simpleDateFormat.format(new Date()));
            }, temp * 5, TimeUnit.SECONDS);
        }
		exec.shutdown();
        System.out.println("end main时间:" + simpleDateFormat.format(new Date()));
    }

    }  
 

