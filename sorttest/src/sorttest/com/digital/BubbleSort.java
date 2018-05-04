package sorttest.com.digital;

import java.util.Arrays;


//冒泡排序
//平均时间复杂度：O(n*n)
//最好时间复杂度：O(n)
//最坏时间复杂度：O(n*n)
//辅助空间：O(1)
//稳定性：稳定
//分类：交换排序类
public class BubbleSort {
     public void bubbleSort(int [] numbers){
    	 long start =System.currentTimeMillis();
    	 int len = numbers.length;  
         for(int j =0; j<len; j++){  
             for(int i = 0; i<len-1-j;i++){  
                 int temp = 0;  
                 //如果前面的数比后面的数大，则交换位置  
                 if (numbers[i]>numbers[i+1]){  
                     temp = numbers[i+1];  
                     numbers[i+1] = numbers[i];  
                     numbers[i] = temp;  
                 }  
             }  
         }  
        long end =System.currentTimeMillis();
        System.out.println("bubbleSort: "+(end-start));
        System.out.println("bubbleSort result: "+Arrays.toString(numbers));  
	
	
	
     }
}
