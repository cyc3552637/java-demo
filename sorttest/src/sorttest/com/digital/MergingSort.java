package sorttest.com.digital;

import java.util.Arrays;

//归并排序
//平均时间复杂度：O(nlogn)
//最好时间复杂度：O(nlogn)
//最坏时间复杂度：O(nlogn)
//辅助空间：O(n)
//稳定性：稳定
//分类：归并排序类
public class MergingSort {
	public void mergingSort(int [] numbers){ 
		 long start =System.currentTimeMillis();
		    sort(numbers,0,numbers.length-1);    
		    long end =System.currentTimeMillis();
	         System.out.println("mergingSort: "+(end-start));
	         System.out.println("mergingSort result: "+Arrays.toString(numbers)); 
		}  
	       
		public void sort(int[] data, int left, int right) {    
		    // TODO Auto-generated method stub    
		    if(left<right){    
		        //找出中间索引    
		        int center=(left+right)/2;    
		        //对左边数组进行递归    
		        sort(data,left,center);    
		        //对右边数组进行递归    
		        sort(data,center+1,right);    
		        //合并    
		        merge(data,left,center,right);    
		            
		    }    
		}    
		public void merge(int[] data, int left, int center, int right) {    
		    // TODO Auto-generated method stub    
		    int [] tmpArr=new int[data.length];    
		    int mid=center+1;    
		    //third记录中间数组的索引    
		    int third=left;    
		    int tmp=left;    
		    while(left<=center&&mid<=right){    
		    
		   //从两个数组中取出最小的放入中间数组    
		        if(data[left]<=data[mid]){    
		            tmpArr[third++]=data[left++]; //left++，先赋值在+1，++left，先+1再赋值   
		        }else{    
		            tmpArr[third++]=data[mid++];    
		        }    
		    }    
		    //剩余部分依次放入中间数组    
		    while(mid<=right){    
		        tmpArr[third++]=data[mid++];    
		    }    
		    while(left<=center){    
		        tmpArr[third++]=data[left++];    
		    }    
		    //将中间数组中的内容复制回原数组    
		    while(tmp<=right){    
		        data[tmp]=tmpArr[tmp++];    
		    }    
		   // System.out.println(Arrays.toString(data));    
		}    

}
//算法步骤
//1、数组numbers,left=0,right=numbers.length-1。
//2、如果左left小于右right,则 center=(left+right)/2;
//3、分别对左侧和右侧进行循环内递归排序，sort(data,left,center)，sort(data,center+1,right);
//4、将每次递归到的，left、right、center进行合并。
//5、定义一个临时数组tmpArr，定义中间的值mid=center+1，third=left用以记录临时数组的索引。
//6、当left小于center并且mid小于right的时候，判断取data[left]和data[mid]数，放到tmpArr[third++]临时数组。
//7、其他剩余部分依次放入临时数组 。
//8、将临时数组中的内容复制回原数组


//解读
//7[0]、1[1]、3[2]、6[3]、5[4]、2[5]


//        7[0]、1[1]、3[2]、6[3]、5[4]、2[5]
//    7[0]、1[1]、3[2]           6[3]、5[4]、2[5]
//   7[0]、1[1]                6[3]、5[4]
//    1[0]、7[1]、3[2]           5[3]、6[4]、2[5]
//        1[0]、3[1]、7[2]、2[3]、5[4]、6[5]
//        1[0]、2[1]、3[2]、5[3]、6[4]、7[5]

//1、将数据进行分堆,因为归并排序是递归调用的，所以最内层的堆必须执行完才能执行外层的堆。
//2、上面的堆开始排序合并，排序就是比较，小的先放入零时数组中，然后自身序号增加循环判断，然后零时数组序号也增加。
//3、放完以后，剩余的继续放入零时数组中，零时数组依然序号增加。
//4、将排序号的重新放回原数组的位置，原数组的小堆已经拍好的序，然后进行外层的堆排序，外层还是从头开始但是是基于新顺序的数组进行。

//这个最精妙的是合并排序的设计，left<=center&&mid<=right保证了范围，data[left]<=data[mid]谁小谁的值存入零时数组。
//同时自己参数增加，这样就像指针一样直接指向下一个位置了。然后剩余部分mid和left谁没有超出范围，说明谁没有指到头，也就说明
//谁存在最大数，只有最大数才会剩下来，剩下就是递归由内到外不断重新排序，不断替换的过程了。tmp也很巧妙，精确的为数据回填定了位。