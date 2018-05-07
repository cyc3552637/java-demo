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

//算法步骤
//1、去数组嵌套循环。
//2、外层正序循环，内层比较，如果前面的比后面的数字大则交换位置。
//3、所有的数字都排序比较一遍。

//解读
//1、从第一个位置开始,第一个跟后面比较,大于后面就交换,小于不交换。
//2、如果交换以后,又作为下一位数跟后面的数据比较,大于后面就交换,小于不交换。
//3、上述内层循环保证保证了外层循环,每循环一次就能得到最后一个数字是最大数。
//4、这样下次最后一个数字就不用排了,前面的继续排就好了。


