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
    while(m <= 3) {   //这里几位数就循环几次                         
       for (int i = 0; i < numbers.length; i++) {
           int lsd = ((numbers[i] / n) % 10);  //数据某一位[个位、十位、百位.......]
           temp[lsd][order[lsd]] = numbers[i]; //出现的次数
           order[lsd]++;
        }
       for (int i = 0; i < d; i++) {    //某一位的数按照顺序循环遍历，1、2、3.......9  
           if (order[i] != 0) 
        	   for (int j = 0; j < order[i]; j++) {
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
//排序步骤：
//1、定义一个二维的零时数组，temp[numbers.length][numbers.length]，定义一个一维的排序数组order[numbers.length]。
//2、((numbers[i] / n) % 10)求数据的个位，order[lsd]跟桶排序一样，order[]下标为结果，order[]值为数值出现的次数值。
//3、temp[存放个位的数][存放个位数桶的值]=numbers[i]。
//4、通过个位进行桶下标i遍历，得到桶里的数据，j遍历桶里的个数，这样就把temp的数据都遍历出来赋值给numbers[]。
//5、然后给桶的值赋为0，在进行下一次读数赋值循环，需要循环10次。
//5、n*10,在对10位进行如此操作，k重新置为0。m++,这里几位数就循环几次，m表示位数。


//解读
//1、这个是将数字分位数处理，先来个位，n=1，((numbers[i] / n) % 10),m=1表示各位。
//2、得到个位数以后，将个位数按照桶排序的方式，order[]的下标是具体的数值，值为出现的次数。
//3、temp[存放个位的数][出现的次数]=numbers[i]，例如345，5是第一次出现，则temp[5][1]=345。
//4、然后进行排序，桶的值表示同一个数字出现的次数，外层按照个位数排序，1、2、3、4.....9拿值，内层按照出现的次数循环。
//5、这样相同的个位数位置是相连的，就按照个位排序完成，个位就从小到大，相同的按位置排序完了。
//6、然后按照十位进行排序、白位进行排序...........一直持续排序下去，根据实际数据位数而定。
//98、69、72、81、38、36、45
//个位排序：81、72、45、36、98、38、69
//十位排序：36、38、45、69、72、81、98
