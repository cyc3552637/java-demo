package sorttest.com.digital;

import java.util.Arrays;

//选择排序
//平均时间复杂度：O(n*n)
//最好时间复杂度：O(n*n)
//最坏时间复杂度：O(n*n)
//辅助空间：O(1)
//稳定性：不稳定
//分类：选择排序类
public class SelectionSort {
	public void selectSort(int [] numbers){
	   	 long start =System.currentTimeMillis();
	   	for (int i = 0; i < numbers.length-1; i++) {
            //minIndex永远保留本次比较中的最小值的索引
            int minIndex = i;
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[minIndex] > numbers[j]) {
                     minIndex = j;
                }
            }
            //每趟比较最多交换一次
            if(minIndex!=i){
            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
            }
        }
	       long end =System.currentTimeMillis();
	       System.out.println("selectSort: "+(end-start));
	       System.out.println("selectSort result: "+Arrays.toString(numbers));  
		
		
		
	    }
}
