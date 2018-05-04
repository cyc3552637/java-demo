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
		            tmpArr[third++]=data[left++];    
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
