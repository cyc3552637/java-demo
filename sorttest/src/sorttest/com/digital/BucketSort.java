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
//算法步骤
//1、桶排序，将建立一个数组，作为桶数组，桶数组是记录次数的。
//2、桶数组的下标为numbers[i]的值 - min，这样number数组的相同的值，就会由同一个下标的bucket数组自增+1值来记录次数。
//3、上面记次数注意，数值不能超过数组大小，比如number[100],number的值要在100以内。
//4、 buckets[]进行重新赋值排序
//4、将numbers[]复制到tmp[]
//5、根据buckets数组中的信息将待排序列的各元素放入相应位置。

//解读
//1、先建桶数组bucket[]，桶数组本身无意义，它的下标是我们需要的值。
//2、然后把numbers[]数组的值作为桶数组的下标，有重复值的记录多条，桶数组的值是重复数量，桶数组的下标是实际值。
//3、buckets[i] = buckets[i] + buckets[i - 1]实际就是排序了，应为i小，就表示numbers[]的值小，bucket的值也给设小
//4、最后取值的时候，根据k的值来取值，这时候buckets[]的值是作为numbers[]的位置。
//5、也就是说bucket[]值大的，表示老的numbers[]值大的，在新的numbers[]数组中位置是靠后的。
//6、这里因为处理重复的数据，所以拿出的时候是--buckets[],这里有两个作用，1、记录的重复的数都能读取到。2、相同的数位置相连。
//7、bucket[]数组的值非常精巧，里面存储的是numbers[]值出现的次数，这样就可以看作值是占位的，1表示有1个数，3表示有3个数。
//bucket[0]=1,bucket[1]=3,bucket[2]=1。这样求和排序，bucket[1]=4,bucket[2]=5，也就是说到bucket[2]一共有5个数的位置。
//上面说过也就是说bucket[]值大的，表示老的numbers[]值大的，在新的numbers[]数组中位置是靠后的。所以这个位置就是numbers的数字占位位置。