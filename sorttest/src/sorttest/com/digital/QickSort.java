package sorttest.com.digital;

import java.util.Arrays;


//快速排序
//平均时间复杂度：O(nlogn)
//最好时间复杂度：O(nlogn)
//最坏时间复杂度：O(n*n)
//辅助空间：O(logn)-O(n)
//稳定性：不稳定
//分类：交换排序类
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
              //当退出上一个while的时候说明temp>list[high]  
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
//排序步骤：
//1、数组大于2才能开始排序
//2、排序定义最低值low和最高值high，然后计算middle值
//3、取首元素temp = list[low]作为参考，如果首元素temp<= list[high]，则high--，当找到temp>list[high]时跳出循环，list[low] = list[high]; 
//4、这时候这个元素在跟list[low]比较，当list[low] <= temp,时low++,当找到temp>list[low]时跳出循环
//5、这时候list[high] = list[low]; 并将temp的值付给list[low]，返回low值，这个low值就是middle值。
//6、然后以low到middle-1为区间继续排序，以middle + 1到high为区间继续排序，如此迭代调用。

//注意递归和迭代，迭代是外层输出了在作为下一层的输入，继续往里走，直到条件结束。递归是先执行内部的，内部无法继续递归了就开始执行，内部执行完了才可以执行外部的。


//解读
//1、取数组第一个数为关键数据，它要把所有比它大的放在它的右侧，从右侧开始，直到找到比它小的数temp>list[high]，则跳出循环，并把这个数字作为首数字。
//2、关键数据不变，然后把所有比它小的放在它的左侧，上面从左侧开始，直到找到比它大的数temp<list[low],则跳出循环，这个数填补之前list[high]做首数字留下的空缺。
//3、temp填补list[low]的空缺，并且low为middle返回。这样比它小的都换到了它左边，比它大的都换到了它右边。如下例所示：
//                               [0][1][2][3][4][5]
//                                6、2、7、3、8、9
//                                3     6  7 
//4、下次循环的时候只要下标为(low, middle - 1)和(middle + 1, high)继续排序就可以了，因为temp的值是最中间的值，比它大的都在右侧，比它小的都在左侧，low也是最中间的。
//5、后面只要继续循环就可以了

