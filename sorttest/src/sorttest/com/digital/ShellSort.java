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
    	 int h = 1;  
         while (h <= numbers.length / 3) {  
             h = h * 3 + 1;  
         }  
         while (h > 0) {  
             for (int i = h; i < numbers.length; i += h) {  
                 if (numbers[i] < numbers[i - h]) {  
                     int tmp = numbers[i];  
                     int j = i - h;  
                     while (j >= 0 && numbers[j] > tmp) {  
                    	 numbers[j + h] = numbers[j]; //numbers[j + h]等于numbers[i] 
                    	                             //numbers[j]等于numbers[i - h]
                    	 
                    	 j -= h;                     //如果可以跨多次，多次都需要排序比较 
                     }  
                     numbers[j + h] = tmp;           //这里的numbers[j + h]等于numbers[i - h - h + h]= numbers[i - h]

                 }  
             }  
             // 计算出下一个h值  
             h = (h - 1) / 3;  
         }  
        long end =System.currentTimeMillis();
        System.out.println("shellSort: "+(end-start));
        System.out.println("shellSort result: "+Arrays.toString(numbers));  
	
	
	
     }
}
//排序步骤
//1、计算跨度序列,当h <= numbers.length / 3,h=h * 3 + 1,h从1开始。
//2、外层循环，从h开始取数，一直取到numbers.length，每次都增加h,h表示的就是跨度。
//3、如果一个数小于它左边跨度距离的数numbers[i - h]时，将该数放入临时变量tmp = numbers[i]。
//4、然后判断i - h是否大于零，小于零就越界了，numbers[j + h]等于numbers[i]，numbers[j]等于numbers[i - h]。
//5、然后交换，将numbers[i - h]值赋予numbers[i], j -= h,则numbers[j + h]=numbers[i - h - h + h]= numbers[i - h]。
//6、 j -= h; 多次跨度都需要排序，排序以后将最小的移动到最左侧。
//7、重新计算h值， h = (h - 1) / 3，减少跨度继续排序。

//解读
//1、希尔排序是按照跨度值进行跨度的排序，比如跨度值为4，那这个数就跟左侧4个跨度的数比较，如果左侧有多个4个跨度，比如8个跨度的，也有二次比较。
//2、比较以后，凡是能达到4的倍数跨度的数，进行排序，数值最小的在最左侧，然后下次修改跨度进行下一次排序。
//3、跨度计算，h初始值为1，当h <= numbers.length / 3时h=h * 3 + 1，下个跨度 h = (h - 1) / 3。
//4、替换的时候，先定位，然后位置变化，把位置都替代过来，最后留着空的位置，temp赋值即可。


//  [0] [1] [2] [3] [4] [5] [6] [7] [8] [9]
//  17,  3,  2,  1,  8,  5,  9,  7,  4,  11

//第一次排序(跨度为4)
//  8,  3,  2,  1,  17,  5,  9,  7,  4,  11  temp=numbers[4],比较的numbers[0]
//  7,  3,  2,  1,  8,  5,  9,  17,  4,  11  temp=numbers[8],比较的numbers[4]和numbers[0]

//第二次排序(跨度为1)
//  3,  7,  2,  1,  8,  5,  9,  17,  4,  11  temp=numbers[1]
//  2,  3,  7,  1,  8,  5,  9,  17,  4,  11  temp=numbers[2]
//  1,  2,  3,  7,  8,  5,  9,  17,  4,  11  temp=numbers[3]
//  1,  2,  3,  7,  8,  5,  9,  17,  4,  11  temp=numbers[4]
//  1,  2,  3,  5,  7,  8,  9,  17,  4,  11  temp=numbers[5]
//  1,  2,  3,  5,  7,  8,  9,  17,  4,  11  temp=numbers[6]
//  1,  2,  3,  5,  7,  8,  9,  17,  4,  11  temp=numbers[7]
//  1,  2,  3,  4,  5,  7,  8,  9,  17,  11  temp=numbers[8]
//  1,  2,  3,  4,  5,  7,  8,  9,  11,  17  temp=numbers[9]