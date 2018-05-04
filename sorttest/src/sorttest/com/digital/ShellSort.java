package sorttest.com.digital;

import java.util.Arrays;

//希尔排序
//平均时间复杂度：O(nlogn)-O(n*n)
//最好时间复杂度：O(n^1.3)[n的1.3次方]
//最坏时间复杂度：O(n*n)
//辅助空间：O(1)
//稳定性：不稳定
//分类：插入排序类
public class ShellSort {
	 public void shellSort(int [] numbers){
    	 long start =System.currentTimeMillis();
    	 int len = numbers.length;  
    	 { 
    		  for(int incr=len;incr<0;incr--)//增量递减，以增量3，2，1为例 
    		{ 
    		       for(int L=0;L<(len-1)/incr;L++)//重复分成的每个子列表 
    		{ 
    		    	for(int j =0; j<len; j++){  //对每个子列表应用插入排序 
    		            for(int i = 0; i<len-incr-j;i++){  
    		                int temp = 0;  
    		                   //如果前面的数比后面的数大，则交换位置  
    		               if (numbers[i]>numbers[i+1]){  
    		                temp = numbers[i+incr];  
    		                 numbers[i+incr] = numbers[i];  
    		                numbers[i] = temp;  
    		             }  
    		         }  
    		  } 
    		} 
    	 }
    	 }
        long end =System.currentTimeMillis();
        System.out.println("shellSort: "+(end-start));
        System.out.println("shellSort result: "+Arrays.toString(numbers));  
	
	
	
     }
}
