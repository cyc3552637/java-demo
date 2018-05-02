package sorttest.com.digital;

import java.util.Arrays;

public class QickSort {
      public void quickSort(int [] numbers){
    	  long start =System.currentTimeMillis();
    	  int len = numbers.length;  
          //如果数组大于2的时候才开始排序  
          if(len>1){  
              quickSort(numbers,0,len-1);  
          }  
          long end =System.currentTimeMillis();
          System.out.println("quickSort: "+(end-start));
          System.out.println("quickSort result:"+Arrays.toString(numbers));  
      }  
      public static void  quickSort(int[] list, int low, int high) {  
          if(low < high){  
              int middle = getMiddle(list, low, high);  
              quickSort(list, low, middle - 1);  
              quickSort(list, middle + 1, high);  
          }  
      }  
      public static int  getMiddle(int[] list, int low, int high) {  
          //将首元素作为参考元素  
          int temp = list[low];  
          while(low < high){  
              while(low < high && temp <= list[high]){  
                  high--;  
              }  
              //当退出上一个while的时候说明temp>=list[high]  
              list[low] = list[high];  
              while(low < high && list[low] <= temp){  
                  low++;  
              }  
              //当退出上一个while循环的时候，说明list[low]>temp  
              list[high] = list[low];  
          }  
          list[low] = temp;  
          return low;  
      }  
}
