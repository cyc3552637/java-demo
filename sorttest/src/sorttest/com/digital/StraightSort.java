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

//排序步骤：
//1、外层循环依次读取所有的数，内层循环读取从概该数以后所有的数。
//2、然后进行比对，如果概述大于后面的数，直接跟后面的数进行交换，交换以后，numbers[i]就是较小值了，再跟剩下后面的比对。
//3、如此往复循环，直到所有数据取完。


//解读
//1、取key数跟后面的比对，比对大的就交换，key数值也就变为了较小的值，继续跟剩下的比对交换。这样每次key数都是最小值。
//2、如此往复，上次的key数不再参与下次比较，直到所有最小值的数都被依次排序找出。
//3、它跟选择排序是一样的，只是这个直接选择排序是交换值，而选择排序只是更改数组下标，这样选择排序就更加高效一点。


//7、3、2、6、8、1
//【1】、7、3、6、8、2
//【1】、【2】、7、6、8、3
//【1】、【2】、【3】、7、8、6
//【1】、【2】、【3】、【6】、8、7
//【1】、【2】、【3】、【6】、【7】、8
