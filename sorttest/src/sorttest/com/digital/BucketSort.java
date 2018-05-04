package sorttest.com.digital;

import java.util.Arrays;


//桶排序
//平均时间复杂度：
//最好时间复杂度：
//最坏时间复杂度：
//辅助空间：
//稳定性：
//分类：桶排序类
//桶排序使用线性时间(Θ(n))。但桶排序并不是 比较排序，他不受到 O(n log n) 下限的影响。
public class BucketSort {
	public void bucketSort(int [] numbers){
   	 long start =System.currentTimeMillis();
   	 int min=0;
   	 int max=numbers.length-1;
   	 int[] tmp =new int[numbers.length];

     // buckets用于记录待排序元素的信息

     // buckets数组定义了max-min个桶

     int[]buckets = new int[max - min];

     // 计算每个元素在序列出现的次数

     for (int i= 0; i < numbers.length; i++) {

        buckets[numbers[i] - min]++;//这里有问题，数值不能超过数组大小，比如number[100],number的值要在100以内

     }

     // 计算“落入”各桶内的元素在有序序列中的位置

     for (int i= 1; i < max - min; i++) {

        buckets[i] = buckets[i] + buckets[i - 1];

     }

     // 将data中的元素完全复制到tmp数组中

    System.arraycopy(numbers, 0, tmp, 0, numbers.length);

     // 根据buckets数组中的信息将待排序列的各元素放入相应位置

     for (int k= numbers.length - 1; k >= 0; k--) {

    	 numbers[--buckets[tmp[k] - min]] = tmp[k];

     }
       long end =System.currentTimeMillis();
       System.out.println("bucketSort: "+(end-start));
       System.out.println("bucketSort result: "+Arrays.toString(numbers));  
	
	
	
    }
}
