package sorttest.com.digital;

import java.util.Arrays;

//直接排序
//平均时间复杂度：O(n*n)
//最好时间复杂度：O(n*n)
//最坏时间复杂度：O(n*n)
//辅助空间：O(1)
//稳定性：不稳定
//分类：选择排序类
public class StraightSort {
	public void straightSort(int [] numbers){
   	 long start =System.currentTimeMillis();
   	 for (int i = 0; i < numbers.length-1; i++) {
         for (int j = i+1; j < numbers.length; j++) {
             if (numbers[i] > numbers[j]) {
                 int temp = numbers[i];
                 numbers[i] = numbers[j];
                 numbers[j] = temp;
             }
         }
     }
       long end =System.currentTimeMillis();
       System.out.println("straightSort: "+(end-start));
       System.out.println("straightSort result: "+Arrays.toString(numbers));  
	
	
	
    }
}
