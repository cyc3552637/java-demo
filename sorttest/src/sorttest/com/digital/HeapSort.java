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
                if (data[biggerIndex] < data[biggerIndex+1]){ //这里有两种方式
//                    biggerIndex++;                          //方法一：可以将最大索引biggerIndex记为值大的右节点    
                	 swap(data, biggerIndex, biggerIndex+1);  //方法二：也可以左右节点值交换。
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
//算法步骤
//1、将要排序的数组numbers和数组最后一个索引传入排序算法，最后一个索引按照循环方式传入不断往前遍历。
//2、把节点索引分为二叉树结构，二叉树左右节点同级别，i = (lastIndex-1)/2得到当前要判断的节点，循环遍历。
//3、biggerIndex = 2*k + 1用来记录最大节点的索引，索引biggerIndex如果小于lastIndex表示K含有右子节点。
//4、有子节点需要做值得判断，判断以后如果右子节点的值大于左子节点的值，这里有两种方式，可以将最大索引biggerIndex记为值大的右节点，也可以左右节点值交换。
//5、如果子节点中的最大值data[biggerIndex]大于父节点的值data[k]，那么交换它们。
//6、在数组中将lastIndex的值和0索引的值进行交换，往复循环。


//解读

//6、7、3、20、17、8


//               6[0]
//       7[1]            3[2]
//  20[3]   17[4]     8[5] 


//1、i=k=(lastIndex-1)/2得到的是顶层节点[0]、[1]、[2]，循环得到这些节点。
//2、2k+1则为本节点下面的左子节点，[2]的子节点为[5]，[1]子节点为[3]。
//3、这里要判断一下，2k+1必须要小于lastIndex，如果大于就说明该节点不存在了，2k+1可以先看作最大索引biggerIndex。
//4、如果右节点的值大于左节点的值，这里有两种方式，可以将最大索引biggerIndex记为值大的右节点，也可以左右节点值交换。
//5、判断最大子节点和父节点的值，子节点大就跟父节点交换，如此操作以后，完成一次循环，二叉树顶节点就是此次排序最大值。
//6、二叉树定点是最大值，也就是numbers[0]是最大值，这时候numbers[0]的值跟最后一个numbers[lastindex]的值交换。
//7、这样就把最大一个值放到最后了，而且这里还有一个作用，让最大值在下次循环二叉树中放最后节点。numbers[0]里原来是最大值
//现在放入的是二叉树最后节点的值，原来最后节点的值不在顶端，所以肯定不是最大值，这样它可以参加下次排序，而原来的最大值不
//参与下一次二叉树排序，这样第二大的数值就可以找到替换了，如此循环，所有数都可以按最大值找到排序。