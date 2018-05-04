package sorttest.com.digital;

import java.util.Arrays;


//堆排序
//平均时间复杂度：O(nlogn)
//最好时间复杂度：O(nlogn)
//最坏时间复杂度：O(nlogn)
//辅助空间：O(1)
//稳定性：不稳定
//分类：选择排序类
public class HeapSort {
	public void heapsort(int [] numbers){
		
		 long start =System.currentTimeMillis();
		 int len = numbers.length;    
	        //每个节点进行排序  
	        for (int i = 0; i <len-1; i++){  
	            buildMaxHeap(numbers, len-1-i);  
	            swap(numbers, 0, len-1-i);  
	     //       System.out.println("heapSort result: "+Arrays.toString(numbers));  
	              
	        }
	    System.out.println("heapSort result: "+Arrays.toString(numbers)); 
        long end =System.currentTimeMillis();
        System.out.println("heapSort: "+(end-start));
     
	}


   public  void buildMaxHeap(int[] data, int lastIndex){  
    for(int i = (lastIndex-1)/2; i>= 0; i--){  
        //保存当前正在判断的节点  
          
        int k = i;  
        //当前子节点存在  
        while(2*k+1 <= lastIndex){  
            //biggerIndex用来记录最大节点的索引  
            int biggerIndex = 2*k + 1;  
            //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在  
            if (biggerIndex < lastIndex){  
                //如果右子节点的值大于左子节点的值，那么将biggerIndex记录为右子节点的所索引  
                if (data[biggerIndex] < data[biggerIndex+1]){  
                    biggerIndex++;  
                }  
            }  
            if(data[k]<data[biggerIndex]){  
                //如果子节点中的最大值大于父节点的值，那么交换它们。  
                swap(data, k, biggerIndex);  
            }  
            break;  
        }  
       // System.out.println(Arrays.toString(data));  
    }  
}  
     public  void swap(int[] data, int i, int j) {  
      
        int temp = data[i];  
        data[i] = data[j];  
        data[j] = temp;  
    }  

}
