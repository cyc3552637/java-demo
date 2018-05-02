package sorttest.com.digital;

import java.util.Arrays;

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
