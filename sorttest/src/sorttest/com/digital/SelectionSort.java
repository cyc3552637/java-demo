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
//排序步骤
//1、外层循环一次取出数组所有的数。
//2、内层循环一次出去本次数后面的所有数，与之做比较，如果小于它，跟它交换下标位置，这样就得到最小数的下标。
//3、下标不是本身的话，直接交换数据，每趟交换一次。
//4、取下一个数往下依次循环。

//解读
//1、就是依次取数与其后面的数比较，遇到比它小的就交换下标，继续往后寻找，直到知道最小的数的下标，与最初取得数交换。
//2、如此依次往下取，之前排序好的数不再参加下面的取数排序，最终排序完成。

//7、3、2、6、8、1
//【1】、7、3、2、6、8
//【1】、【2】、7、3、6、8
//【1】、【2】、【3】、7、6、8
//【1】、【2】、【3】、【6】、7、8
//【1】、【2】、【3】、【6】、【7】、8