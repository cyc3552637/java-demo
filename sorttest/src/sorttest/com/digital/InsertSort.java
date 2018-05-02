package sorttest.com.digital;

import java.util.Arrays;

//插入排序，平均时间复杂度为O(n*n)
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
                    for(int m = i-1; m > j-1; m--){  
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
