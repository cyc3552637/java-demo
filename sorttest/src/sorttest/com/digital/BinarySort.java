package sorttest.com.digital;

import java.util.Arrays;


//折半排序
//平均时间复杂度：O(n*n)
//最好时间复杂度：O(n)
//最坏时间复杂度：O(n*n)
//辅助空间：O(1)
//稳定性：稳定
//分类：插入排序类
public class BinarySort {
	public void binarySort(int [] numbers){
		   	 long start =System.currentTimeMillis();
		   	int length = numbers.length;
		    for(int i=1;i<length;i++){	
		        int temp = numbers[i];
		        int low = 0;
		        int height = i-1;
		        while(low<=height){
		            //找到中间值
		            int mid = (low+height)/2;
		            if(temp>numbers[mid]){
		                //限制在大于中点搜索
		                low = mid+1;
		            }else{
		                //限制在小于中点搜索
		                height = mid-1;
		            }
		        }
		        //将low到i处的所有元素向后整体移一位
		        for(int j=i;j>low;j--){
		        	numbers[j] = numbers[j-1];
		        }
		        //最后将tmp的值插入合适位置
		        numbers[low]=temp;
		    }
       long end =System.currentTimeMillis();
       System.out.println("binarySort: "+(end-start));
       System.out.println("binarySort result: "+Arrays.toString(numbers));  
	
	
	
    }
}
//算法步骤：
//1、取数组位置在(i-1)/2的数numbers[mid],i不包括0.
//2、numbers[i]找位置的过程，如果小于numbers[mid],在小于中点的位置继续对着检索，如果大于numbers[mid],则在大于中点的位置继续对折检索，至到无法对折。
//3、将low位置开始到i位置所有的数都往后移动一位,把number[i]的值插入number[low]位置

//解读:
//1、折半排序实际上是把位置i之前的数据都排好序了,找到位置插入即可。
//2、从i=1开始就跟0位数据进行比较,如果大于则low=1,小于则low=0,第二位数直接插入number[low]就可以了。
//3、这样实际上就是前两个数字有了顺序了,第三位数(i=2)只要找到前两个数中合适位置,如果i=low(low不可能大于i,low最多到high)说明i是low本身,不需要low后移腾出位置,否则将low到i位置数后移,将数插入移动后的空挡就行了。
//4、插入的时候,大于中位数肯定是值大的,小于中位数肯定是值小的,这样折半检索其实就是值在排序了。
//4、以此类推,后面的每一个数都是前面排好的序列基础上找到合适位置插入即可。

