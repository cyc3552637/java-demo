package sorttest.com.digital;

import java.util.Arrays;

//插入排序
//平均时间复杂度：O(n*n)
//最好时间复杂度：O(n)
//最坏时间复杂度：O(n*n)
//辅助空间：O(1)
//稳定性：稳定
//分类：插入排序类
public class InsertSort {
	public  void insertSort(int [] numbers){
		long start =System.currentTimeMillis();
		 int len = numbers.length;  
		for (int i = 1; i < len; i++){  
            for(int j = 0; j < i; j++){  
                int temp = 0;  
                if (numbers[i] < numbers[j]){  
                    temp = numbers[i];  
                    //依次把numbers[m]的值赋给number[m+1]  
                    for(int m = i-1; m > j-1; m--){ //这里如果非整数，最好是m>=j 
                        numbers[m+1] = numbers[m];  
                    }  
                    //交换number[i]和numbers[j]的值  
                    numbers[j] = temp;  
                }  
            }  
        }  
        long end =System.currentTimeMillis();
        System.out.println("insertSort: "+(end-start));
        System.out.println("insertSort result: "+Arrays.toString(numbers));  
    }


}
//算法步骤
//1、数组嵌套循环。
//2、外层正序循环，从1开始，内层从0开始循环，小于外层循环。
//3、然后循环判断，内层的数 numbers[j]大于外层的数numbers[i]，则内层的数后延，外层的数占据内层数的位置。
//3、所有的数字都排序比较一遍。


//解读
//1、外层循环是从数组numbers中依次取值，内层循环是取从0开始到外层取值数之间的所有数。
//2、也就是说从0开始到取值数之前的所有数，跟取值数进行一个判断，比取值数大就整个数组后移。移动范围从取值数前一位开始，到判断数本身。
//3、如此循环，每个数都跟前序的所有数比一遍，找到自己的位置然后插入即可。
//4、由于是从小到大循环的，所以任何数字的前序数字都是有序的。

//7、6、9、5、8
//6、7
//6、7、9
//5、6、7、9
//5、6、7、8、9

