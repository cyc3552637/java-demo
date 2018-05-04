package sorttest.com.digital;

import java.util.Arrays;


//基数排序
//平均时间复杂度：
//最好时间复杂度：
//最坏时间复杂度：
//辅助空间：
//稳定性：
//分类：基数排序类
public class RadixSort {
	public void redixSort(int [] numbers){
   	 long start =System.currentTimeMillis();
   	int k= 0;
    int n= 1;
    int m= 1;
    int d=10;
   int[][] temp = new int[numbers.length][numbers.length];
    int[]order = new int[numbers.length];
    while(m <= d) {
       for (int i = 0; i < numbers.length; i++) {
           int lsd = ((numbers[i] / n) % 10);
           temp[lsd][order[lsd]] = numbers[i];
           order[lsd]++;
        }
       for (int i = 0; i < d; i++) {
           if (order[i] != 0) for (int j = 0; j < order[i]; j++) {
        	   numbers[k] = temp[i][j];
               k++;
           }
            order[i] = 0;
        }
        n*= 10;
        k= 0;
       m++;

    }

       long end =System.currentTimeMillis();
       System.out.println("redixSort: "+(end-start));
       System.out.println("redixSort result: "+Arrays.toString(numbers));  
	
	
	
    }
}
