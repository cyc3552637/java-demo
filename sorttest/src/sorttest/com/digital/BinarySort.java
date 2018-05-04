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
